package chris.dev.com.dexcomchallenge.data.remote;

import java.util.List;

import chris.dev.com.dexcomchallenge.model.Book;
import chris.dev.com.dexcomchallenge.util.Constants;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by chris on 2/28/2018.
 */

public interface RemoteService
{
    @GET("books.json")
    Observable<List<Book>> getBooks();
}
