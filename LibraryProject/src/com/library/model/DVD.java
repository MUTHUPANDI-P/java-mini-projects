package com.library.model;

public class DVD extends LibraryItem {

    private double duration;

    public DVD(int itemId, String title, String author, double duration) {
        super(itemId, title, author);
        this.duration = duration;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Duration: " + duration + " hrs");
        System.out.println("----------------------");
    }
}