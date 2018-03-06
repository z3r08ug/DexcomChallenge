package chris.dev.com.dexcomchallenge.di.app;

import chris.dev.com.dexcomchallenge.data.remote.RemoteDataSource;
import dagger.Module;
import dagger.Provides;

/**
 * Created by chris on 2/28/2018.
 */
@Module
public class AppModule
{
    String baseURL;
    
    public AppModule(String baseURL)
    {
        this.baseURL = baseURL;
    }
    
    @Provides
    RemoteDataSource providesRemoteDataSource()
    {
        return new RemoteDataSource(baseURL);
    }
}
