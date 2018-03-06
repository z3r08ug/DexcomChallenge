package chris.dev.com.dexcomchallenge.view.main;

import java.util.List;

import chris.dev.com.dexcomchallenge.model.Book;
import chris.dev.com.dexcomchallenge.util.BasePresenter;
import chris.dev.com.dexcomchallenge.util.BaseView;

/**
 * Created by chris on 2/28/2018.
 */

public interface MainContract
{
    interface  View extends BaseView
    {
        void setBooks(List<Book> books);
        void showProgress(String message);
        void showError(String error);
    }
    
    interface Presenter extends BasePresenter<View>
    {
        void getWeather();
    }
}
