package com.library.service;

import java.util.ArrayList;
import java.util.List;
import com.library.model.LibraryItem;

public class LibraryService {

    private List<LibraryItem> items = new ArrayList<>();

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void displayAllItems() {
        for (LibraryItem item : items) {
            item.displayDetails(); 
        }
    }
}