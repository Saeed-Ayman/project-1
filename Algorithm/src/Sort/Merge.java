package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge<T> implements Sort<T> {

    public void s(T[] a, Lambda<T> lambda) {
        mergeSort(a, 0, a.length - 1, lambda);
    }


    private void mergeSort(T[] a, int s, int e, Lambda<T> lambda) {
        if (s >= e) return;
        int m = s + (e - s) / 2;
        mergeSort(a, s, m, lambda);
        mergeSort(a, m + 1, e, lambda);
        merge(a, s, m, e, lambda);
    }

    private void merge(T[] a, int s, int m, int e, Lambda<T> lambda) {
        int n1 = m - s + 1, n2 = e - m;
        T[] a1 = Arrays.copyOfRange(a, s, s + n1);
        T[] a2 = Arrays.copyOfRange(a, m + 1, m + n2 + 1);

        int i = 0, j = 0, k = s;
        while (i < n1 && j < n2)
            a[k++] = (lambda.compare(a2[j], a1[i]) ? a1[i++] : a2[j++]);
        while (i < n1) a[k++] = a1[i++];
        while (j < n2) a[k++] = a2[j++];
    }

    public void s(List<T> a, Lambda<T> lambda) {
        mergeSort(a, 0, a.size() - 1, lambda);
    }


    private void mergeSort(List<T> a, int s, int e, Lambda<T> lambda) {
        if (s >= e) return;
        int m = s + (e - s) / 2;
        mergeSort(a, s, m, lambda);
        mergeSort(a, m + 1, e, lambda);
        merge(a, s, m, e, lambda);
    }

    private void merge(List<T> a, int s, int m, int e, Lambda<T> lambda) {
        int n1 = m - s + 1, n2 = e - m;
        List<T> a1 = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            a1.add(a.get(i + s));
        }
        List<T> a2 = new ArrayList<>();
        for (int i = 0; i < n2; i++) {
            a2.add(a.get(i + m + 1));
        }
        int i = 0, j = 0, k = s;
        while (i < n1 && j < n2)
            a.set(k++, (lambda.compare(a2.get(j), a1.get(i)) ? a1.get(i++) : a2.get(j++)));
        while (i < n1) a.set(k++, a1.get(i++));
        while (j < n2) a.set(k++, a2.get(j++));
    }
}
