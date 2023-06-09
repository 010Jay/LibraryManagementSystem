package org.jay010.entity;

public class Book {

    private int bookID;
    private String bookName;
    private String author;
    private String genre;
    private double price;

    public Book() {}

    public Book(Builder builder) {
        this.bookID = builder.bookID;
        this.bookName = builder.bookName;
        this.author = builder.author;
        this.genre = builder.genre;
        this.price = builder.price;
    }

    public int getBookID() {
        return bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                '}';
    }

        public static class Builder {

            private int bookID;
            private String bookName;
            private String author;
            private String genre;
            private double price;

            public Builder setBookID(int bookID) {
                this.bookID = bookID;
                return this;
            }

            public Builder setBookName(String bookName) {
                this.bookName = bookName;
                return this;
            }

            public Builder setAuthor(String author) {
                this.author = author;
                return this;
            }

            public Builder setGenre(String genre) {
                this.genre = genre;
                return this;
            }

            public Builder setPrice(double price) {
                this.price = price;
                return this;
            }

            public Book build() {
                return new Book(this);
            }
        }
}
