package no.westerdals.ta.vegeiv13.practice5.books;

public class Book implements Comparable<Book> {

    private final long isbn;

    private int count;

    private int available;

    public Book(final long isbn) {
        this(isbn, 1);
    }

    public Book(final long isbn, int count) {
        this.isbn = isbn;
        this.count = count;
        this.available = count;
    }

    public boolean loan() {
        if (available <= 0) {
            return false;
        }

        available--;
        return true;
    }

    /**
     * Ideally, this method would be named return, but that's a reserved word
     */
    public boolean returnBook() {
        if (available >= count) {
            return false;
        }
        available++;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return isbn == book.isbn;

    }

    @Override
    public int hashCode() {
        int result = (int) (isbn ^ (isbn >>> 32));
        result = 31 * result + count;
        result = 31 * result + available;
        return result;
    }

    public long getIsbn() {

        return isbn;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", count=" + count +
                ", available=" + available +
                '}';
    }

    @Override
    public int compareTo(Book that) {
        return Long.compare(this.isbn, that.isbn);
    }
}
