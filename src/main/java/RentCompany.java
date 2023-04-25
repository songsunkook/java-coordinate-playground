import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import car.Car;

public class RentCompany {
	private List<Car> cars;

	public static RentCompany create() {
		RentCompany rentCompany = new RentCompany();
		rentCompany.cars = new ArrayList<Car>();
		return rentCompany;
	}

	public void addCar(Car car){
		cars.add(car);
	}

	public String generateReport(){
		String result = "";

		for(Car car:cars){
			result
				+= (car.getName())
				+(" : ")
				+Math.round(car.getChargeQuantity())
				+("리터")
				+System.getProperty("line.separator");
		}

		return result.toString();
	}
}
