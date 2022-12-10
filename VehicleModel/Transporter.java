package VehicleModel;

import java.awt.Color;

/**
 * Transporter
 */
public class Transporter extends Truck {
    
    private CarLoader flatbed;

    public Transporter(int flatbedSlots) {
        super(2, Color.black, 175, "CarThatTransports", 0, 0);
        flatbed = new CarLoader(flatbedSlots);
        
    }

    @Override
    public void move() {
        super.move();
        for (Car c: flatbed.getStorage()) {
            this.transportVehicle(c);
        }
    }

    private void transportVehicle(Car car) {
        double[] transporterPosition = this.getPosition();
        car.setPosition(transporterPosition[0], transporterPosition[1]);
    }

    public void loadVehicle(Car car) {
        if (ableToLoadVehicle(car)) {
            flatbed.loadVehicle(car);
        } else { 
            throw new Error("Cannot load vehicle");
        }
    }

    public void unloadVehicle(Car car) {
        if (ableToUnloadVehicle())  {
            flatbed.unloadVehicle(car);
        } else {
            throw new Error("Cannot unload vehicle");
        }
    }

    private boolean ableToLoadVehicle(Car car) {
        double[] pos = getPosition();
        return !getRampStandardPositionStatus() && flatbed.ableToLoadVehicle(car, pos[0], pos[1]);
    }

    private boolean ableToUnloadVehicle() {
        return !getRampStandardPositionStatus();
    }

}