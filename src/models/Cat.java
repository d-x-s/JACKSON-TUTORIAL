package models;

public class Cat {

    String name;
    Boolean isCute;

    public Cat() {

    }

    public Cat(String name, Boolean isCute) {
        this.name = name;
        this.isCute = isCute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCute() {
        return isCute;
    }

    public void setCute(Boolean cute) {
        isCute = cute;
    }
}
