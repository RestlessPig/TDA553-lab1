import org.junit.jupiter.api.Test;

import VehicleModel.Car;
import VehicleModel.Saab95;
import VehicleModel.Transporter;
import VehicleModel.Volvo240;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
/**
 * TransporterTests
 */

/* 
 * Some of these tests covers testing of CarRepairShop, so no specific testing-file for CarRepairShop is needed
 */
public class TransporterTests {

    Transporter transporter = new Transporter(1);
    Car volvo = new Volvo240(0.0,0.0);
    Car saab = new Saab95(0.0,0.0);
    Car volvo2 = new Volvo240(0.0,0.0);
    Transporter transporter2 = new Transporter(3);
    
    
    @Test
    public void noMoreCarsOnFlatbedThanIsAllowed() {
        transporter.setRampForUse();
        transporter.loadVehicle(volvo);
        assertThrows(Error.class, () -> {
            transporter.loadVehicle(saab);
        });       
    }
    
    @Test
    public void carFollowsTransporter() {
        transporter.setRampForUse();
        transporter.loadVehicle(volvo);
        transporter.setRampStandardPosition();
        transporter.gas(1);
        transporter.move();
        assertEquals(transporter.getPosition()[0], volvo.getPosition()[0], 0.000001);
        assertEquals(transporter.getPosition()[1], volvo.getPosition()[1], 0.000001);
    }
        
    @Test void carIsPlacedNearbyWhenUnloaded() {
        transporter2.setRampForUse();
        transporter2.loadVehicle(saab);
        transporter2.loadVehicle(volvo);
        transporter2.loadVehicle(volvo2);
        transporter2.unloadVehicle(saab);
        transporter2.unloadVehicle(volvo);
        transporter2.unloadVehicle(volvo2);
        assertEquals(transporter2.getPosition()[0], saab.getPosition()[0], 1); //Last argument is the safe loading distance
        assertEquals(transporter2.getPosition()[1], saab.getPosition()[1], 1);
        assertEquals(transporter2.getPosition()[0], volvo.getPosition()[0], 1);
        assertEquals(transporter2.getPosition()[1], volvo.getPosition()[1], 1);
        assertEquals(transporter2.getPosition()[0], volvo2.getPosition()[0], 1);
        assertEquals(transporter2.getPosition()[1], volvo2.getPosition()[1], 1);
    }

    @Test
    public void cannotLoadLoadedCar() {
        transporter.setRampForUse();
        transporter.loadVehicle(saab);
        assertThrows(Error.class, () -> {
            transporter.loadVehicle(saab);
        });
    }

    @Test
    public void cannotUnloadUnloadedCar() {
        transporter.setRampForUse();
        transporter.loadVehicle(saab);
        transporter.unloadVehicle(saab);
        assertThrows(Error.class, () -> {
            transporter.unloadVehicle(saab);
        });
    }

    @Test
    public void carCantDriveOnFlatBed() {
        transporter.setRampForUse();
        transporter.loadVehicle(saab);
        saab.gas(1);
        assertThrows(Error.class, () -> {
            saab.move();
        });
    }
}
