package chris.dev.com.dexcomchallenge.application;

import android.app.Application;
import android.content.Context;

import chris.dev.com.dexcomchallenge.di.app.AppComponent;
import chris.dev.com.dexcomchallenge.di.app.AppModule;
import chris.dev.com.dexcomchallenge.di.app.DaggerAppComponent;
import chris.dev.com.dexcomchallenge.di.main.MainComponent;
import chris.dev.com.dexcomchallenge.di.main.MainModule;
import chris.dev.com.dexcomchallenge.util.Constants;


/**
 * Created by chris on 2/28/2018.
 */

public class DexcomApplication extends Application
{
    private AppComponent appComponent;
    private MainComponent mainComponent;
    
    @Override
    public void onCreate()
    {
        super.onCreate();
    
        AppModule appModule = new AppModule(Constants.BASE_URL);
        
        appComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build();
    
    }
    
    public static DexcomApplication get(Context context)
    {
        return (DexcomApplication) context.getApplicationContext();
    }

    public MainComponent getMainComponent()
    {
        mainComponent = appComponent.add(new MainModule());
        return mainComponent;
    }

    public void clearMainComponent()
    {
        mainComponent = null;
    }

}
