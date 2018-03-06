package chris.dev.com.dexcomchallenge.data.remote;

import android.os.Environment;

import java.io.File;

import io.reactivex.Observable;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chris on 2/28/2018.
 */

public class RemoteDataSource
{
    private static String baseURL;
    
    public RemoteDataSource(String baseURL)
    {
        this.baseURL = baseURL;
    }
    
    private static OkHttpClient httpClientConfig(HttpLoggingInterceptor interceptor)
    {
        File httpCacheDirectory = new File(Environment.getExternalStorageDirectory(), "HttpCache");// Here to facilitate the file directly on the SD Kagan catalog HttpCache in ， Generally put in context.getCacheDir() in
        
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);
        return new OkHttpClient.Builder().cache(cache).addInterceptor(interceptor).build();
        
    }
    
    private static HttpLoggingInterceptor loggingInterceptor()
    {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return  httpLoggingInterceptor;
    }
    
    public static Retrofit create()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(httpClientConfig(loggingInterceptor()))
                //add converter to parse the response
                .addConverterFactory(GsonConverterFactory.create())
                //add call adapter to convert the response to RxJava observable
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        
        return retrofit;
    }
    
    public static Observable<BookResponse> getWeather()
    {
        Retrofit retrofit = create();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        return remoteService.getBooks();
    }
}
