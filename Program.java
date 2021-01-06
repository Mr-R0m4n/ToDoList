package ToDoList;

import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {

        //Attributes
        ToDoList toDoList = new ToDoList();

        //loop
        boolean loopMenu = true;
        while (loopMenu) {
            //MainMenu
            System.out.println("---------------------------------");
            System.out.println("Willkommen in Deiner To-Do Liste!");
            System.out.println("Was möchtest du als nächstes tun?");
            System.out.println("---------------------------------");
            System.out.println("1 = To-Do Liste anzeigen");
            System.out.println("2 = Neue Aufgaben erstellen");
            System.out.println("3 = Aufgaben löschen");
            System.out.println("4 = Das Programm beenden");
            System.out.println("---------------------------------");

            Scanner scMenu = new Scanner(System.in);

            switch (scMenu.nextInt()) {
                //Display all tasks
                case 1 -> {
                    System.out.println();
                    toDoList.display();
                    System.out.println();
                }
                //Add task
                case 2 -> {
                    try {
                        System.out.println();
                        toDoList.add();
                    } catch (IOException ioe) {
                        System.out.println("Die Datei konnte nicht eingelesen werden");
                        ioe.printStackTrace();
                    }
                }
                //Delete task
                case 3 -> {
                    try {
                        System.out.println();
                        toDoList.remove();
                    } catch (IOException ioe) {
                        System.out.println("Die Datei konnte nicht eingelesen werden");
                        ioe.printStackTrace();
                    }
                    catch (NotEmptyException nee) {
                        System.out.println("Die Datei enthält keine Aufgaben");
                        System.out.println();
                    }
                }
                //Exit program
                case 4 -> {
                    System.out.println("Bis zum nächsten mal!");
                    loopMenu = false;
                    scMenu.close();
                }
                default -> {
                    System.out.println("Deine Eingabe entsprach nicht den Vorgaben");
                    System.out.println("Bitte versuch es erneut");
                    System.out.println();
                }
            }
        }
    }
}
