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
}