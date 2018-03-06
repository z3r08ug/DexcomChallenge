package chris.dev.com.dexcomchallenge.di.app;

import chris.dev.com.dexcomchallenge.di.main.MainComponent;
import chris.dev.com.dexcomchallenge.di.main.MainModule;
import dagger.Component;

/**
 * Created by chris on 2/28/2018.
 */

@Component(modules = AppModule.class)
public interface AppComponent
{
    MainComponent add(MainModule mainModule);
}
