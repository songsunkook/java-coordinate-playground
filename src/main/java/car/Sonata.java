package car;

public class Sonata implements Car {
	private static final int DISTANCE_PER_LITER = 10;
	private static final String NAME = "Sonata";

	private final int tripDistance;

	public Sonata(int tripDistance) {
		this.tripDistance = tripDistance;
	}

	@Override
	public double getDistancePerLiter() {
		return DISTANCE_PER_LITER;
	}

	@Override
	public double getTripDistance() {
		return tripDistance;
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public double getChargeQuantity() {
		return getTripDistance() / getDistancePerLiter();
	}
}
