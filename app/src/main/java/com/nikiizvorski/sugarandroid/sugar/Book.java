package com.nikiizvorski.sugarandroid.sugar;

import com.orm.SugarRecord;

/**
 * The type Book.
 */
public class Book extends SugarRecord {
    private String name;
    private String ISBN;
    private String title;
    private String shortSummary;

    // defining a relationship
    private String author;

    /**
     * Instantiates a new Book.
     * Required for SugarORM
     */
    public Book() {
    }

    /**
     * Instantiates a new Book.
     *
     * @param name         the name
     * @param shortSummary the short summary
     * @param author       the author
     */
    public Book(String name, String shortSummary, String author) {
        this.name = name;
        this.shortSummary = shortSummary;
        this.author = author;
    }

    /**
     * Instantiates a new Book.
     *
     * @param name         the name
     * @param ISBN         the isbn
     * @param title        the title
     * @param shortSummary the short summary
     * @param author       the author
     */
    public Book(String name, String ISBN, String title, String shortSummary, String author) {
        this.name = name;
        this.ISBN = ISBN;
        this.title = title;
        this.shortSummary = shortSummary;
        this.author = author;
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

    /**
     * Gets isbn.
     *
     * @return the isbn
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Sets isbn.
     *
     * @param ISBN the isbn
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets short summary.
     *
     * @return the short summary
     */
    public String getShortSummary() {
        return shortSummary;
    }

    /**
     * Sets short summary.
     *
     * @param shortSummary the short summary
     */
    public void setShortSummary(String shortSummary) {
        this.shortSummary = shortSummary;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets author.
     *
     * @param author the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "NAME: " + name + "\nTEXT: " + shortSummary;
    }
}