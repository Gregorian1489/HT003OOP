import java.util.ArrayList;
import java.util.List;

public class Person {
    protected List<Person> children = new ArrayList<>();
    protected List<Person> parents = new ArrayList<>();
    static protected List<Person> persons;
    protected String firstName;
    protected String secondName;

    static {
        persons = new ArrayList<>();
    }

    public Person(String secondName, String firstName){
        this.secondName = secondName;
        this.firstName = firstName;
        this.addPerson(this);
    }

    public Person(String secondName, String firstName, Person parent1, Person parent2){
        this.secondName = secondName;
        this.firstName = firstName;
        this.addParent(parent1);
        parent1.addChild(this);
        this.addParent(parent2);
        parent2.addChild(this);
        this.addPerson(this);
    }

    public void addPerson(Person person){
        persons.add(person);
    }

    public static List<Person> getPersons(){
        return persons;
    }

    public List<Person> getChildren(){
        return children;
    }

    public void setParent(List<Person> parents){
        this.parents = parents;
        for (Person p: parents) {
            p.addChild(this);
        }
    }

    public List<Person> getParents(){
        return this.parents;
    }

    public void addChild(Person child){
        this.children.add(child);
    }

    public void addParent(Person parent){
        this.parents.add(parent);
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getSecondName(){
        return this.secondName;
    }

    public void setFirstName(String firstName){
        this.secondName = firstName;
    }

    public void setSecondName(String secondName){
        this.secondName = secondName;
    }

    public List<Person> getSubParents() {
        List<Person> result = new ArrayList<>();
        List<Person> subResult = this.getParents();
        for (Person per : subResult) {
            result.addAll(per.getParents());
        }
        return result;
    }

    public List<Person> getSubChildren() {
        List<Person> result = new ArrayList<>();
        List<Person> subResult = this.getChildren();
        for (Person per : subResult) {
            result.addAll(per.getChildren());
        }
        return result;
    }

    @Override
    public String toString(){
        return (firstName + " " + secondName);
    }
}
