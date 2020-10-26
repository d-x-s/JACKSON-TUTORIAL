package persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Cat;
import models.CatCalendar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ManagerJSON {

    private static CatCalendar retrieveFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        CatCalendar calendar = null;

        try {
            calendar = objectMapper.readValue(new File("./data/catCalendar.json"), CatCalendar.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return calendar;
    }



    private static void writetoJson(CatCalendar calendar) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("./data/catCalendar.json"), calendar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static void initializeCatCalendar() {
        CatCalendar thisCalendar = new CatCalendar();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File("./data/catCalendar.json"), thisCalendar);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void addCatToCalendar(Cat cat) {
        //retrieve the calendar from the JSON
        CatCalendar retrievedCalendar = retrieveFromJson();

        //add your cat
        retrievedCalendar.getListOfCats().add(cat);

        //write the updated calendar to the JSON
        writetoJson(retrievedCalendar);
    }

    public static void removeCatFromCalendar(String catToBeDeleted) {
        CatCalendar retrievedCalendar = retrieveFromJson();
        ArrayList<Cat> listOfCats = retrievedCalendar.getListOfCats();

        for (int i = 0; i < listOfCats.size(); i++) {
            if (listOfCats.get(i).getName().equals(catToBeDeleted)) {
                listOfCats.remove(i);
                break;
            } else {
                System.out.println("This cat doesn't exist in the calendar!");
            }
        }

        writetoJson(retrievedCalendar);
    }

    public static void editCatInCalendar() {

    }
}
