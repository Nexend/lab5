package com.company;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class FileCabinets {
    String author;
    String title;
    String status;

    Scanner scanner = new Scanner(System.in);

    private FileCabinet[] list;

    public FileCabinets(final int length){
        this.list = new FileCabinet[length];
    }

    public void add(final FileCabinet fileCabinet, final int position) {
        this.list[position-1] = fileCabinet;
    }

    public void infoAllBooks(){
        for (FileCabinet fileCabinet : this.list) {
            System.out.println("Название книги: " + fileCabinet.title + "\nАвтор: " + fileCabinet.author + "\nЖанр: " + fileCabinet.typeBook  + "\nГод издания: " + fileCabinet.publishingYear + "\nИздательство: " + fileCabinet.publishingHouse + "\nЦена: " + fileCabinet.price + "\nСостояние: " + fileCabinet.status + "\nДата выдачи читателю на руки: " + fileCabinet.dateIssued + '\n');
        }
        backToMenu();
    }
    public void changeStateOfBooks() {
        Calendar now = Calendar.getInstance();
        int currentYear = now.get(Calendar.YEAR);

        System.out.println("Изменить состояние книг изданных больше (введите кол-во лет): ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        for ( int i = 0; i < this.list.length; i++ ) {
            if ( currentYear - this.list[i].publishingYear > quantity) {
                System.out.println( this.list[i].title );
                System.out.println("Введите состояние на которое хотите поменять: ");
                this.list[i].status = scanner.next();
            }
        }

        backToMenu();
    }
    public void booksCostMoreThanOneHundred() {
        for ( FileCabinet fileCabinet : this.list ) {
            if ( fileCabinet.price >= 100 ) {
                System.out.println("Название книги: " + fileCabinet.title + "\nЦена: " + fileCabinet.price);
            }
        }
        backToMenu();
    }

    public void booksThisAuthor() {
        System.out.println("Введите имя автора: ");
        author = scanner.next();
        for ( int i = 0; i < this.list.length; i++ ) {
            if ( author.equals( this.list[i].author ) ) {
                System.out.println("Название книги: " + this.list[i].title);
            }
        }

        backToMenu();
    }
    public void infoBooksOnHands() {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        int month = localDate.getMonthValue();
        int day   = localDate.getDayOfMonth();
        for ( FileCabinet fileCabinet : this.list ) {
            System.out.println(fileCabinet.dateIssued);
            System.out.println("Название книги: " + fileCabinet.title + "\nАвтор: " + fileCabinet.author + "\nГод издания: " + fileCabinet.publishingYear + "\nИздательство: " + fileCabinet.publishingHouse + "\nЦена: " + fileCabinet.price + "\nСостояние: " + fileCabinet.status + "\nДата выдачи читателю на руки: " + fileCabinet.dateIssued + '\n');
        }

        backToMenu();
    }

    public void backToMenu(){
        int result = -1;
        while (result<0||result>1) {
            System.out.println('\n' + "Вернуться в меню? (1 - да, 0 - нет)");
            result = Integer.parseInt(scanner.next());
            if (result == 1) {
                Main.Menu();
            }
        }
    }
}
