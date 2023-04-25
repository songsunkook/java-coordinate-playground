package car;

public class K5 extends Car {
	private static final int DISTANCE_PER_LITER = 13;
	private static final String NAME = "K5";

	private final int tripDistance;

	public K5(int tripDistance) {
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
