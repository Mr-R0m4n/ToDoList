package ToDoList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ToDoList {

    //Attributes

    private final String path = "D:\\Programmieren\\IdeaProjects\\To Do List\\List.txt";
    private boolean loop = true;
    private final ArrayList<String> allLines = new ArrayList<>(Files.readAllLines(Paths.get(path)));

    //Methods

    public void display() {
        //Display all tasks
        if(this.allLines.isEmpty()){
            System.out.println("Die Datei enthält keine Aufgaben");
        }
        int index = 1;
        for (String line : this.allLines) {
            System.out.println(index + ". " + line);
            index++;
        }
    }

    public void add() throws IOException {
        Scanner scAdd = new Scanner(System.in);
        //Loop
        this.loop = true;
        while (loop) {
            //Add task
            System.out.println("Gebe Deine neue Aufgabe ein: ");
            System.out.println("-----------------------------");
            this.allLines.add(scAdd.nextLine());
            Files.write(Paths.get(path),this.allLines);
            //Add another task?
            redo();
        }
    }

    public void remove() throws IOException, NotEmptyException, InputMismatchException {
        Scanner scRemove = new Scanner(System.in);
        //Error Exception
        if(this.allLines.isEmpty()){
            throw new NotEmptyException();
        }
        //Loop
        this.loop = true;
        while (loop) {
            //Display all tasks
            display();
            //Remove task
            System.out.println();
            System.out.println("Welche Aufgabe möchtest Du löschen? ");
            System.out.println("Bitte gebe die gewünschte Zeile an: ");
            System.out.println("------------------------------------");
            System.out.println();
            if(this.allLines.isEmpty()) {
                throw new NotEmptyException();
            }
            scRemove.hasNextInt();
            this.allLines.remove(scRemove.nextInt()-1);
            Files.write(Paths.get(path),this.allLines);
            //Remove another task?
            redo();
        }
    }

    public void redo() {
        //Redo loop?
        Scanner scRedo = new Scanner(System.in);
        System.out.println();
        System.out.println("Möchtest du den Vorgang wiederholen? ");
        System.out.println("1 = Ja");
        System.out.println("2 = Nein");
        System.out.println();
        //Exit loop
        if (scRedo.nextInt() != 1) {
            loop = false;
        }
        System.out.println();
    }

    //Exceptions

    public ToDoList() throws IOException{
    }

    //Getter&Setter
}
