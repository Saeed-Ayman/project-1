package Sort;

import java.util.List;

public interface Sort<T> {
    void s(List<T> list, Lambda<T> lambda);

    void s(T[] list, Lambda<T> lambda);

}
