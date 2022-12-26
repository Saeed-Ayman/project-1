package Sort;

import java.util.List;

public interface Lambda<T> {
    boolean compare(T v1, T v2);

    default void swap(T[] list, int index1, int index2) {
        T t = list[index1];
        list[index1] = list[index2];
        list[index2] = t;
    }

    default void swap(List<T> list, int index1, int index2) {
        list.set(index1, list.set(index2, list.get(index1)));
    }
}
