package chris.dev.com.dexcomchallenge.data.remote;

import chris.dev.com.dexcomchallenge.util.Constants;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by chris on 2/28/2018.
 */

public interface RemoteService
{
    //{Your_API_key_here}/{latitude},{longitude}
    //https://api.darksky.net/forecast/5adb24732494b6406e9a7e6cb508b6dd/37.8267,-122.4233
    @GET("forecast/"+ Constants.ENDPOINT)
    Observable<BookResponse> getBooks();
    
//    @GET("events/search/?location.within=5mi&location.latitude=33.892352&location.longitude=-84.473927&token=RJIAO2HDTRE37F4CDHOF")
//    Observable<EventsResponse> getEvents();
}
