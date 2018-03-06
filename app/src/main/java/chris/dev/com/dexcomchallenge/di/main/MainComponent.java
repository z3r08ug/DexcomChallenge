package chris.dev.com.dexcomchallenge.di.main;


import javax.inject.Singleton;

import chris.dev.com.dexcomchallenge.view.main.MainActivity;
import dagger.Subcomponent;

/**
 * Created by chris on 2/28/2018.
 */
@Subcomponent(modules = MainModule.class)
@Singleton
public interface MainComponent
{
    void inject(MainActivity mainActivity);
}
