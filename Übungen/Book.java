import java.util.*;
import java.util.stream.Collectors;

class Book {
    private String title;
    private String author;
    private int pages;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    String getTitle() {
        return this.title;
    }

    String getAuthor() {
        return this.author;
    }

    int getPages() {
        return this.pages;
    }

    @Override public String toString() {
        return "Buch mit dem Titel: " + title + ", Autor: " + author + " und die Seitenanzahl: " + pages;
    }

    @Override public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (other.getClass() != getClass()) return false;
        Book that = (Book) other;
        return this.title.equals(that.title	) && this.author.equals(that.author) && this.pages == that.pages;
    }

    @Override public int hashCode() {
        return Objects.hash(title, author, pages);
    }
}

class Libary {
    List<Book> books = Arrays.asList(
        new Book("The Hobbit", "J.R.R. Tolkien", 310),
        new Book("1984", "George Orwell", 328),
        new Book("Brave New World", "Aldous Huxley", 288),
        new Book("The Catcher in the Rye", "J.D. Salinger", 277),
        new Book("The Great Gatsby", "F. Scott Fitzgerald", 180),
        new Book("Moby Dick", "Herman Melville", 635),
        new Book("War and Peace", "Leo Tolstoy", 1225),
        new Book("Crime and Punishment", "Fyodor Dostoevsky", 671),
        new Book("Ulysses", "James Joyce", 730),
        new Book("The Odyssey", "Homer", 541)
    );

    List<String> getFilteredBooks() {
        return books.stream()
            .filter(b -> b.getPages() > 300)
            .map(b -> b.getTitle().toUpperCase()) // ab hier muss die Rückgabe eine Liste von String sein
            .sorted()
            .limit(5)
            .collect(Collectors.toList());
    }
}
