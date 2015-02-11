package no.westerdals.ta.vegeiv13.practice5.books;

import java.util.Arrays;
import java.util.Random;

public class Library {

    private String name;
    private Book[] books;
    private int numberOfBooks;

    public Library() {
        this("");
    }

    public Library(String name) {
        books = new Book[1000];
        this.name = name;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", books=" + Arrays.toString(books) +
                ", numberOfBooks=" + numberOfBooks +
                '}';
    }

    public static void main(String[] args) {
        Random r = new Random();
        Book[] books = new Book[5];
        for(int i = 0; i < books.length; i++) {
            String isbnString = "";
            for(int j = 0; j < 13; j++) {
                isbnString += r.nextInt(10);
            }
            books[i] = new Book(Long.valueOf(isbnString));
        }

        Library library = new Library("SuperLibrary");

        for (int i = 0; i < books.length; i++) {
            library.add(books[i]);
        }

        System.out.println(library);

    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public String getName() {
        return name;
    }

    public boolean add(Book book) {
        if (numberOfBooks >= books.length) {
            return false;
        }

        numberOfBooks++;
        for (int i = 0; i < numberOfBooks; i++) {
            if (books[i] == null || books[i].compareTo(book) > 0) {
                insertAt(i, book);
                return true;
            }
        }
        return false;
    }

    private void insertAt(int index, Book book) {
        for (int i = numberOfBooks - 2; i >= index; i--) {
            books[i + 1] = books[i];
        }
        books[index] = book;
    }

    public int indexOf(Book book) {
        for (int i = 0; i < numberOfBooks; i++) {
            if (books[i] != null && books[i].equals(book)) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(long isbn) {
        int index = indexOf(new Book(isbn));
        if (index < 0) {
            return false;
        }
        books[index] = null;

        for (int i = index + 1; i < books.length; i++) {
            if (i >= numberOfBooks) {
                break;
            }
            books[i - 1] = books[index];
        }
        numberOfBooks--;
        books[numberOfBooks] = null;
        return true;
    }

}
