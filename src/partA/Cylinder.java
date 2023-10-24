package partA;

public class Cylinder extends Shape {
    private double radius;
	private double baseArea;
	private double volume;

    public Cylinder(double height, double radius) {
        super();
        this.radius = radius;
        calculateBaseArea();
        calculateVolume();
    }

    public void calculateBaseArea() {
        this.baseArea = Math.PI * Math.pow(this.radius, 2);
    }

    public void calculateVolume() {
        this.volume = Math.PI * Math.pow(this.radius, 2) * this.getHeight();
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        calculateBaseArea();
        calculateVolume();
    }

    @Override
    public String toString() {
        return String.format("Cylinder [Height: %.2f, Radius: %.2f, Base Area: %.2f, Volume: %.2f]",
                this.getHeight(), this.radius, this.baseArea, this.volume);
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
