package com.library.app;

import com.library.model.Book;
import com.library.model.Magazine;
import com.library.model.DVD;
import com.library.service.LibraryService;

public class LibraryApp {

    public static void main(String[] args) {

        LibraryService service = new LibraryService();

        Book b1 = new Book(1, "Java Basics", "James Gosling", 300);
        Magazine m1 = new Magazine(2, "Tech Today", "John", 45);
        DVD d1 = new DVD(3, "Inception", "Nolan", 2.5);

        service.addItem(b1);
        service.addItem(m1);
        service.addItem(d1);

        service.displayAllItems();
    }
}