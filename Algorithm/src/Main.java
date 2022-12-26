import Sort.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static List<Integer> LIST;
    static Integer[] ARR;
    static Lambda<Integer> LAMBDA;
    static String SEPARATOR;
    final static int size = 100000;

    static {
        ARR = getRandomArray(size);
        LIST = Arrays.asList(ARR);
        SEPARATOR = getSEPARATOR("-");
        LAMBDA = Main::compare;
    }

    public static void main(String[] args) {
        test("Quick",       new Quick<Integer>());
        test("Merge",       new Merge<Integer>());
       /* test("Div And Con", new DivAndCon<Integer>());
        test("Bubble",      new Bubble<Integer>());
        test("Selection",   new Selection<Integer>());
        test("Insertion",   new Insertion<Integer>());*/
    }

    static <T> void print(T[] matrix, String s) {
        System.out.print("[");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i]);
            if (i + 1 != matrix.length) System.out.print(", ");
        }
        System.out.println("]" + s);
    }

    static void test(String name, Sort<Integer> sort) {
        List<Integer> list = new ArrayList<>(LIST);
        System.out.println(name + " : ");
        Date date = new Date();
        sort.s(list, LAMBDA);
        System.out.println(list + "\nTime : " + (new Date().getTime() - date.getTime()) + "\n");

        Integer[] matrix = Arrays.copyOf(ARR, ARR.length);
        date = new Date();
        sort.s(matrix, LAMBDA);
        print(matrix, "\nTime : " + (new Date().getTime() - date.getTime()) + "\n");
        System.out.println(SEPARATOR);
    }

    public static Integer[] getRandomArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < array.length; i++) array[i] = new Random().nextInt(array.length);
        return array;
    }

    public static String getSEPARATOR(String separator) {  return repeat(separator, LIST.toString().length()); }

    public static String repeat(String str, int times) { return Stream.generate(() -> str).limit(times).collect(Collectors.joining()); }

    static boolean compare(Integer a, Integer b) { return a > b; }
}
