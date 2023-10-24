package partA;

import java.util.Arrays;

public class SortBenchmark {
    
    private static void printBenchmark(String algorithmName, Shape[] shapes, char comparisonType) {
        long startTime = System.currentTimeMillis();

        if (algorithmName.equals("Bubble Sort")) {
            Sort.bubbleSort(shapes, new Shape.ShapeComparator(comparisonType));
        } else if (algorithmName.equals("Insertion Sort")) {
            Sort.insertionSort(Arrays.asList(shapes), new Shape.ShapeComparator(comparisonType));
        } else if (algorithmName.equals("Selection Sort")) {
            Sort.selectionSort(Arrays.asList(shapes), new Shape.ShapeComparator(comparisonType));
        } else if (algorithmName.equals("Merge Sort")) {
            Sort.mergeSort(Arrays.asList(shapes), new Shape.ShapeComparator(comparisonType));
        } else if (algorithmName.equals("Quick Sort")) {
            Sort.quickSort(Arrays.asList(shapes), 0, shapes.length - 1);
        } else if (algorithmName.equals("Shell Sort")) {
            shellSort(shapes, new Shape.ShapeComparator(comparisonType));
        }
        
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println(algorithmName + " took " + elapsedTime + " milliseconds to sort.");
    }

    // Shell Sort implementation
    private static void shellSort(Shape[] array, Shape.ShapeComparator comparator) {
        int n = array.length;
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
    }

    public static void main(String[] args) {
        ShapeLoader sl = new ShapeLoader();
        sl.parseInput(args);
        sl.readFile();
        
        // Still debating if this is worth putting into its own class to load the shape files since I call this in ShapeLoader too, but I'm lazy
        Shape[] shapes = new Shape[ShapeLoader.shapeCount];
        for (int i = 0; i < ShapeLoader.shapeCount; i++) {
            String shapeData = ShapeLoader.shapeInfo[i];
            Shape shape = ShapeLoader.createShapeFromData(shapeData);
            if (shape != null) {
                shapes[i] = shape;
            }
        }
        
        char comparisonType = 'v'; // ('v' or 'a') for volume or base area accordingly. Question #8 should let us adjust this via command arguments
        
        printBenchmark("Bubble Sort", shapes.clone(), comparisonType);
        printBenchmark("Insertion Sort", shapes.clone(), comparisonType);
        printBenchmark("Selection Sort", shapes.clone(), comparisonType);
        printBenchmark("Merge Sort", shapes.clone(), comparisonType);
        printBenchmark("Quick Sort", shapes.clone(), comparisonType);
        printBenchmark("Shell Sort", shapes.clone(), comparisonType);
    }
}
