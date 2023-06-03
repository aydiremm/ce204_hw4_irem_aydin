package ce204_hw4_lib.rentCar;


/**
 * @name CarFactory
 * @brief Creates a car object based on the provided car type, brand, model, and year.
 * @param carType The type of the car to create (economic, luxury, suv, sports).
 * @param brand The brand of the car.
 * @param model The model of the car.
 * @param year The manufacturing year of the car.
 * @retval Car The created car object. Returns null if an invalid car type is provided.
 */
public class CarFactory {
    public static Car createCar(String carType, String brand, String model, int year) {
        Car car = null;
        switch (carType.toLowerCase()) {
            case "economic":
                car = new EconomicCar(brand, model, year);
                break;
            case "luxury":
                car = new LuxuryCar(brand, model, year);
                break;
            case "suv":
                car = new SUVCar(brand, model, year);
                break;
            case "sports":
                car = new SportsCar(brand, model, year);
                break;
            default:
                System.out.println("Invalid car type.");
        }
        return car;
    }
}
