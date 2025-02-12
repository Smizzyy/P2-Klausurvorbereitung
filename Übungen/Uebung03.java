import java.util.*;

record Student(int matrikelnummer, String name, int age) {
    
    public Student(int matrikelnummer, String name, int age) {
        assert age > 0;
        this.matrikelnummer = matrikelnummer;
        this.name = name;
        this.age = age;
    }
    
    public Student setNewAge(int newAge) {
        return new Student(this.matrikelnummer, this.name, newAge);
    }
}

class Uebung03 {
    List<Student> students = Arrays.asList(new Student(13241, "Tim", 21), new Student(24141, "Paul", 19), new Student(53289, "Lars", 22));
    
    int averageAge() {
        return (int) students.stream().mapToInt(Student::age).average().orElse(0);
    } 

    List<Student> getOver20() {
        return students.stream().filter(n -> n.age() > 20).toList();
    }

    // forEach-Übungen
    List<String> friends = Arrays.asList("Liam", "Kim", "Laura");

    void listFriends() {
        friends.forEach(f -> System.out.println(f.toUpperCase()));

    }

    // forEach mit meht Dimensionen
    List<List<String>> multiDimList = Arrays.asList(
                                        Arrays.asList("a", "b"),
                                        Arrays.asList("c", "d"));

    void listDim() {
        multiDimList.forEach(dim -> dim.forEach(d -> System.out.println(d.toUpperCase())));
    }
}

/*
Beverage cola = new Beverage();
cola.setName("Cola");
cola.setPrice(0.5);
cola.setSize(0.3);
*/

class Beverage {
    private String name;
    private double price;
    private double size;

    Beverage() {}

    Beverage setName(String name) {
        this.name = name;
        return this;
    }

    Beverage setPrice(double price) {
        this.price = price;
        return this;
    }

    Beverage setSize(double size) {
        this.size = size;
        return this;
    }

}

class Calc {
    // Methoden die auf das Funktionsobjekt calc verweisen
    // Addieren
    Calculator add = (a, b) -> a + b;
    // Subtrahieren
    Calculator sub = (a, b) -> a - b;
    // Multiplizieren 
    Calculator mul = (a, b) -> a * b;
    // Dividieren
    Calculator div = (a, b) -> a / b;
}

@FunctionalInterface interface Calculator {
    double calc(double a, double b);
}

/*
Calc c = new Calc()
c ==> Calc@42e26948
c.add.calc(1, 3)
$23 ==> 4.0
*/