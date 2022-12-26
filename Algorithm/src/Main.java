import Sort.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    final static int size = 100000;
    static List<Integer> LIST;
    static Integer[] ARR;
    static Lambda<Integer> LAMBDA;
    static String SEPARATOR;

    static {
        ARR = getRandomArray(size);
        LIST = Arrays.asList(ARR);
        SEPARATOR = getSEPARATOR("-");
        LAMBDA = Main::compare;
    }

    public static void main(String[] args) {
        test("Quick", new Quick<Integer>());
        test("Merge", new Merge<Integer>());
        test("Div And Con", new DivAndCon<Integer>());
        test("Bubble", new Bubble<Integer>());
        test("Selection", new Selection<Integer>());
        test("Insertion", new Insertion<Integer>());
    }

    static <T> void print(T[] matrix, String s) {
        try (FileWriter file = new FileWriter("output.txt", true)) {
            file.write("[");
            for (int i = 0; i < matrix.length; i++) {
                file.write(matrix[i] + "");
                if (i + 1 != matrix.length) file.write(", ");
            }
            file.write("]" + s + "\n");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void test(String name, Sort<Integer> sort) {
        List<Integer> list = new ArrayList<>(LIST);
        WriteToFile(name + " : ");
        Date SDate = new Date();
        sort.s(list, LAMBDA);
        Date EDate = new Date();
        print(list.toArray(), "\nTime : " + (EDate.getTime() - SDate.getTime()) + "\n");

        Integer[] matrix = Arrays.copyOf(ARR, ARR.length);
        SDate = new Date();
        sort.s(matrix, LAMBDA);
        EDate = new Date();
        print(matrix, "\nTime : " + (EDate.getTime() - SDate.getTime()) + "\n");
        WriteToFile(SEPARATOR + "\n");
    }

    public static Integer[] getRandomArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < array.length; i++) array[i] = new Random().nextInt(array.length);
        return array;
    }

    public static String getSEPARATOR(String separator) {
        return repeat(separator, LIST.toString().length());
    }

    public static String repeat(String str, int times) {
        return Stream.generate(() -> str).limit(times).collect(Collectors.joining());
    }

    static boolean compare(Integer a, Integer b) {
        return a > b;
    }

    static void WriteToFile(String str) {
        try (FileWriter file = new FileWriter("output.txt", true)) {
            file.write(str + "\n");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
