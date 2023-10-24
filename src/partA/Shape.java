/**
 * 
 */
package partA;

import java.util.Comparator;

/**
 * 
 */
public abstract class Shape implements Comparable<Shape> {
	private double height;
	private double volume;
	private double baseArea;

	public double getHeight() {
		return this.height;
	}

	public double getVolume() {
		return this.volume;
	}

	public double getBaseArea() {
		return this.baseArea;
	}
	
	@Override
	public int compareTo(Shape otherShape) {
		return Double.compare(this.height, otherShape.height);
	}
	
	public static class ShapeComparator implements Comparator<Shape> {
		private char comparisonType;
		
		public ShapeComparator(char comparisonType) {
			this.comparisonType = comparisonType;
		}
		
		@Override
		public int compare(Shape shape1, Shape shape2) {
			switch(comparisonType) {
				case 'v':
					return Double.compare(shape1.getVolume(), shape2.getVolume());
				case 'a':
					return Double.compare(shape1.getBaseArea(), shape2.getBaseArea());
				default:
					return 0;
			}
		}
	}
}

