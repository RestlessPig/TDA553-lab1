
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
/**
 * TransporterTests
 */
public class TransporterTests {

    Transporter transporter = new Transporter(1);
    Car volvo = new Volvo240();
    Car saab = new Saab95();
    //Test att flatbed.size() inte överskride flatbedCapacity
    @Test
    public void noMoreCarsOnFlatbedThanIsAllowed() {
        transporter.setRampForUse();
        transporter.loadVehicle(volvo);
        transporter.loadVehicle(saab);
        assertTrue(transporter.flatbed.storage.size() == 1);
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
        

    @Test void carIsPlacedCorrectlyWhenUnloaded() {
        
    }

    @Test
    public void carCantDriveOnFlatBed() {
        
    }
        
}
