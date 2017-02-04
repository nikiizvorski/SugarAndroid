package com.nikiizvorski.sugarandroid.sugar;

import com.orm.SugarRecord;
import java.util.List;

/**
 * The type Author.
 */
public class Author extends SugarRecord {
    private String name;

    /**
     * Instantiates a new Author.
     * Required for SugarORM
     */
    public Author() {}

    /**
     * Instantiates a new Author.
     *
     * @param name the name
     */
    public Author(String name) {
        this.name = name;
    }

    /**
     * Gets books.
     *
     * @return the books
     */
// Get all books of this author
    public List<Book> getBooks() {
        return Book.find(Book.class, "author = ?", name);
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}