package com.nikiizvorski.sugarandroid.mvp.main;

import android.widget.AdapterView;

import com.nikiizvorski.sugarandroid.sugar.Author;
import com.nikiizvorski.sugarandroid.sugar.Book;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by nikiizvorski on 04/02/2017.
 */
public class MainPresenterImpl implements MainPresenter {
    /**
     * The Main view.
     */
    @Inject MainView mainView;

    /**
     * Instantiates a new Main presenter.
     *
     * @param mainView the main view
     */
    @Inject
    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void getData() {
        List<Author> books = Author.listAll(Author.class);
        mainView.setAdapterData(books);
    }

    @Override
    public void saveAuthor(String thename) {
        if (!thename.isEmpty()) {
            List<Author> authors = Author.find(Author.class, "name = ?", thename);

            if (!authors.isEmpty()) {
                mainView.showMessage("Already Exist in DB");
            } else {
                mainView.showMessage("You can add it");
                Author author = new Author(thename);
                author.save();
                mainView.passChanges(author);
            }
        }
    }

    @Override
    public void deleteAuthor(AdapterView<?> parent, int position) {
        mainView.showMessage("Deleted: " + String.valueOf(position));

        List<Author> books = Author.listAll(Author.class);

        for (Author author : books) {
            if (author.getName().matches(parent.getItemAtPosition(position).toString())) {
                deleteAuthorBooks(author);
                author.delete();
            }
        }
        mainView.passDataChanges(position);
    }

    @Override
    public void deleteAuthorBooks(Author author) {
        List<Book> books = Book.listAll(Book.class);

        for (Book book : books){
            if (book.getAuthor().matches(author.getName())){
                mainView.showMessage("Deleted Books for Author: " + author.getName());
                book.delete();
            }
        }
    }

    @Override
    public void bookPage() {
        mainView.bookPage();
    }

    @Override
    public void updateAuthor() {
        mainView.updateAuthor();
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }
}
