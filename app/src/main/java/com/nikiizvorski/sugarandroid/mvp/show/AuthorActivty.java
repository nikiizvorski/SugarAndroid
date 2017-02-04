package com.nikiizvorski.sugarandroid.mvp.show;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.nikiizvorski.sugarandroid.R;
import com.nikiizvorski.sugarandroid.di.show.AuthorModule;
import com.nikiizvorski.sugarandroid.di.show.DaggerAuthorComponent;
import com.nikiizvorski.sugarandroid.sugar.Author;
import com.nikiizvorski.sugarandroid.sugar.Book;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * The type Author activty.
 */
public class AuthorActivty extends AppCompatActivity implements AuthorView{
    /**
     * The Author presenter.
     */
    @Inject AuthorPresenter authorPresenter;
    /**
     * The Listbooks.
     */
    @BindView(R.id.books)
    ListView listbooks;
    /**
     * The Empty.
     */
    @BindView(R.id.empty)
    TextView empty;
    private Unbinder unbinder;
    private ArrayAdapter<Book> bookArrayAdapter;
    private String author_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_author);
        initData();
        getData();
        setViews();
    }

    @Override
    public void initData() {
        DaggerAuthorComponent.builder().authorModule(new AuthorModule(this)).build().inject(this);
    }

    @Override
    public void getData() {
        Intent intent = getIntent();
        author_name = intent.getStringExtra("named");
    }

    @Override
    public void setViews() {
        unbinder = ButterKnife.bind(this);
        authorPresenter.setData(author_name);
        listbooks.setEmptyView(empty);
        listbooks.setAdapter(bookArrayAdapter);
    }

    @Override
    public void setAdapter(List<Book> kni) {
        bookArrayAdapter = new ArrayAdapter<>(this, R.layout.list_item, kni);
    }

    @Override
    public void deleteBook() {
        //TODO
    }

    @Override
    public void updateBook() {
        //TODO
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        authorPresenter.onDestroy();
        unbinder.unbind();
    }
}
