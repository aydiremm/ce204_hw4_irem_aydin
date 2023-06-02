package ce204_hw4_lib.rentCar;



/**
 * @name Car
 * @brief Package for car rental management.
 * @brief Car abstract class.
 * This abstract class represents a car. It provides common attributes and methods that all car types inherit.
 */
public abstract class Car {
    protected String brand;
    protected String model;
    protected int year;
    protected double price;
    
    protected Vendor vendor;

    
    /**
     * @brief Constructs a car object with the specified brand, model, and year.
     *
     * @param brand The brand of the car.
     * @param model The model of the car.
     * @param year The year of the car.
     */
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.vendor = null;
    }

    
    /**
     * @brief Displays the information about the car.
     *
     * This method should be implemented by the subclasses to display specific information about the car type.
     */
    public abstract void displayInfo();

    
    /**
     * @brief Gets the price of the car.
     *
     * @return The price of the car.
     */
    public double getPrice() {
        return price;
    }

    
    /**
     * @brief Sets the price of the car.
     *
     * @param price The price of the car.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    
    /**
     * @brief Gets the brand of the car.
     *
     * @return The brand of the car.
     */
    public String getBrand() {
        return brand;
    }

    
    /**
     * @brief Gets the model of the car.
     *
     * @return The model of the car.
     */
    public String getModel() {
        return model;
    }

    
    /**
     * @brief Gets the year of the car.
     *
     * @return The year of the car.
     */
    public int getYear() {
        return year;
    }
    
    /**
     * @brief Sets the vendor of the car.
     *
     * @return The vendor of the car.
     */
    public void setVendor(Vendor vendor) {
    	this.vendor = vendor;
    }
    
    
    /**
     * @brief Gets the vendor of the car.
     *
     * @return The vendor of the car.
     */
    public Vendor getVendor() {
    	return vendor;
    }
}



