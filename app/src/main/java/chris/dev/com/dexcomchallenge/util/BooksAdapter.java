package chris.dev.com.dexcomchallenge.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import chris.dev.com.dexcomchallenge.R;
import chris.dev.com.dexcomchallenge.model.Book;

/**
 * Created by chris on 2/28/2018.
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder>
{
    List<Book> books = new ArrayList<>();
    Context context;

    public BooksAdapter(List<Book> books)
    {
        this.books = books;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_list_item, null);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BooksAdapter.ViewHolder holder, int position)
    {
        Book book = books.get(position);
        if(book != null)
        {
            holder.tvBookInfo.setText(book.getTitle());
            Picasso.with(context).load(book.getImageURL()).into(holder.ivBook);
        }
    }

    @Override
    public int getItemCount()
    {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView tvBookInfo;
        private final ImageView ivBook;
        public ViewHolder(View itemView)
        {
            super(itemView);
            tvBookInfo = itemView.findViewById(R.id.tvBookInfo);
            ivBook = itemView.findViewById(R.id.ivBook);
        }
    }
}
