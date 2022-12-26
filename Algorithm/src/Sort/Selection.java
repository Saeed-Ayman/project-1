package Sort;

import java.util.List;

public class Selection<T> implements Sort<T>{
    public void s(List<T> list, Lambda<T> lambda) {
        int pointer;
        for (int i = 0; i < list.size(); i++) {
            pointer = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (lambda.compare(list.get(pointer), list.get(j))) pointer = j;
            }
            lambda.swap(list, pointer, i);
        }
    }

    public void s(T[] list, Lambda<T> lambda) {
        int pointer;
        for (int i = 0; i < list.length; i++) {
            pointer = i;
            for (int j = i + 1; j < list.length; j++) {
                if (lambda.compare(list[pointer], list[j])) pointer = j;
            }
            lambda.swap(list, pointer, i);
        }
    }
}


