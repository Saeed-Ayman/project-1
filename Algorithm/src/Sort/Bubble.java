package Sort;

import java.util.List;

public class Bubble<T> implements Sort<T> {
    public void s(List<T> list, Lambda<T> lambda) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (lambda.compare(list.get(i), list.get(j))) {
                    lambda.swap(list, i, j);
                }
            }
        }
    }

    public void s(T[] list, Lambda<T> lambda) {
        for (int i = 0; i < list.length; i++) {
            for (int j = list.length - 1; j > i; j--) {
                if (lambda.compare(list[i], list[j])) {
                    lambda.swap(list, i, j);
                }
            }
        }
    }
}
