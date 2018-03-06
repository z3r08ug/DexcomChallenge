package chris.dev.com.dexcomchallenge.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat.WearableExtender;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import chris.dev.com.dexcomchallenge.R;
import chris.dev.com.dexcomchallenge.model.Book;
import chris.dev.com.dexcomchallenge.view.main.MainActivity;

/**
 * Created by chris on 2/28/2018.
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder>
{
    List<Book> books = new ArrayList<>();
    Context context;
    //notification id number
    int notificationId = 001;
    //The channel id of the notification
    String id = "book_channel";

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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.putExtra("book", books.get(getAdapterPosition()));
                    PendingIntent pendingIntent =
                            PendingIntent.getActivity(context, 0, intent, 0);
                    
                    NotificationCompat.Builder notificationBuilder =
                            new NotificationCompat.Builder(context, id)
                            .setSmallIcon(R.drawable.ic_launcher_background)
                            .setContentInfo(books.get(getAdapterPosition()).getTitle())
                            .setContentIntent(pendingIntent);
                    
                    //get instance of the NotificationManager service
                    NotificationManagerCompat notificationManager =
                            NotificationManagerCompat.from(context);
                    
                    //Issue the notification 
                }
            });
        }
    }
}
