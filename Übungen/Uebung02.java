import java.util.*;

public class Uebung02 {
    List<String> students;
    LinkedList<String> applications;
    Map<String, List<String>> courses;

    Uebung02 () {
        this.students = new ArrayList<>();
        this.applications = new LinkedList<>();
        this.courses = new HashMap<>();

    }

    // Student hinzufügen
    void addStudent(String student) {
        students.add(student);
        System.out.println("Student " + student + " hinzugefügt");
    }

    // Student umbennen
    String renameStudent(String student, String newName) {
        int index = students.indexOf(student);

        if (index == -1) throw new IllegalArgumentException(student + " wurde nicht gefunden"); 

        students.set(index, newName);

        return student + " umbenant zu " + newName;
    }

    // Student entfernen
    String removeStudent(String student) {
        if (students.indexOf(student) != -1) students.remove(student);
        else throw new IllegalArgumentException(student + " wurde nicht gefunden"); 

        return student + " wurde entfernt";
    }

    // Anzahl der Studenten ausgeben
    int studentCount() {
        return students.size();
    }

    // Prüfen ob ein Student in der Liste ist
    boolean doesStudentExist(String student) {
        return students.contains(student);
    }


    // neue Bewerbung hinzufügen
    void addApplication(String name) {
        applications.add(name);

        System.out.println(name + " hinzugefügt");
    }

    // erste Bewerbung verabeiten
    String handleFirstApplication() {
        return applications.poll() + " bearbeitet";
    }

    // die nächste Bewerbung ansehen (1. Bewerbung der Liste)
    String peekNextApplication() {
        return "Die nächste Bewerbung ist: " + applications.peek();
    }


    // Studenten in einen Kurs hinzufügen
    void addStudentsToCourse(String courseName) {
        if (!students.isEmpty()) courses.put(courseName, students);
        else throw new IllegalArgumentException("Studentenliste ist leer.");

        System.out.println(students + " dem Kurs " + courseName + " hinzugefügt");
    }
}

// Die 5 Bausteine einer equals()-Implementierung
class Point {
    private double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) { 
        if (other == null) return false; // Null abwehren!
        if (other == this) return true; // Bin ich's selbst?
        if (other.getClass() != getClass()) return false; // Andere Klasse? (instanceOf ist nicht genau)
        Point that = (Point)other; // Casting, damit that.x und that.y vom Compiler erkannt werden
        return this.x == that.x && this.y == that.y; // Was definiert Gleichheit?
    }
    // Merkhilfe: Null nein — Ich ja — Klasse gleich? — Casting — Vergleich


    // hashCode()-Implementierung
    @Override 
    public int hashCode() {
        return Objects.hash(x, y);
    }
}


// selber Anwenden
class Person {
    String name;
    int age;
    String city;

    // Konstruktor
    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    @Override 
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (other.getClass() != getClass()) return false;
        Person that = (Person)other;
        return this.name == that.name && this.age == that.age && this.city == that.city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, city);
    }
}   