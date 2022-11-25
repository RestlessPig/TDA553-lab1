import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Transporter
 */
public class Transporter extends Truck {
    
    private List<Car> flatbed;

    public Transporter(int flatbedSize) {
        super(2, Color.black, 500001, "jasonStathamWhoIsTheMainLeadInMovieTransporter");
        flatbed = new ArrayList<Car>();
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
        double[] transporterPosition = this.getCarPosition();
        vehicle.setCarPosition(transporterPosition[0], transporterPosition[1]);
    }


    private void loadVehicle(Car car) {
        if (loadVehicleIsSafe(car)) {
            flatbed.add(car);
            car.toggleIsBeingTransported();
        }
    }

    private void unloadVehicle(Car car) {
        if (unloadVehicleIsSafe(car)) {
            flatbed.remove(car);
            car.toggleIsBeingTransported();
        }

    }

    //TODO fortsätt här
    private boolean loadVehicleIsSafe(Car car) {
        return !getRampStandardPositionStatus() && car.getCurrentSpeed() == 0 && Math.abs(getCarPosition()[0] - car.getCarPosition()[0]) < 5 && Math.abs(getCarPosition()[1] - car.getCarPosition()[1]) < 5;
    }

    private boolean unloadVehicleIsSafe(Car car) {
        return !getRampStandardPositionStatus();
    }


}


//Bil kan ej flytta sig på flatbed
//Kan bara ladda avlasta bilar när ramp är upp och transporter står still

//Fixa calculate safe distance, sätt i vehicle för framtida kollision etc, OCP
//Fixa till loadvehicleissafe och unloadvehicleissafe
