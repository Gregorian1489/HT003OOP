import java.util.List;

public class Main {
    public static void main(String[] args) {

        Person p1 = new Person("Иванов", "Иван");
        Person p2 = new Person("Иванова", "Елизавета");
        Person p3 = new Person("Иванов", "Павел", p1, p2);
        Person p4 = new Person("Стерхова", "Елена", p1, p2);
        Person p5 = new Person("Стерхов", "Сергей");
        Person p6 = new Person("Стерхов", "Денис", p5, p4);


        System.out.println(String.format("Родители у '%s'", p6));
        for (Person person : p6.getParents()) {
            System.out.println(person.toString());
        }

        System.out.println(String.format("Дети у '%s'", p2));
        for (Person person : p2.getChildren()) {
            System.out.println(person.toString());
        }

        System.out.println(String.format("Прародители у '%s'", p6));
        for (Person person : p6.getSubParents()) {
            System.out.println(person);
        }

        System.out.println(String.format("Правнуки у '%s'", p1));
        for (Person person : p1.getSubChildren()) {
            System.out.println(person);
        }
    }
}