package car;

public class Sonata extends Car {
	private static final int DISTANCE_PER_LITER = 10;
	private static final String NAME = "Sonata";

	private final int tripDistance;

	public Sonata(int tripDistance) {
		this.tripDistance = tripDistance;
	}

	@Override
	protected double getDistancePerLiter() {
		return DISTANCE_PER_LITER;
	}

	@Override
	protected double getTripDistance() {
		return tripDistance;
	}

	@Override
	public String getName() {
		return NAME;
	}
}
