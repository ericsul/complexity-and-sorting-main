package partA;

import java.util.ArrayList;
import java.util.List;

import java.util.Comparator;

public class Sort {

    // Bubble Sort
    public static Shape[] bubbleSort(Shape[] array, Comparator<Shape> comparator) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    Shape temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }


    public static Shape[] insertionSort(List<Shape> shapes, Comparator<Shape> comparator) {
        int n = shapes.size();
        Shape[] array = new Shape[n];
        shapes.toArray(array);

        for (int i = 1; i < n; ++i) {
            Shape key = array[i];
            int j = i - 1;

            while (j >= 0 && comparator.compare(array[j], key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }

        return array;
    }

    public static Shape[] selectionSort(List<Shape> shapes, Comparator<Shape> comparator) {
        int n = shapes.size();
        Shape[] array = new Shape[n];
        shapes.toArray(array);  // Convert the list to an array

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(array[j], array[min_idx]) < 0) {
                    min_idx = j;
                }
            }

            Shape temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }

        return array;
    }

    public static Shape[] mergeSort(List<Shape> shapes, Comparator<Shape> comparator) {
        if (shapes.size() < 2) {
            Shape[] array = new Shape[shapes.size()];
            return shapes.toArray(array);
        }

        int mid = shapes.size() / 2;
        List<Shape> left = new ArrayList<>(shapes.subList(0, mid));
        List<Shape> right = new ArrayList<>(shapes.subList(mid, shapes.size()));

        Shape[] leftArray = mergeSort(left, comparator);
        Shape[] rightArray = mergeSort(right, comparator);

        return merge(leftArray, rightArray, comparator);
    }

    private static Shape[] merge(Shape[] left, Shape[] right, Comparator<Shape> comparator) {
        Shape[] array = new Shape[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) <= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
        return array;
    }

    public static void quickSort(List<Shape> shapes, int low, int high) {
        if (low < high) {
            int pi = partition(shapes, low, high);

            quickSort(shapes, low, pi - 1);
            quickSort(shapes, pi + 1, high);
        }
    }
    public static Shape[] shellSort(List<Shape> shapes, Comparator<Shape> comparator) {
        int n = shapes.size();
        Shape[] array = new Shape[n];
        shapes.toArray(array);

        // Start with a large gap, and reduce it over time
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Shape temp = array[i];
                int j;
                for (j = i; j >= gap && comparator.compare(array[j - gap], temp) > 0; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
        return array;
    }


    private static int partition(List<Shape> shapes, int low, int high) {
        Shape pivot = shapes.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (shapes.get(j).compareTo(pivot) < 0) {
                i++;

                Shape temp = shapes.get(i);
                shapes.set(i, shapes.get(j));
                shapes.set(j, temp);
            }
        }

        Shape temp = shapes.get(i + 1);
        shapes.set(i + 1, shapes.get(high));
        shapes.set(high, temp);

        return i + 1;
    }

}