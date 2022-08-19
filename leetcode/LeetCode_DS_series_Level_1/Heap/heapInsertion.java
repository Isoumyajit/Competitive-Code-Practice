package Heap;

import java.util.Scanner;

public class heapInsertion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            insertIntoHeap(arr, i);
        }
        printHeap(arr);
        System.out.println("After Sorting");
        heapSort(arr);
        printHeap(arr);
        sc.close();
    }

    private static void printHeap(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private static void insertIntoHeap(int[] arr, int index) {

        if (index == 1)
            return;
        int root = index / 2;
        int number = arr[index];
        while (root > 0 && arr[root] <= number) {
            arr[index] = arr[root];
            index = root;
            root /= 2;
        }
        arr[index] = number;
    }

    private static void heapSort(int[] arr) {

        int len = arr.length - 1;
        for (int i = 1; i < arr.length - 1; i++) {
            swap(arr, 1, arr.length - i);
            // printHeap(arr);
            maxHeapify(arr, --len);
            // printHeap(arr);
        }
    }

    private static void maxHeapify(int[] arr, int size) {

        int root = 1;
        int lchild = 2 * root;
        int rchild = lchild + 1;
        int num = arr[root];

        while (rchild <= size) {

            if (num >= arr[lchild] && num >= arr[rchild]) {
                arr[root] = num;
                return;
            } else if (arr[lchild] < arr[rchild]) {
                arr[root] = arr[rchild];
                root = rchild;
            } else {
                arr[root] = arr[lchild];
                root = lchild;
            }
            lchild = root * 2;
            rchild = lchild + 1;
        }
        if (lchild == size && num < arr[lchild]) {
            arr[root] = arr[lchild];
            root = lchild;
        }
        arr[root] = num;

    }

    private static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
}
