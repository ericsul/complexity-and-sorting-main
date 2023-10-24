package partA;

public abstract class Prism extends Shape {
    protected double edgeLength;

    public Prism(double height, double edgeLength) {
        super();
        this.edgeLength = edgeLength;
        calculateBaseArea();
        calculateVolume();
    }

    protected abstract void calculateVolume();

	protected abstract void calculateBaseArea();

	public double getEdgeLength() {
        return edgeLength;
    }

    public void setEdgeLength(double edgeLength) {
        this.edgeLength = edgeLength;
        calculateBaseArea();
        calculateVolume();
    }

    @Override
    public String toString() {
        return String.format("Prism [Height: %.2f, Edge Length: %.2f, Base Area: %.2f, Volume: %.2f]",
                this.getHeight(), this.edgeLength, this.getBaseArea(), this.getVolume());
    }
}
