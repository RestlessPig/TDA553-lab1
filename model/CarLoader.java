package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Loadable
 */
public class CarLoader {

    private List<Car> storage; 
    private final int carSlots;
    private final int safeLoadDistance = 1;

    public CarLoader(int carSlots) {
        this.storage = new ArrayList<>();
        this.carSlots = carSlots;
    }

    public List<Car> getStorage() {
        return storage;
    }

    protected void loadVehicle(Car c) {
        storage.add(c);
        c.toggleIsLoaded();
    }

    protected void unloadVehicle(Car car) {
        boolean carWasOnLoader = this.storage.remove(car); 
        if (carWasOnLoader) {
            car.toggleIsLoaded();
        } else {
            throw new Error("Cannot unload car which is not currently on loader");
        }
    }

    protected void placeCarNearLoader(Car car) {
        double offsetX = getRandomOffset();
        double offsetY = getRandomOffset();
        double[] currentPosition = car.getPosition();
        car.setPosition(currentPosition[0] + offsetX, currentPosition[1] + offsetY);
    }

    private double getRandomOffset() { // Calculates a random dropoff point relative to the CarLoaders "Parent"
        Random random = new Random();
        double offset = random.nextDouble();
        offset *= (safeLoadDistance * 2);
        offset -= safeLoadDistance;
        return offset;
    }

    protected boolean ableToLoadVehicle(Car car, double x, double y) { 
        return !car.isLoaded() &&
        car.getCurrentSpeed() == 0 && 
        confirmCarProximity(car, x, y) && 
        storage.size() < carSlots;
        //current speed of transporter always 0 while ramp not in standard position
    }

    private boolean confirmCarProximity(Car car, double x, double y) { 
        return (Math.abs(x - car.getPosition()[0]) < safeLoadDistance) && 
                (Math.abs(y - car.getPosition()[1]) < safeLoadDistance);
    } 

}