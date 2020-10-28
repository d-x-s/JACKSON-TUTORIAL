package ui;

import models.Cat;
import models.CatCalendar;

import java.util.Scanner;
import static persistence.ManagerJSON.initializeCatCalendar;

public class App extends CatCalendar {
    private Scanner input;
    Scanner reader = new Scanner(System.in);

    public App() {
        runApp();
    }

    private void runApp() {
        while (true) {
            String command = null;

            System.out.println("Hello, welcome to Jackson Tutorial!");
            System.out.println("Type quit to exit program, load to load your file, init to initialize the calendar");
            System.out.println("Type add to add a cat to the calendar");
            System.out.println("Type remove to delete a cat from the calendar");
            input = new Scanner(System.in);

            command = input.next();
            command = command.toLowerCase();

            if (command.equals("quit")) {
                return;

            } else {
                processCommand(command);
            }

        }
    }

    private void processCommand(String command) {
        if (command.equals("load")) {
            System.out.println("Loading your file");
        }
        if (command.equals("init")) {
            initializeCatCalendar();

        }
        if (command.equals("add")) {
            String name;
            String isCute;
            Boolean isCuteBool;
            input = new Scanner(System.in);

            System.out.println("What's the cat name?");
            name = input.next();

            System.out.println("Is the cat cute?");
            System.out.println("Y or N");
            isCute = input.next();

            if (isCute.equals("Y")) {
                isCuteBool = true;
            } else {
                isCuteBool = false;
            }

            addCat(new Cat(name, isCuteBool));

        }

        if (command.equals("remove")) {
            String name;
            System.out.println("What's the cat name?");
            name = input.next();
            deleteCat(name);
        }
    }
}
