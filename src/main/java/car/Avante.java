package car;

public class Avante extends Car {
	private static final int DISTANCE_PER_LITER = 15;
	private static final String NAME = "Avante";

	private final int tripDistance;

	public Avante(int tripDistance) {
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
