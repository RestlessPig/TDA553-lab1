import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Loadable
 */
public class CarLoader {

    public List<Car> storage; //change to private after tests are done
    public final int carSlots;
    public final int safeLoadDistance = 1;

    public CarLoader(int carSlots) {
        this.storage = new ArrayList<>();
        this.carSlots = carSlots;
    }

    protected void loadVehicle(Car c) {
        storage.add(c);
        c.toggleIsLoaded();
    }

    protected void unloadVehicle(Car car) {
        this.storage.remove(car);
        car.toggleIsLoaded();
    }

    protected void placeCarNearLoader(Car car) {
        double offsetX = getRandomOffset();
        double offsetY = getRandomOffset();
        double[] currentPosition = car.getPosition();
        car.setPosition(currentPosition[0] + offsetX, currentPosition[1] + offsetY);
    }

    private double getRandomOffset() {
        Random random = new Random();
        double offset = random.nextDouble();
        offset *= safeLoadDistance;
        offset -= (safeLoadDistance / 2.0);
        return offset;
    }

    protected boolean ableToLoadVehicle(Car car, double x, double y) { 
        return car.getCurrentSpeed() == 0 && 
        confirmCarProximity(car, x, y) && 
        storage.size() < carSlots;      //current speed of transporter always 0 while ramp not in standard position
    }

    //TBD if this is necessary here
    private boolean confirmCarProximity(Car car, double x, double y) { 
        return (Math.abs(x - car.getPosition()[0]) < safeLoadDistance) && 
                (Math.abs(y - car.getPosition()[1]) < safeLoadDistance);
    } 



// **Eventuell implementation**
// I transporter kollar vi avstånd transporter - bil
// I car repair shop kollar vi avstånd shop - bil
// I loadable laddar vi då på bilen om avtåndet är inom safeLoadDistance
}