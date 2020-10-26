package models;

import persistence.ManagerJSON;

import java.util.ArrayList;

public class CatCalendar extends ManagerJSON {

    ArrayList<Cat> listOfCats;

    public CatCalendar() {
        listOfCats = new ArrayList<>();
    }

    public void addCat(Cat cat) {
        addCatToCalendar(cat);
    }

    public void deleteCat(String catName) {
        removeCatFromCalendar(catName);
    }

    public void editCat(String catName) {
        editCatInCalendar();
    }

    //getter and setter
    public ArrayList<Cat> getListOfCats() {
        return listOfCats;
    }

    public void setListOfCats(ArrayList<Cat> listOfCats) {
        this.listOfCats = listOfCats;
    }
}
