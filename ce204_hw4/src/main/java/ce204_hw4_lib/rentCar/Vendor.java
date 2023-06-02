package ce204_hw4_lib.rentCar;

import java.util.ArrayList;
import java.util.List;


/**
 * @name Vendor
 * @brief Represents a car rental vendor.
 *
 * This class represents a car rental vendor and provides methods to manage and calculate rental costs for cars.
 */
public class Vendor {
    private int vendorId;
    private String vendorName;
    private String contactInformation;
    private List<Car> cars;
    private double rentalCost = 0;

    
    /**
     * @brief Constructs a Vendor object with the specified details.
     *
     * This constructor creates a Vendor object with the provided vendor ID, vendor name, and contact information.
     * It also initializes an empty list of cars.
     *
     * @param vendorId The ID of the vendor.
     * @param vendorName The name of the vendor.
     * @param contactInformation The contact information of the vendor.
     */
    public Vendor(int vendorId, String vendorName, String contactInformation) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.contactInformation = contactInformation;
        this.cars = new ArrayList<>();
    }

    
    /**
     * @brief Retrieves the vendor ID.
     *
     * This method returns the ID of the vendor.
     *
     * @retval The vendor ID.
     */
    public int getVendorId() {
        return vendorId;
    }

    
    /**
     * @brief Retrieves the vendor name.
     *
     * This method returns the name of the vendor.
     *
     * @retval The vendor name.
     */
    public String getVendorName() {
        return vendorName;
    }

    
    /**
     * @brief Retrieves the contact information of the vendor.
     *
     * This method returns the contact information of the vendor.
     *
     * @retval The contact information of the vendor.
     */
    public String getContactInformation() {
        return contactInformation;
    }

    
    /**
     * @brief Calculates the rental cost based on the rental duration and car type.
     *
     * This method calculates the rental cost by multiplying the base price of the car type with the rental duration.
     *
     * @param rentalDuration The duration of the rental in days.
     * @param carType The type of the car (e.g., "economic", "luxury", "suv", "sports").
     * @retval The calculated rental cost.
     */
    public double calculateRentalCost(int rentalDuration, String carType) { //bura yani
        double basePrice = 0.0;

        if (carType.equalsIgnoreCase("economic")) {
            basePrice = 50.0; 
        } else if (carType.equalsIgnoreCase("luxury")) {
            basePrice = 100.0; 
        } else if (carType.equalsIgnoreCase("suv")) {
            basePrice = 80.0; 
        } else if (carType.equalsIgnoreCase("sports")) {
            basePrice = 120.0; 
        }

        rentalCost = basePrice * rentalDuration;

        return rentalCost;
    }
    
    
    /**
     * @brief Retrieves the rental cost.
     *
     * This method returns the rental cost calculated by the previous call to calculateRentalCost().
     *
     * @retval The rental cost.
     */
    public double getRentalCost() {   	
    	return rentalCost;
    }

    
    /**
     * @brief Adds a car to the vendor's inventory.
     *
     * This method adds the specified car to the vendor's inventory.
     *
     * @param car The car to be added.
     */
    public void addCar(Car car) {
        cars.add(car);
    }

    
    /**
     * @brief Removes a car from the vendor's inventory.
     *
     * This method removes the specified car from the vendor's inventory.
     *
     * @param car The car to be removed.
     */
    public void removeCar(Car car) {
        cars.remove(car);
    }

    
    /**
     * @brief Checks if the vendor has a specific car in their inventory.
     *
     * This method checks if the specified car is present in the vendor's inventory.
     *
     * @param car The car to be checked.
     * @retval true if the vendor has the car, false otherwise.
     */
    public boolean hasCar(Car car) {
        return cars.contains(car);
    }
}
