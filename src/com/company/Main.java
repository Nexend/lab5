package com.company;

import java.util.Scanner;

public class Main {
    public static FileCabinets fileCabinets;

    public static void main(String[] args) {
        fileCabinets = new FileCabinets(6);

        fileCabinets.add(new FileCabinet(FileCabinet.Book.Фантастика, "Инопришеленец", "Гагарин", 2000, "РтСофт", 80, "Хорошее", "06.10.2019"), 1);
        fileCabinets.add(new FileCabinet(FileCabinet.Book.Фэнтези,"Приключение Олежки", "Гагарин", 1970, "РтСофт", 110, "Нормальное", "04.06.2019"), 2);
        fileCabinets.add(new FileCabinet(FileCabinet.Book.Религия,"Минус жизнь", "Бадер", 1930, "РтСофт", 50, "Плохое", "06.03.2019"), 3);
        fileCabinets.add(new FileCabinet(FileCabinet.Book.Классика,"Мастер и Маргарита", "Булгаков", 1966, "РтСофт", 200, "Хорошее", "19.05.2019"), 4);
        fileCabinets.add(new FileCabinet(FileCabinet.Book.Фантастика,"Мстители", "Бадер", 2012, "РтСофт", 150, "Хорошее", "13.02.2019"), 5);
        fileCabinets.add(new FileCabinet(FileCabinet.Book.Классика,"59 как 60 - только на пересдачу", "Сперанский", 2017, "ОНПУ", 59, "Нормальное", "18.09.2019"), 6);

        Menu();
    }
    public static void Menu() {
        int menuNumber = 0;
        Scanner scanner = new Scanner(System.in);
        while (menuNumber == 0) {
            System.out.println("Выберите нужный пункт: " +
                    "\n1) Изменить состояние книг,изданной больше N лет назад" +
                    "\n2) Названия книг,цена которых больше 100 грн" +
                    "\n3) Названия всех книг данного автора" +
                    "\n4) Информация о книгах,которые находятся на руках больше 3 месяцев" +
                    "\n5) Информация о всех книг" +
                    "\n6) Выход" +
                    "\nВведите цифру нужного пункта и нажмите Enter: ");
            boolean isCorrectly = false;
            String str = "";
            while (!isCorrectly) {
                str = scanner.next();
                if (str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4") || str.equals("5") || str.equals("6")) {
                    isCorrectly = true;
                } else {
                    System.out.println("Введите правильное значение: ");
                }
            }
            menuNumber = Integer.parseInt(str);
            switch (menuNumber){
                case 1: fileCabinets.changeStateOfBooks(); break;
                case 2: fileCabinets.booksCostMoreThanOneHundred(); break;
                case 3: fileCabinets.booksThisAuthor(); break;
                case 4: fileCabinets.infoBooksOnHands(); break;
                case 5: fileCabinets.infoAllBooks(); break;
                case 6: System.exit(0); break;
                default: menuNumber=0;
            }
        }
    }
}
