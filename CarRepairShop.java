/**
 * CarRepairShop
 */
public class CarRepairShop {

    private CarLoader carStorage;
    private double x;
    private double y;

    public CarRepairShop(double x, double y, int carSlots) {
        carStorage = new CarLoader(carSlots);
    }


    public void loadVehicle(Car car) {
        if (carStorage.ableToLoadVehicle(car, x, y)) {
            carStorage.loadVehicle(car);
        }
    }

    public void unloadVehicle(Car car) {
        carStorage.unloadVehicle(car);
        carStorage.placeCarNearLoader(car);
    }

    //private boolean ableToLoadVehicle(Car car) { 
    //    return car.getCurrentSpeed() == 0 && 
    //    confirmCarProximity(car) && 
    //    carStorage.storage.size() < carStorage.carSlots;      //current speed of transporter always 0 while ramp not in standard position
    //}

 
}