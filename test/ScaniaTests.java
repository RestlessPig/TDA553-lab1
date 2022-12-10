
import org.junit.jupiter.api.Test;

import vehiclemodel.Scania;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
//import static org.junit.Assert.assertTrue;
/**
 * ScaniaTests
 */
public class ScaniaTests {

    Scania strongCar = new Scania(0.0,0.0);

    @Test
    public void scaniaCanNotMoveWhilePlatformIsUp() {
        strongCar.changePlatformAngle(10);
        assertThrows(Error.class, () -> {
            strongCar.gas(1);
        });
    }

    @Test
    public void scaniaPlatformCanNotChangeWhileDriving() {
        strongCar.changePlatformAngle(0);
        strongCar.gas(1);
        assertThrows(Error.class, () -> {
            strongCar.changePlatformAngle(10);
        });
    }

    @Test
    public void scaniaPlatformAngleUpperLimit() {
        strongCar.brake(1);
        assertThrows(Error.class, () -> {
            strongCar.changePlatformAngle(71);
        });
    }

    @Test
    public void scaniaPlatformAngleLowerLimit() {
        strongCar.brake(1);
        assertThrows(Error.class, () -> {
            strongCar.changePlatformAngle(-1);
        });
    }
}