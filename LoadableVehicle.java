import java.awt.Color;
/**
 * SmallCar
 */
// Kolla med TA om detta är en bra ide eller om man ska få skapa transporterstacks
public abstract class LoadableVehicle extends Vehicle {

    LoadableVehicle(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }

}