import java.util.*;
import java.util.stream.IntStream;


class Altklausur2017 { 
    // for in einen Stream wandeln (4 Punkte)
    // Ersetzen Sie die for-Anweisung durch einen Stream, der auf die gleiche Weise die Liste der moves erstellt. Sie wissen von board nur, dass es vom Typ int[] ist.

    ArrayList<Integer> moves = new ArrayList<>();
    int[] board;

    public void initializeMoves() {
        for(int i = 0; i < board.length; i++) {
            if (board[i] == 0) moves.add(i);
        }
    }

    public void movesStream() {
        IntStream.range(0, board.length).filter(i -> board[i] == 0).forEachOrdered(moves::add);
    }



    // makeMove mit Varargs (4 Punkte)
    // Gegeben sei die Klasse Board, die u.a. die überladene makeMove-Methode enthält. Implementieren Sie die gegebene Methode, die nichts anderes macht, als für alle positions nacheinander die Methode
    // void makeMove(int pos) aufzurufen. Machen Sie das mit Hilfe eines Streams.

    // Implementieren Sie den Rumpf als Einzeiler mit einem Stream
    void makeMove(int... positions) {
        Arrays.stream(positions).forEachOrdered(this::makeMove);
    }



    // Minimum ermitteln (4 Punkte)
    // Vervollständigen Sie den gegebenen Ausdruck in der JShell so, dass der kleinste Wert in der Liste zurückgegeben wird; im Beispiel wäre das der Wert 2.

    // Vervollständigen Sie den Ausdruck
    // jshell> List.of(5,3,9,4,2,3,8).
    // $1 ==> 2

    List<Integer> list = List.of(5,3,9,4,2,3,8);

    int minValue() {
        return list.stream().min(Integer::compare).get();
    }



    // Wert ermitteln (4 Punkte)
    // Gegeben sei der folgende Stream. Wie lautet der 10. Wert, den der Stream produzieren würde?
    // Stream.iterate(new int[]{1,2,3}, a -> new int[]{a[0]+a[1],a[2],a[1]}).mapToInt(a -> a[0])

    // Lösung
    // Der 10. Wert lautet: 1, 3, 6, 8, 11, 13, 16, 18, 21, 23 also 23



    // Funktionales Interface erstellen (4 Punkte)
    // Erstellen Sie ein geeignetes funktionales Interface namens S2I, so dass folgender Dialog in der JShell möglich ist:
    // jshell> ((S2I) String::length).apply("Hello")
    // $13 ==> 5

    // Lösung:
    // @FunctionalInterface interface S2I { Integer apply(String s); }
}


interface MutableBoard<Move> {
    void makeMove(Move move);
    void undoMove();
    List<Move> moves();
    List<Move> getHistory(); // last move in list = recent move
    boolean isLost();
    default boolean isBeginnersTurn() {
    return getHistory().size() % 2 == 0;
    }
    String toString();
}

/*
Implementiere Klasse NimMove (5 Punkte)
Implementieren Sie die Klasse NimMove, die nur einen Konstruktor und eine toString-Methode hat.
Ein Zug ist definiert über die Reihe (row) und die Anzahl (number) der zu entfernenden
Streichhölzer. Die Musterlösung kommt mit vier Semikolons (;) im Code aus.
• Zählen Sie die Reihen mit 0 beginnend, so wie typisch für Informatiker/innen
• Machen Sie die Felder der Klasse lesbar aber nicht veränderbar
• Es gibt keine Setter- oder Getter-Methoden
Lösung (4 Semikolons)
*/

class NimMove {
    final public int row, number;

    public NimMove(int row, int number) {
        this.row = row;
        this.number = number;
    }

    @Override public String toString() {
        return row + ":" + number;
    }
}


/*
Deklariere Klassenkopf, Felder, Konstruktor (5
Punkte)
Bevor wir uns den einzelnen Methoden widmen, deklarieren Sie den Kopf der Klasse Board, die
benötigten Felder und den Konstruktor. Die interne Darstellung des Spielbretts soll durch ein
"normales" Array aus int-Werten erfolgen, jeder int-Wert gibt die Anzahl der verbliebenen
Streichhölzer für die Reihe an. Die Musterlösung kommt mit drei Semikolons aus.
Lösung (3 Semikolons)
*/

class Board implements MutableBoard<NimMove> {
    private int[] board;
    private Stack<NimMove> history = new Stack<>();
    public Board(int... config) {
        board = config;
    }
}