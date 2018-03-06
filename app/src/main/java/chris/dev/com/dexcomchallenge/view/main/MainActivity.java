package chris.dev.com.dexcomchallenge.view.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import chris.dev.com.dexcomchallenge.R;
import chris.dev.com.dexcomchallenge.application.DexcomApplication;
import chris.dev.com.dexcomchallenge.model.Book;
import chris.dev.com.dexcomchallenge.util.BooksAdapter;


public class MainActivity extends AppCompatActivity implements MainContract.View
{
    public static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    @Inject
    MainPresenter presenter;
    private List<Book> books;
    private RecyclerView recyclerView;
    private BooksAdapter booksAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DexcomApplication.get(this).getMainComponent().inject(this);
    
        bindViews();
        
        presenter.attachView(this);
        presenter.getWeather();
    }
    
    private void bindViews()
    {
        books = new ArrayList<>();
        recyclerView = findViewById(R.id.rvBooks);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    
    @Override
    public void showError(String error)
    {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
    
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        presenter.detachView();
    }
    
    @Override
    public void setBooks(List<Book> books)
    {
        booksAdapter = new BooksAdapter(books);
        recyclerView.setAdapter(booksAdapter);
    }
    
    @Override
    public void showProgress(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    
    @Override
    protected void onStop()
    {
        super.onStop();
        DexcomApplication.get(this).clearMainComponent();
    }
}
