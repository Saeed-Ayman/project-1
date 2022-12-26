package Sort;

import java.util.List;

public class DivAndCon<T> implements Sort<T> {
    Insertion<T> sort = new Insertion<T>();

    public void s(List<T> list, Lambda<T> lambda) {
        if (list == null || list.size() == 1 || list.size() == 0) return;
        s(list.subList(0, list.size() / 2), lambda);
        s(list.subList(list.size() / 2, list.size()), lambda);
        sort.s(list ,lambda);
    }

    public void s(T[] list, Lambda<T> lambda) {
        s(list, 0, list.length, lambda);
    }

    public void s(T[] list, int from, int to, Lambda<T> lambda) {
        if (to - from == 1 || to == from) return;
        s(list, from, (to + from) / 2, lambda);
        s(list, (to + from) / 2, to, lambda);
        sort.s(list, from, to, lambda);
    }
}
