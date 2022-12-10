
import org.junit.jupiter.api.Test;

import vehiclemodel.Volvo240;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class CarTests {
    private Volvo240 car1 = new Volvo240(0.0,0.0);

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
        double[] pos1 = car1.getPosition();
        car1.move();
        double[] pos2 = car1.getPosition();
        assertTrue(!pos1.equals(pos2));
    }

    @Test //Default orientation is "up" checks if the car has moved in the left direction after turning
    public void carCanTurnLeft() {
        car1.startEngine();
        for (int i = 0; i < 10; i++) {
            car1.gas(1);
        }
        double[] pos1 = car1.getPosition();
        car1.turnLeft();
        car1.move();
        double[] pos2 = car1.getPosition();
        assertTrue(pos1[1] == 0 && pos2[1] == 0 && pos1[0] > pos2[0]);
    }

    @Test //Default orientation is "up" checks if the car has moved in the right direction after turning
    public void carCanTurnRight() {
        car1.startEngine();
        for (int i = 0; i < 10; i++) {
            car1.gas(1);
        }
        double[] pos1 = car1.getPosition();
        car1.turnRight();
        car1.move();
        double[] pos2 = car1.getPosition();
        assertTrue(pos1[1] == 0 && pos2[1] == 0 && pos1[0] < pos2[0]);
    }

    // Not needed
    //@Test
    //public void carOnlyMovesInOneDirection() {
    //    car1.startEngine();
    //    for (int i = 0; i < 10; i++) {
    //        car1.gas(1);
    //    }
    //    double[] pos1 = car1.getPosition();
    //    car1.move();
    //    double[] pos2 = car1.getPosition();
    //    car1.turnLeft();
    //    double[] pos3 = car1.getPosition();
    //    car1.move();
    //    double[] pos4 = car1.getPosition();
    //    assertTrue((pos1[1] != pos2[1] && pos1[0] == pos2[0]) && (pos3[1] == pos4[1] && pos3[0] != pos4[0]));
    //}

}



/* Saker vi vill testa; 

(0 <= currentSpeed <= enginePower)pass    
gas      bara value 0 till 1      pass
break    bara value 0 till 1      pass
*/