import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class JUintOnOurCars {
    private Volvo240 car1 = new Volvo240();
    private Scania strongCar = new Scania();

	@Test
    public void dontGasMoreThanOne() {
        car1.startEngine();
        assertThrows(Error.class, () -> {
            car1.gas(2);
        });
    }

    @Test
    public void dontGasWithNegativeValues() {
        car1.startEngine();
        assertThrows(Error.class, () -> {
            car1.gas(-1);
        });
    }

    @Test
    public void dontBreakMoreThanOne() {
        car1.startEngine();
        assertThrows(Error.class, () -> {
            car1.brake(2);
        });
    }

    @Test
    public void dontBreakWithNegativeValues() {
        car1.startEngine();
        assertThrows(Error.class, () -> {
            car1.brake(-1);
        });
    }

    @Test
    public void gasWithZero() {
        car1.startEngine();
        double firstSpeed = car1.getCurrentSpeed();
        car1.gas(0);
        double secondSpeed = car1.getCurrentSpeed();
        assertEquals(firstSpeed, secondSpeed, 0.0);
    }
    @Test
    public void gasWithOne() {
        car1.startEngine();
        double firstSpeed = car1.getCurrentSpeed();
        car1.gas(1);
        double secondSpeed = car1.getCurrentSpeed();
        assertTrue(firstSpeed < secondSpeed);
    }

    @Test
    public void breakWithZero() {
        car1.startEngine();
        car1.gas(1);
        double firstSpeed = car1.getCurrentSpeed();
        car1.brake(0);
        double secondSpeed = car1.getCurrentSpeed();
        assertEquals(firstSpeed, secondSpeed, 0.0);
    }
    @Test
    public void breakWithOne() {
        car1.startEngine();
        car1.gas(1);
        double firstSpeed = car1.getCurrentSpeed();
        car1.brake(1);
        double secondSpeed = car1.getCurrentSpeed();
        assertTrue(firstSpeed > secondSpeed);
    }

    @Test
    public void currentSpeedIsWithinRangeZeroToEnginePower() {
        car1.startEngine();
        for (int i = 0; i < 200; i++) {
            car1.brake(1);   
        }
        double firstSpeed = car1.getCurrentSpeed();
        for (int i = 0; i < 200; i++) {
            car1.gas(1);
        }
        double secondSpeed = car1.getCurrentSpeed();
        assertTrue(0 <= firstSpeed && secondSpeed <= car1.getEnginePower());
    }

    @Test
    public void moveCausesCarToMove() {
        car1.startEngine();
        for (int i = 0; i < 10; i++) {
            car1.gas(1);
        }
        double[] pos1 = car1.getCarPosition();
        car1.move();
        double[] pos2 = car1.getCarPosition();
        assertTrue(!pos1.equals(pos2));
    }

    @Test
    public void carOnlyMovesInOneDirection() {
        car1.startEngine();
        for (int i = 0; i < 10; i++) {
            car1.gas(1);
        }
        double[] pos1 = car1.getCarPosition();
        car1.move();
        double[] pos2 = car1.getCarPosition();
        car1.turnLeft();
        double[] pos3 = car1.getCarPosition();
        car1.move();
        double[] pos4 = car1.getCarPosition();
        assertTrue((pos1[1] != pos2[1] && pos1[0] == pos2[0]) && (pos3[1] == pos4[1] && pos3[0] != pos4[0]));
    }

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



/* Saker vi vill testa; 

(0 <= currentSpeed <= enginePower)pass    
gas      bara value 0 till 1      pass
break    bara value 0 till 1      pass
*/