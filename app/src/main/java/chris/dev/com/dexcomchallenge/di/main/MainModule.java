package chris.dev.com.dexcomchallenge.di.main;

import javax.inject.Singleton;

import chris.dev.com.dexcomchallenge.data.remote.RemoteDataSource;
import chris.dev.com.dexcomchallenge.view.main.MainPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by chris on 2/28/2018.
 */
@Module
public class MainModule
{
    @Provides
    @Singleton
    MainPresenter providerMainPresenter(RemoteDataSource remoteDataSource)
    {
        return new MainPresenter(remoteDataSource);
    }
}
