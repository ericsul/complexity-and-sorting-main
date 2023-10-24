package partA;

public class TriangularPrism extends Shape {
    private double edgeLength;
	private double baseArea;
	private double volume;

    public TriangularPrism(double height, double edgeLength) {
        super();
        this.edgeLength = edgeLength;
        calculateBaseArea();
        calculateVolume();
    }

    public void calculateBaseArea() {
        this.baseArea = (Math.pow(this.edgeLength, 2) * Math.sqrt(3)) / 4;
    }

    public void calculateVolume() {
        this.volume = this.baseArea * this.getHeight();
    }

    public double getEdgeLength() {
        return this.edgeLength;
    }

    public void setEdgeLength(double edgeLength) {
        this.edgeLength = edgeLength;
        calculateBaseArea();
        calculateVolume();
    }

    @Override
    public String toString() {
        return String.format("TriangularPrism [Height: %.2f, Edge Length: %.2f, Base Area: %.2f, Volume: %.2f]",
                this.getHeight(), this.edgeLength, this.baseArea, this.volume);
    }

	@Override
	public double getBaseArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getVolume() {
		// TODO Auto-generated method stub
		return 0;
	}
}

