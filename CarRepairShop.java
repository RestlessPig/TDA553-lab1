/**
 * CarRepairShop
 */
public class CarRepairShop {

    private CarLoader carStorage;
    private final double x;
    private final double y;

    public CarRepairShop(double x, double y, int carSlots) {
        this.carStorage = new CarLoader(carSlots);
        this.x = x;
        this.y = y;
    }


    public void loadVehicle(Car car) {
        if (carStorage.ableToLoadVehicle(car, x, y)) {
            carStorage.loadVehicle(car);
        } else {
            throw new Error("Cannot load vehicle");
        }
    }

    public void unloadVehicle(Car car) {
        carStorage.unloadVehicle(car);
        carStorage.placeCarNearLoader(car);
    }

}