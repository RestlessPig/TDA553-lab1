import java.awt.Color;

/**
 * Transporter
 */
public class Transporter extends Truck {
    
    public CarLoader flatbed; // TODO public temporärt

    public Transporter(int flatbedSlots) {
        super(2, Color.black, 175, "CarThatTransports");
        flatbed = new CarLoader(flatbedSlots);
    }

    @Override
    public void move(){
        //x += directionWheel.get(1) * getCurrentSpeed();
        //y += directionWheel.get(0) * getCurrentSpeed();
        super.move();
        for (Car c: flatbed.storage) {
            this.transportVehicle(c);
        }
    }

    protected void transportVehicle(Car car) {
        double[] transporterPosition = this.getPosition();
        car.setPosition(transporterPosition[0], transporterPosition[1]);
    }

    public void loadVehicle(Car car) {
        if (ableToLoadVehicle(car)) {
            flatbed.loadVehicle(car);
        }
    }

    public void unloadVehicle(Car car) {
        if (ableToUnloadVehicle())  {
            flatbed.unloadVehicle(car);
        }
    }

    private boolean ableToLoadVehicle(Car car) {
        double[] pos = getPosition();
        return !getRampStandardPositionStatus() && flatbed.ableToLoadVehicle(car, pos[0], pos[1]);
        //car.getCurrentSpeed() == 0 && 
        //confirmCarProximity(car) && 
        //flatbed.storage.size() < flatbed.carSlots;      //current speed of transporter always 0 while ramp not in standard position
    }

    private boolean ableToUnloadVehicle() {
        return !getRampStandardPositionStatus();
    }

    // private void placeCarNearLoader(Car car) { //Delegated to Loadable
    //      car.setPosition((getPosition()[0] - getDirections()[0] * 2), (getPosition()[1] - getDirections()[1] * 2)); //sets car 2 units behind transporter
    // }

}


//Bil kan ej flytta sig på flatbed
//Kan bara ladda avlasta bilar när ramp är upp och transporter står still

//Fixa calculate safe distance, sätt i vehicle för framtida kollision etc, OCP
//Fixa till loadvehicleissafe och unloadvehicleissafe

//TODO Fixa tester, dubbelkolla kodduplicering, dubbelkolla Loadable-implementation samt om den ska kolla avstånd (checkcarproximity etc) 
//med hjälp av pythagoras, nvm skit i det.