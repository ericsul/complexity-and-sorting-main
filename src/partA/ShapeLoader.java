package partA;

import java.io.File;
import java.util.Scanner;

import partA.Shape.ShapeComparator;

public class ShapeLoader {
	private String fileName = "";
	static String[] shapeInfo = new String[100000]; // Change this number to however many we want since this is not dynamically allocated
	static 	int shapeCount = 0;
	
	public String setFileName(String newFileName) {
		this.fileName = newFileName;
		return fileName;
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	public void parseInput(String[] args) {

		
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-f") && i + 1 < args.length) {
				setFileName(args[i + 1]);
				System.out.println(getFileName());
				break;
			}
		}
		
		if (getFileName().isEmpty()) {
			System.out.println("Provide a file using -f <filename> -c <comparisonType>");
			return;
		}
	}
	
	public void readFile() {
		
		try {
			File file = new File(getFileName());
			Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String shapeData = scanner.nextLine();
                shapeInfo[shapeCount++] = shapeData;
            }

            for (int i = 0; i < shapeCount; i++) {
                System.out.println("Shape " + (i + 1) + ": " + shapeInfo[i]);
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println(e);
        }
	}
	
	public static Shape createShapeFromData(String data) {
		String[] parts = data.split(" ");

        if (parts.length < 3) {
            System.err.println("Invalid data for creating a shape: " + data);
            return null;
        }

        String shapeType = parts[0];

        if (shapeType.equals("Cylinder") || shapeType.equals("Cone")) {
            if (parts.length < 3) {
                System.err.println("Invalid data for creating a Cylinder or Cone: " + data);
                return null;
            }
            double height = Double.parseDouble(parts[1]);
            double radius = Double.parseDouble(parts[2]);

            if (shapeType.equals("Cylinder")) {
                return new Cylinder(height, radius);
            } else {
                return new Cone(height, radius);
            }
        } else if (shapeType.equals("Pyramid")) {
            if (parts.length < 3) {
                System.err.println("Invalid data for creating a Pyramid: " + data);
                return null;
            }
            double height = Double.parseDouble(parts[1]);
            double edgeLength = Double.parseDouble(parts[2]);

            return new Pyramid(height, edgeLength);
        } else if (shapeType.equals("SquarePrism") || shapeType.equals("TriangularPrism") || shapeType.equals("PentagonalPrism") || shapeType.equals("OctagonalPrism")) {
            if (parts.length < 3) {
                System.err.println("Invalid data for creating a Prism: " + data);
                return null;
            }
            double height = Double.parseDouble(parts[1]);
            double edgeLength = Double.parseDouble(parts[2]);

            if (shapeType.equals("SquarePrism")) {
                return new SquarePrism(height, edgeLength);
            } else if (shapeType.equals("TriangularPrism")) {
                return new TriangularPrism(height, edgeLength);
            } else if (shapeType.equals("PentagonalPrism")) {
                return new PentagonalPrism(height, edgeLength);
            } else {
                return new OctagonalPrism(height, edgeLength);
            }
        } else {
            System.err.println("Unsupported shape: " + shapeType);
        }
        return null;
	}
	
	public static void sortShapes(Shape[] shapes, char comparisonType) {

        ShapeComparator comparator = new Shape.ShapeComparator(comparisonType);

        shapes = Sort.bubbleSort(shapes, comparator); // Any sort method can be used, I just used bubbleSort since it was the first one

        for (int i = 0; i < shapeCount; i++) {
            System.out.println("Shape " + (i + 1) + ": " + shapes[i]); // This is the line that prints out each shape. There was no formatting requirement so I found it easier just to print everything on one line instead (I also have no idea how to print it on a per line basis).
            System.out.println();
        }
	}

	public static void main(String[] args) {
		
		ShapeLoader sl = new ShapeLoader();
		sl.parseInput(args);
		sl.readFile();
		
        Shape[] shapes = new Shape[shapeCount];

        for (int i = 0; i < shapeCount; i++) {
            String shapeData = shapeInfo[i];
            Shape shape = createShapeFromData(shapeData);
            if (shape != null) {
                shapes[i] = shape;
            }
        }

        char comparisonType = 'v'; // 'v' for volume comparison, 'a' for area-based comparison
        sortShapes(shapes, comparisonType);
	}
} 
