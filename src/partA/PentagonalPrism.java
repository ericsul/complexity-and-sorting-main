package partA;

public class PentagonalPrism extends Shape {
    private double edgeLength;
	private double baseArea;
	private double volume;

    public PentagonalPrism(double height, double edgeLength) {
        super();
        this.edgeLength = edgeLength;
        calculateBaseArea();
        calculateVolume();
    }

    public void calculateBaseArea() {
        this.baseArea = (5 * Math.pow(this.edgeLength, 2) * Math.tan(Math.toRadians(54))) / 4;
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
        return String.format("PentagonalPrism [Height: %.2f, Edge Length: %.2f, Base Area: %.2f, Volume: %.2f]",
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

