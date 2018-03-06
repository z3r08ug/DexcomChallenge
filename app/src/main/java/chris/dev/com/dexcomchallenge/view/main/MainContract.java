package chris.dev.com.dexcomchallenge.view.main;

import chris.dev.com.dexcomchallenge.util.BasePresenter;
import chris.dev.com.dexcomchallenge.util.BaseView;

/**
 * Created by chris on 2/28/2018.
 */

public interface MainContract
{
    interface  View extends BaseView
    {
        void setBooks(BookResponse books);
        void showProgress(String message);
        void showError(String error);
    }
    
    interface Presenter extends BasePresenter<View>
    {
        void getWeather();
    }
}
