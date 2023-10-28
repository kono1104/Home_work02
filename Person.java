import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private static int numberOfPeople = 0;

    private String name;
    private int birthYear;
    private String gender;
    private Person mother;
    private Person father;
    private List<Person> children;
    private String occupation;
    private String placeOfBirth;

    public Person(String name, int birthYear, String gender, String occupation, String placeOfBirth) {
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
        this.occupation = occupation;
        this.placeOfBirth = placeOfBirth;
        this.children = new ArrayList<>();
        numberOfPeople++;
    }

    public static int getNumberOfPeople() {
        return numberOfPeople;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public void addChild(Person child) {
        children.add(child);
        child.setMother(this);
        if (this.gender.equals("М")) {
            child.setFather(this);
        }
    }

    public List<Person> getChildren() {
        return children;
    }

    // Остальные методы остаются без изменений
}