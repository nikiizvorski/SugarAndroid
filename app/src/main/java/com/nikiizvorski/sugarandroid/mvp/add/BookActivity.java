package com.nikiizvorski.sugarandroid.mvp.add;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nikiizvorski.sugarandroid.R;
import com.nikiizvorski.sugarandroid.di.add.BookModule;
import com.nikiizvorski.sugarandroid.di.add.DaggerBookComponent;
import com.nikiizvorski.sugarandroid.sugar.Author;
import com.nikiizvorski.sugarandroid.sugar.Book;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * The type Book activity.
 */
public class BookActivity extends AppCompatActivity implements BookView, View.OnClickListener {
    /**
     * The Book presenter.
     */
    @Inject BookPresenter bookPresenter;
    /**
     * The Author name.
     */
    @BindView(R.id.aname)
    EditText authorName;
    /**
     * The Book name.
     */
    @BindView(R.id.abookname)
    EditText bookName;
    /**
     * The Book sum.
     */
    @BindView(R.id.abooksum)
    EditText bookSum;
    /**
     * The Save book.
     */
    @BindView(R.id.savebook)
    Button saveBook;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        initData();
        initViews();
    }

    @Override
    public void initData() {
        DaggerBookComponent.builder().bookModule(new BookModule(this)).build().inject(this);
    }

    @Override
    public void initViews() {
        unbinder = ButterKnife.bind(this);
        saveBook.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bookPresenter.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        String thename = authorName.getText().toString().trim();
        String booknamed = bookName.getText().toString().trim();
        String bookSummary = bookSum.getText().toString().trim();
        if (!thename.isEmpty() && !booknamed.isEmpty() && !bookSummary.isEmpty())
        bookPresenter.addBook(thename, booknamed, bookSummary);
    }

    @Override
    public void showMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
