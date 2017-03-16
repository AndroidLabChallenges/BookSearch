package com.codepath.android.booksearch.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.android.booksearch.R;
import com.codepath.android.booksearch.models.Book;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

public class BookDetailActivity extends AppCompatActivity {
    private ImageView ivBookCover;
    private TextView tvTitle;
    private TextView tvAuthor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBarBookSearch);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);


        // Fetch views
        ivBookCover = (ImageView) findViewById(R.id.ivBookCover);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvAuthor = (TextView) findViewById(R.id.tvAuthor);

        // Extract book object from intent extras
        Intent inbound = getIntent();
        Book bookDetail = Parcels.unwrap(getIntent().getParcelableExtra("dispDetail"));
        tvAuthor.setText(bookDetail.getAuthor());
        tvTitle.setText(bookDetail.getTitle());
        Picasso.with(this).load(bookDetail.getCoverUrl()).fit().centerCrop().into(ivBookCover);

        // Use book object to populate data into views
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
