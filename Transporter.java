import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Transporter
 */
public class Transporter extends Truck {
    
    public List<Car> flatbed; //change to private after tests are done
    private int flatbedCapacity;

    public Transporter(int flatbedCapacity) {
        super(2, Color.black, 500001, "jasonStathamWhoIsTheMainLeadInMovieTransporter");
        this.flatbed = new ArrayList<Car>();
        this.flatbedCapacity = flatbedCapacity;
    }

    @Override
    public void move(){
        //x += directionWheel.get(1) * getCurrentSpeed();
        //y += directionWheel.get(0) * getCurrentSpeed();
        super.move();
        for (Car c: flatbed) {
            this.transportVehicle(c);
        }
    }

    protected void transportVehicle(Car vehicle) {
        double[] transporterPosition = this.getPosition();
        System.out.println(transporterPosition[0]);
        System.out.println(transporterPosition[1]);
        vehicle.setPosition(transporterPosition[0], transporterPosition[1]);
    }


    public void loadVehicle(Car car) {
        if (loadVehicleIsSafe(car)) {
            flatbed.add(car);
            car.toggleIsBeingTransported();
        }
    }

    public void unloadVehicle(Car car) {
        if (unloadVehicleIsSafe(car)) {
            flatbed.remove(car);
            placeCarBehindTransporter(car);
        }
    }

    private boolean loadVehicleIsSafe(Car car) {
        return !getRampStandardPositionStatus() && 
        car.getCurrentSpeed() == 0 && 
        confirmCarProximity(car) && 
        flatbed.size() < this.flatbedCapacity;      //current speed of transporter always 0 while ramp not in standard position
    }

    private boolean unloadVehicleIsSafe(Car car) {
        return !getRampStandardPositionStatus();
    }

    private boolean confirmCarProximity(Car car) {
        return ((Math.abs(getPosition()[0] - car.getPosition()[0]) < 1) && 
                (Math.abs(getPosition()[1] - car.getPosition()[1]) < 1));
    }

    private void placeCarBehindTransporter(Car car) {
        car.toggleIsBeingTransported();
        car.setPosition((getPosition()[0] - getDirections()[0] * 2), (getPosition()[1] - getDirections()[1] * 2)); //sets car 2 units behind transporter
    }


}


//Bil kan ej flytta sig på flatbed
//Kan bara ladda avlasta bilar när ramp är upp och transporter står still

//Fixa calculate safe distance, sätt i vehicle för framtida kollision etc, OCP
//Fixa till loadvehicleissafe och unloadvehicleissafe

//TODO Fixa car repair shop med hjälp av delegering (ex loadable), minimera kodduplicering mellan transporter, Scania och car repair shop