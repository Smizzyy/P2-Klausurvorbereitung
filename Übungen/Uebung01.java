import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

class Uebung01 {
    List<String> names;
    List<Integer> numbers;
    
    Uebung01 () {
        names = List.of("Paul", "Lisa", "Franz", "Peter");
        numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
    
    // Liste von Strings in Großbuchstaben umwandeln
    List<String> toUpperCaseNames() {
        return names.stream().map(String::toUpperCase).toList();
    }

    /*
    Uebung01 u1 = new Uebung01()
    u1.toUpperCaseNames()
    $6 ==> [PAUL, LISA, FRANZ, PETER]
    */


    // alles Namen mit den Anfangsbuchstaben "P" ausgeben
    List<String> startsWithP() {
        return names.stream().filter(n -> n.startsWith("P")).toList();
    }

    /*
    Uebung01 u1 = new Uebung01()
    u1.startsWithP()
    $16 ==> [Paul, Peter]
    */


    // nur gerade Zahlen ausgeben
    List<Integer> evenNumbers() {
        return numbers.stream().filter(n -> n % 2 == 0).toList();
    }

    /*
    Uebung01 u1 = new Uebung01()
    u1.evenNumbers()
    $5 ==> [2, 4, 6, 8]
    */


    // TODO: funktionale Interfaces:
    // Function<T, R>: String in Länge umwandeln
    List<Integer> stringLengths() {
        Function<String, Integer> lengthFunction = String::length;
        
        // map() wendet apply() auf jedes Element in names an
        List<Integer> lengths = names.stream().map(lengthFunction).toList();
        return lengths;
    }

    /*
    Uebung01 u1 = new Uebung01()
    u1.stringLengths()
    $10 ==> [4, 4, 5, 5]
    */


    // Consumer<T>: Zahlen verdoppeln 
    void printDouble() {
        Consumer<Integer> doublePrinter = n -> System.out.print(n * 2 + " ");

        // forEach ruft accept() für jedes Element in numbers auf
        numbers.forEach(doublePrinter);
    }

    /*
    Uebung01 u1 = new Uebung01()
    u1.printDouble()
    2 4 6 8 10 12 14 16 18 
    */


    // Supplier<T>: Liste von 5 zufälligen Zahlen zwischen 1 und 100 generieren
    List<Integer> randomNumbersList() {
        Random random = new Random();
        
        Supplier<Integer> getRandomNumbers = () -> random.nextInt(100) + 1; // parameterloser Lambda-Ausdruck für Supplier verwenden

        // erzeugt einen endlosen Stream, der get() aus dem Suppplier aufruft. Der Stream wird aber nach 5 Aufrufen mit limit(5) gestoppt 
        List<Integer> randomNumbers = Stream.generate(getRandomNumbers).limit(5).toList();
        return randomNumbers;
    }

    /*
    Uebung01 u1 = new Uebung01()
    u1.randomNumbersList()
    $42 ==> [97, 18, 80, 52, 84]
    */


    // Predicate<T>: prüften, ob eine Zahl gerade ist
    List<Integer> evenNumbersList() {
        Predicate<Integer> isEven = n -> n % 2 == 0;

        // filter() ruft test() auf numbers auf und prüft mit dem Predicate, ob die Zahlen gerade sind 
        return numbers.stream().filter(isEven).toList();
    }

    /*
    Uebung01 u1 = new Uebung01()
    u1.evenNumbersList()
    $54 ==> [2, 4, 6, 8]
    */


    // UnaryOperator<T>: verdoppelt jede Zahl einer Liste
    List<Integer> doubleValuesList() {
        UnaryOperator<Integer> doubleValue = n -> n * 2;

        // map() wendet apply() auf jedes Element in numbers an und der UnaryOperator verdoppelt jeden Wert in der Liste
        return numbers.stream().map(doubleValue).toList();
    }

    /*
    Uebung01 u1 = new Uebung01()
    u1.doubleValuesList()
    $65 ==> [2, 4, 6, 8, 10, 12, 14, 16, 18]
    */
}