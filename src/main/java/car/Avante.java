package car;

public class Avante implements Car {
	private static final int DISTANCE_PER_LITER = 15;
	private static final String NAME = "Avante";

	private final int tripDistance;

	public Avante(int tripDistance) {
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
