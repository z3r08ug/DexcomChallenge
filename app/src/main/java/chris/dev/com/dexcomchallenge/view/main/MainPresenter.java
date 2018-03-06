package chris.dev.com.dexcomchallenge.view.main;

import android.util.Log;

import javax.inject.Inject;

import chris.dev.com.dexcomchallenge.data.remote.RemoteDataSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by chris on 2/28/2018.
 */

public class MainPresenter implements MainContract.Presenter
{
    RemoteDataSource remoteDataSource;
    MainContract.View view;
    public static final String TAG = MainPresenter.class.getSimpleName() + "_TAG";
    private BookResponse books;
    
    @Inject
    public MainPresenter(RemoteDataSource remoteDataSource)
    {
        this.remoteDataSource = remoteDataSource;
    }
    
    public MainPresenter()
    {
    
    }
    
    @Override
    public void attachView(MainContract.View view)
    {
        this.view = view;
    }
    
    @Override
    public void detachView()
    {
        this.view = null;
    }
    
    @Override
    public void getWeather()
    {
        RemoteDataSource.getWeather()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BookResponse>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {
                        view.showProgress("Downloading Books....");
                    }

                    @Override
                    public void onNext(BookResponse weatherResponse)
                    {
                        books = weatherResponse;
                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        Log.d(TAG, "onError: "+e.toString());
                        view.showError(e.toString());
                    }

                    @Override
                    public void onComplete()
                    {
                        view.setBooks(books);
                    }
                });
    }
}
