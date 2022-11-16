import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class JUintOnOurCars {
    private Saab95 car1 = new Saab95();

    //@Test
    //void turboOnSetsTurboOn() {
    //    assertEquals(True , setTurboOn());
    //}

	@Test
    public void dontGasMoreThanOne() {
        car1.startEngine();
        double firstSpeed = car1.getCurrentSpeed();
        car1.gas(2);
        double secondSpeed = car1.getCurrentSpeed();
        assertTrue(!(firstSpeed < secondSpeed));
    }

    @Test
    public void dontGasWithNegativeValues() {
        car1.startEngine();
        double firstSpeed = car1.getCurrentSpeed();
        car1.gas(-1);
        double secondSpeed = car1.getCurrentSpeed();
        assertTrue(!(firstSpeed > secondSpeed));
    }

    @Test
    public void dontBreakMoreThanOne() {
        car1.startEngine();
        double firstSpeed = car1.getCurrentSpeed();
        car1.gas(2);
        double secondSpeed = car1.getCurrentSpeed();
        assertTrue(!(firstSpeed > secondSpeed));
    }

    @Test
    public void dontBreakWithNegativeValues() {
        car1.startEngine();
        double firstSpeed = car1.getCurrentSpeed();
        car1.gas(-1);
        double secondSpeed = car1.getCurrentSpeed();
        assertTrue(!(firstSpeed < secondSpeed));
    }

    @Test
    public void gasWithZero() {
        car1.startEngine();
        double firstSpeed = car1.getCurrentSpeed();
        car1.gas(0);
        double secondSpeed = car1.getCurrentSpeed();
        assertEquals(firstSpeed, secondSpeed, 0.000001);
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
        assertEquals(firstSpeed, secondSpeed, 0.000001);
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
}



/* Saker vi vill testa; 

(0 <= currentSpeed <= enginePower)pass    
gas      bara value 0 till 1      pass
break    bara value 0 till 1      pass
*/