/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptvr19library;

import entity.Book;
import entity.Reader;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class App {
    private Scanner scanner = new Scanner(System.in);
    private Reader[] readers = new Reader[10];

    public App() {
        ReadersStorageManager rsm = new ReadersStorageManager();
        readers = rsm.loadReadersFromFile();
    }

    public void run() {
        System.out.println("--- Библиотека ---");
        boolean repeat = true;
        do{
            System.out.println("---------------------------");
            System.out.println("Задачи:");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Список книг");
            System.out.println("3. Добавить читателя");
            System.out.println("4. Список читателей");
            System.out.println("5. Выдать книгу");
            System.out.println("6. Вернуть книгу");
            System.out.print("Выберите задачу: ");
            String task = scanner.nextLine();
            System.out.println("----------------------------");
            switch (task) {
                case "0":
                    System.out.println("--- Конец программы ---");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("--- Добавить книгу ---");
                    Book book = new Book("Voina i mir", "L.Tolstoy", 2010);
                    System.out.println("Название книги: "+book.getName());
                    System.out.println(book.toString());
                    break;
                case "2":
                    System.out.println("--- Список книг ---");
                    break;
                case "3":
                    System.out.println("--- Добавить читателя ---");
                    ReaderManager readerManager = new ReaderManager(); 
                    Reader reader = readerManager.addReader();
                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i] == null){
                            readers[i] = reader;
                            break;
                        }
                    }
                    ReadersStorageManager readersStorageManager = new ReadersStorageManager();
                    readersStorageManager.saveReadersToFile(readers);
                    break;
                case "4":
                    System.out.println("--- Список читателей ---");
                    int i = 0;
                    for (Reader r : readers) {
                        if(r != null){
                            System.out.println(i+1+". "+r.toString());
                            i++;
                        }
                    }
                    break;
                case "5":
                    System.out.println("--- Выдать книгу ---");
                    break;
                case "6":
                    System.out.println("--- Вернуть книгу ---");
                    break;
                default:
                    System.out.println("Нет такой задачи");;
            }
        }while(repeat);
    }

}