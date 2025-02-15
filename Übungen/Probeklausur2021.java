import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

// Aufgabe 1
class Rectangel {
    private float height, width;

    Rectangel (float height, float width) {
        this.height = height;
        this.width = width;
    }

    // 1)
    @Override public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (other.getClass() != getClass()) return false;
        Rectangel that = (Rectangel) other;
        return this.height == that.height && this.width == that.width;
    }

    // 2)
    @Override public int hashCode() {
        return Objects.hash(height, width);
    }
}

// Aufgabe 2
class Aufgabe2 {
    // 1)
    List<Set<Integer>> listOfSetNumbers = List.of(Set.of(2, 5, 6), Set.of(1, 4, 5, 8));

    // 2)
    Set<Integer> level(Set<Integer> set) {
        return set.stream().map(n -> n % 2 == 1 ? n * 2 : n / 2).collect(Collectors.toSet());
    }

    // 3)
    List<Set<Integer>> newSetList = listOfSetNumbers.stream().map(set -> level(set)).collect(Collectors.toList());

    // 4)
    // $1 ==> [[1, 10, 3], [2, 10, 4]]
}

// Aufgabe 3
// (Predicate<List>) lst -> lst.size() >= 3;

// (Function<List, Integer>) lst -> lst.size();

// (Supplier<List<Integer>>) () -> List.of(1, 2, 3);

// (Consumer<List>) lst -> System.out.println(lst);

// Aufgabe 4
class Aufgabe4 {
    
    long factorial(long n) {
        assert n >= 1;
        return LongStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
    }
}

// Aufgabe 5
class Median {

    double medianA(double... values) {
        Arrays.sort(values);
        int lower = (values.length - 1) / 2;
        int upper = values.length / 2;
        return (values[upper] + values[lower]) / 2;
    }

    double medianB(double... values) {
        Arrays.sort(values);
        int lower = (values.length - 1) / 2;
        int upper = values.length / 2;
        return Arrays.stream(values).sorted().skip(lower).limit(upper - lower + 1).average().getAsDouble();
    }
}

// Aufgabe 6 
class Aufgabe6 {
    Map<Character, BinaryOperator<Integer>> calc = Map.of('+', (a, b) -> a + b, 
                                                            '-', (a, b) -> a - b);

    int sum = calc.get('+').apply(2, 3);
}