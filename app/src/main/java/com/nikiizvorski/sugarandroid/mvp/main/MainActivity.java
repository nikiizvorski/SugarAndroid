package com.nikiizvorski.sugarandroid.mvp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nikiizvorski.sugarandroid.di.main.DaggerMainComponent;
import com.nikiizvorski.sugarandroid.di.main.MainModule;
import com.nikiizvorski.sugarandroid.sugar.Book;
import com.nikiizvorski.sugarandroid.mvp.add.BookActivity;
import com.nikiizvorski.sugarandroid.mvp.show.AuthorActivty;
import com.nikiizvorski.sugarandroid.R;
import com.nikiizvorski.sugarandroid.sugar.Author;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    /**
     * The Main presenter.
     */
    @Inject MainPresenter mainPresenter;
    /**
     * The Edit text.
     */
    @BindView(R.id.editText) EditText editText;
    /**
     * The Save.
     */
    @BindView(R.id.button) Button save;
    /**
     * The List view.
     */
    @BindView(R.id.lista) ListView listView;
    /**
     * The Text view.
     */
    @BindView(R.id.empty_view) TextView textView;
    /**
     * The Goto books.
     */
    @BindView(R.id.getme) Button gotoBooks;
    /**
     * The Show books.
     */
    @BindView(R.id.showBook) Button showBooks;
    private ArrayAdapter<Author> authorListAdapter;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        setViews();
        setData();
    }

    @Override
    public void initData() {
        DaggerMainComponent.builder().mainModule(new MainModule(this)).build().inject(this);
    }

    @Override
    public void setViews() {
        unbinder = ButterKnife.bind(this);
        save.setOnClickListener(this);
        gotoBooks.setOnClickListener(this);
        showBooks.setOnClickListener(this);
    }

    @Override
    public void setData() {
        mainPresenter.getData();
        listView.setEmptyView(textView);
        listView.setAdapter(authorListAdapter);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String thename = editText.getText().toString().trim();
        if (v.getId() == R.id.button) mainPresenter.saveAuthor(thename);
        if (v.getId() == R.id.getme) mainPresenter.bookPage();
        if (v.getId() == R.id.showBook) mainPresenter.updateAuthor();
    }

    @Override
    public void updateAuthor() {
        //TODO
    }

    @Override
    public void bookPage() {
        Intent intent = new Intent(this, BookActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, AuthorActivty.class);
        intent.putExtra("named", parent.getItemAtPosition(position).toString());
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void showMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        mainPresenter.deleteAuthor(parent, position);
        return false;
    }

    @Override
    public void setAdapterData(List<Author> books) {
        authorListAdapter = new ArrayAdapter<>(this, R.layout.list_item, books);
    }

    @Override
    public void passChanges(Author author) {
        authorListAdapter.add(author);
        authorListAdapter.notifyDataSetChanged();
    }

    @Override
    public void passDataChanges(int position) {
        authorListAdapter.remove(authorListAdapter.getItem(position));
        authorListAdapter.notifyDataSetChanged();
    }
}
