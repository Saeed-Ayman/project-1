package Sort;

import java.util.List;

public class Quick<T> implements Sort<T> {


    public void s(List<T> list, Lambda<T> lambda) {
        quick(list, 0, list.size() - 1, lambda);
    }

    public void s(T[] list, Lambda<T> lambda) {
        quick(list, 0, list.length - 1, lambda);
    }

    private void quick(T[] a, int s, int e, Lambda<T> lambda) {
        if (s >= e) return;
        int pivot = partition(a, s, e, lambda);
        quick(a, s, pivot, lambda);
        quick(a, pivot + 1, e, lambda);
    }

    private int partition(T[] a, int s, int e, Lambda<T> lambda) {
        int pivot = s, i = s, j = e;

        while (true) {
            while (pivot != j && !lambda.compare(a[pivot], a[j])) j--;
            if (pivot == j) break;
            else if (lambda.compare(a[pivot], a[j])) lambda.swap(a, pivot, pivot = j);
            while (pivot != i && lambda.compare(a[pivot], a[i])) i++;
            if (pivot == i) break;
            else if (!lambda.compare(a[pivot], a[i])) lambda.swap(a, pivot, pivot = i);

        }
        return pivot;
    }

    private void quick(List<T> a, int s, int e, Lambda<T> lambda) {
        if (s >= e) return;
        int pivot = partition(a, s, e, lambda);
        quick(a, s, pivot, lambda);
        quick(a, pivot + 1, e, lambda);
    }

    private int partition(List<T> a, int s, int e, Lambda<T> lambda) {
        int pivot = s, i = s, j = e;

        while (true) {
            while (pivot != j && !lambda.compare(a.get(pivot), a.get(j))) j--;
            if (pivot == j) break;
            else if (lambda.compare(a.get(pivot), a.get(j))) lambda.swap(a, pivot, pivot = j);
            while (pivot != i && lambda.compare(a.get(pivot), a.get(i))) i++;
            if (pivot == i) break;
            else if (!lambda.compare(a.get(pivot), a.get(i))) lambda.swap(a, pivot, pivot = i);

        }
        return pivot;
    }
}
