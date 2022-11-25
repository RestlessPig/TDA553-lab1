import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
/**
 * ScaniaTests
 */
public class ScaniaTests {

    Scania strongCar = new Scania();

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
        strongCar.setCurrentSpeed(1);
        assertThrows(Error.class, () -> {
            strongCar.changePlatformAngle(10);
        });
    }

    @Test
    public void scaniaPlatformAngleUpperLimit() {
        strongCar.setCurrentSpeed(0);
        assertThrows(Error.class, () -> {
            strongCar.changePlatformAngle(71);
        });
    }

    @Test
    public void scaniaPlatformAngleLowerLimit() {
        strongCar.setCurrentSpeed(0);
        assertThrows(Error.class, () -> {
            strongCar.changePlatformAngle(-1);
        });
    }
}