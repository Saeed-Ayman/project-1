package Sort;

import java.util.List;

public class Insertion<T> implements Sort<T> {
    public void s(List<T> list, Lambda<T> lambda) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = i; j > 0 && lambda.compare(list.get(j - 1), list.get(j)); j--) {
                lambda.swap(list, j, j - 1);
            }
        }
    }

    public void s(T[] list, Lambda<T> lambda) {
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j > 0 && lambda.compare(list[j - 1], list[j]); j--) {
                lambda.swap(list, j, j - 1);
            }
        }
    }

    public void s(T[] list, int from, int to, Lambda<T> lambda) {
        for (int i = from + 1; i < to; i++)
            for (int j = i; j > from && lambda.compare(list[j - 1], list[j]); j--) {
                lambda.swap(list, j, j - 1);
            }
    }
}
