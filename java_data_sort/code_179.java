package com.upgrad.sarang.DSA.Sorting.MergeSort;

import java.util.Arrays;

public class MergeSort {

    public static int[] sort(int[] randomNumbers) {
        return mergeSort(randomNumbers, 0, randomNumbers.length - 1);
    }

    public static int[] mergeSort(int[] numbers, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(numbers, first, mid);
            mergeSort(numbers, mid + 1, last);

            merge(numbers, first, mid, last);
        }

        return numbers;
    }

    private static int[] merge(int[] numbers, int i, int m, int j) {
        int l = i;         int r = m + 1;         int k = 0;         int[] t = new int[numbers.length];

        while (l <= m && r <= j) {
            if (numbers[l] <= numbers[r]) {
                t[k] = numbers[l];
                k++;
                l++;
            } else {
                t[k] = numbers[r];
                k++;
                r++;
            }
        }

                while (l <= m) {
            t[k] = numbers[l];
            k++;
            l++;
        }

                while (r <= j) {
            t[k] = numbers[r];
            k++;
            r++;
        }

                l = i;
        k = 0;
        while (l <= j) {
            numbers[l] = t[k];
            l++;
            k++;
        }

        return numbers;
    }

    public static void main(String args[]) {
        int[] randomNumbers = {13, 3242, 23, 2351, 352, 3915, 123, 32, 67, 5, 9};
        int[] sortedNumbers;
        sortedNumbers = sort(randomNumbers);
        System.out.println(Arrays.toString(sortedNumbers));
    }
}