package com.nikiizvorski.sugarandroid.mvp.add;

import android.widget.Toast;

import com.nikiizvorski.sugarandroid.sugar.Author;
import com.nikiizvorski.sugarandroid.sugar.Book;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by nikiizvorski on 04/02/2017.
 */

public class BookPresenterImpl implements BookPresenter {
    @Inject BookView bookView;
    private List<Book> bookexist;
    private List<Author> authors;

    @Inject
    public BookPresenterImpl(BookView bookView) {
        this.bookView = bookView;
    }

    @Override
    public void addBook(String thename, String booknamed, String bookSummary) {
        bookexist = Book.find(Book.class, "name = ?", booknamed);
        authors = Author.find(Author.class, "name = ?", thename);

        if (!authors.isEmpty()) checkBook(thename, booknamed, bookSummary);
        else bookView.showMessage("No book if there is no author");
    }

    @Override
    public void checkBook(String thename, String booknamed, String bookSummary) {
        if (bookexist.isEmpty()) {
            bookView.showMessage("Add the book");
            Book book = new Book(booknamed, bookSummary, thename);
            book.save();
        } else {
            bookView.showMessage("Book already added for that author");
        }
    }

    @Override
    public void onDestroy() {
        bookView = null;
    }
}
