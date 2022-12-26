package Search;

public class BST {

    public static int binary_search(int[] arr, int key, int low, int high) {
        int m = (low + high) / 2;
        if (low <= m) {
            if (key == arr[m]) {
                System.out.print("this element in this digit -> ");
                return m;
            }
            if (key < arr[m]) {
                return binary_search(arr, key, low, m - 1);
            }
            if (key > arr[m]) {
                return binary_search(arr, key, m + 1, high);
            }
        }
        return -1;
    }

    public static int binary_search(int[] arr, int key) {
        return binary_search(arr, key, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(binary_search(new int[]{5,7,9,18,22,101,120}, 120));
    }
}