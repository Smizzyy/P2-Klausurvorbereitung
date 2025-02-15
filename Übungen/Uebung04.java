import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


class Uebung04 {

    // Transformieren von Elementen: map()
    // Aufgabe: Cars
    // Transformieren Sie die Elemente der Liste cars mit Verwendung der Methode map() so, dass sie in Großbuchstaben auf der Standardausgabe ausgegeben werden.

    List<String> cars = Arrays.asList("BMW", "Audi", "Mercedes", "Porsche", "Opel", "Volkswagen");

    List<String> upperCaseCars = cars.stream().map(String::toUpperCase).collect(Collectors.toList());

    // Aufgabe: Count
    // Transformieren Sie die Elemente der Liste cars mit der Verwendung der Methode map() so, dass statt der Namen die Anzahl der Buchstaben ausgegeben wird.
    // Die Ausgabe soll für jedes Element folgendermaßen aussehen, wobei <count> nur ein Platzhalter für den tatsächlichen Wert ist: Number of characters: <count>

    String charsOfCar(String carName) {
        int count = cars.stream().filter(n -> n.equals(carName)).map(String::length).reduce(0, Integer::sum);
        return "Numbers of characters: " + count; 
    }



    // Mehrdimensionale Sammelstrukturen zusammenführen: flatMap()
    // Aufgabe: Mehrdimensionale-Liste
    // Überführen Sie die nachfolgende, mehrdimensione, Liste mit flatMap() in einen eindimensionalen Stream und geben Sie die Werte auf der Standardausgabe aus

    List<List<Integer>> numbers2D = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(6, 7, 8, 9, 10));

    List<Integer> newNumbers2D = numbers2D.stream().flatMap(List::stream).collect(Collectors.toList());

    // Aufgabe: Mehrdimensionales-Array Integer
    // Überführen Sie das nachfolgende, mehrdimensione, Array mit flatMap() in einen eindimensionalen Stream und geben Sie die Werte auf der Standardausgabe aus.

    Integer[][] numbers = {new Integer[]{1, 2, 3, 4, 5}, new Integer[]{6, 7, 8, 9, 10}};

    Integer[] newNumbers = Arrays.stream(numbers).flatMap(Arrays::stream).toArray(Integer[]::new);

    // Aufgabe: Mehrdimensionales-Array int
    // Überführen Sie das nachfolgende, mehrdimensione, Array mit flatMap() in einen eindimensionalen Stream und geben Sie die Werte auf der Standardausgabe aus.

    int[][] intNumbers = {new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 8, 9, 10}};

    int[] newIntNumbers = Arrays.stream(intNumbers).flatMapToInt(Arrays::stream).toArray();



    // Filtern von Elementen: filter()
    // Aufgabe: Filter-Cars
    // Filtern Sie die Liste cars so, dass auf der Standardausgabe nur Marken ausgegeben werden, die mit dem Buchstaben P beginnen.

    List<String> cars2 = Arrays.asList("BMW", "Audi", "Mercedes", "Porsche", "Opel", "Volkswagen");

    List<String> cars2WithP = cars2.stream().filter(p -> p.startsWith("P")).toList();

    // Aufgabe: Filter-Predicate
    // Lagern Sie das Predicate aus der vorherigen Aufgabe in eine Variable aus, sodass der Aufruf von filter() folgendermaßen aussieht: .filter(namesStartWithP)

    Predicate<String> namesStartWithP = p -> p.startsWith("P");

    List<String> predicateCars2WithP = cars2.stream().filter(namesStartWithP).toList();

    // Aufgabe: Eigenes Predicate
    // Implementieren Sie die Methode namesStartWith, um nicht für jeden Buchstaben des Alphabets ein eigenes Predicate händisch anlegen zu müssen. Die Methode namesStartWith nimmt als Parameter ein Suchwort s entgegen und gibt ein Predicate zurück.
    // public Predicate<String> startWith(String s) { ... }
    // Der Aufruf von filter soll folgendermaßen aussehen:
    // .filter(startWith("P"))

    public Predicate<String> startWith(String s) {
        Predicate<String> sw = st -> st.startsWith(s);
        return sw;
    }

    List<String> chooseStartChar = cars2.stream().filter(startWith("P")).toList();
    

    // mit Set 

    List<Set<Integer>> setNumbers2D = Arrays.asList(Set.of(1, 2, 3, 4, 5), Set.of(5, 7, 8, 9, 10));

    List<Integer> newSetNumbers = numbers2D.stream().flatMap(List::stream).collect(Collectors.toList());
}
