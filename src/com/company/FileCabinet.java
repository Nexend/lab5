package com.company;

import java.util.Date;

public class FileCabinet {
    String title;
    String author;
    int publishingYear;
    String publishingHouse;
    double price;
    String status;
    String dateIssued;

    public enum Book{
        Классика,
        Фантастика,
        Фэнтези,
        Религия
    }

    Book typeBook;

    public FileCabinet(){

    }

    public FileCabinet(final Book book,final String title,final String author,final int publishingYear,final String publishingHouse, final double price,final String status,final String dateIssued){
        this.title = title;
        this.author = author;
        this.publishingYear = publishingYear;
        this.publishingHouse = publishingHouse;
        this.price = price;
        this.status = status;
        this.dateIssued = dateIssued;
        typeBook = book;
    }
    public FileCabinet( final Book book,final String title){
        this.title = title;
        this.author = null;
        this.publishingYear = 0;
        this.publishingHouse = null;
        this.price = 0;
        this.status = null;
        this.dateIssued = null;
        typeBook = book;
    }
}
