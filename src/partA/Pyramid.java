package partA;

public class Pyramid extends Shape {
    private double edgeLength;

    public Pyramid(double height, double edgeLength) {
        super();
        this.edgeLength = edgeLength;
        calculateBaseArea();
        calculateVolume();
    }

    public void calculateBaseArea() {
        this.edgeLength = Math.pow(this.edgeLength, 2);
    }

    public void calculateVolume() {
        this.edgeLength = (1.0 / 3.0) * this.getBaseArea() * this.getHeight();
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
        return String.format("Pyramid [Height: %.2f, Edge Length: %.2f, Base Area: %.2f, Volume: %.2f]",
                this.getHeight(), this.edgeLength, this.edgeLength, this.edgeLength);
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
