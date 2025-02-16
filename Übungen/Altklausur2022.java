import java.util.*;
import java.util.stream.Collectors;

class Altklausur2022 {
    // Aufgabe 4 
    // 1) 
    List<Set<Integer>> listOfSetNumbers = List.of(Set.of(2, 5, 6), Set.of(1, 4, 5, 8));
    
    // 2)
    Set<Integer> level(Set<Integer> set) {
        return set.stream().map(n -> n % 2 == 1 ? n * 2 : n / 2).collect(Collectors.toSet());
    }

    // 3)
    List<Set<Integer>> newList = listOfSetNumbers.stream().map(set -> level(set)).toList();
}
