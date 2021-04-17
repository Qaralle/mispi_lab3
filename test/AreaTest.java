import main.Result;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Math.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AreaTest {
    private Result result;

    @Before
    public void __init__() {
        result = new Result();
    }

    @After
    public void tearDown() {
        result = null;
    }

    @Test(expected = NullPointerException.class)
    public void nullMinusXValueTest() {
        result.setX(-5.0);
        result.setY(-1.0);
        result.setR(2.0);

        result.checkTheArea();
        assertTrue(result.getResult());
    }

    @Test(expected = NullPointerException.class)
    public void nullPlusXValueTest() {
        result.setX(5.0);
        result.setY(-1.0);
        result.setR(2.0);

        result.checkTheArea();
        assertFalse(result.getResult());
    }

    @Test(expected = NullPointerException.class)
    public void nullMinusYValueTest() {
        result.setX(-2.0);
        result.setY(-5.0);
        result.setR(2.0);

        result.checkTheArea();
        assertTrue(result.getResult());
    }

    @Test(expected = NullPointerException.class)
    public void nullPlusYValueTest() {
        result.setX(1.0);
        result.setY(5.0);
        result.setR(2.0);

        result.checkTheArea();
        assertFalse(result.getResult());
    }

    @Test(expected = NullPointerException.class)
    public void nullMinRValueTest() {
        result.setX(-2.0);
        result.setY(-1.0);
        result.setR(0.0);

        result.checkTheArea();
        assertTrue(result.getResult());
    }

    @Test(expected = NullPointerException.class)
    public void nullMaxRValueTest() {
        result.setX(1.0);
        result.setY(1.0);
        result.setR(4.0);

        result.checkTheArea();
        assertFalse(result.getResult());
    }

    @Test
    public void rectangularHitTest() {

        result.setR(2.0);

        for (double i = -2; i <= 0; i+=0.1) {
            for (double j = -1; j <= 0; j+=0.1) {
                result.setX(i);
                result.setY(j);
                result.checkTheArea();
                assertTrue(result.getResult());
            }
        }


    }

    @Test
    public void rectangularMissLeftPartTest() {
        result.setR(2.0);

        for (double i = -2; i <= 0; i+=0.1) {
            for (double j = -3; j < -1; j+=0.1) {
                result.setX(i);
                result.setY(j);
                result.checkTheArea();
                assertFalse(result.getResult());
            }
        }

    }

    @Test
    public void rectangularMissRightPartTest() {
        result.setR(2.0);

        for (double i = 0.1; i <= 2; i+=0.1) {
            for (double j = -3; j < 0; j+=0.1) {
                result.setX(i);
                result.setY(j);
                result.checkTheArea();
                assertFalse(result.getResult());
            }
        }

    }

    @Test
    public void quadrantMissTest() {
        result.setR(2.0);

        for (double i = -2; i <-1; i+=0.1) {
            for (double j = 1; j < 3; j+=0.1) {
                if (pow(i,2) + pow(j,2)>pow(result.getR()/2,2)){
                    result.setX(i);
                    result.setY(j);
                    result.checkTheArea();
                    assertFalse(result.getResult());
                }
            }
        }
    }

    @Test
    public void quadrantHitTest(){
        result.setR(2.0);

        for (double i = -1; i <=0; i+=0.1) {
            for (double j = 0; j <=1; j+=0.1) {
                if (pow(i,2) + pow(j,2)<=pow(result.getR()/2,2)){
                    result.setX(i);
                    result.setY(j);
                    result.checkTheArea();
                    assertTrue(result.getResult());
                }
            }
        }
    }

    @Test
    public void triangleMissTest() {
        result.setR(2.0);

        for (double i = 0; i <=2; i+=0.1) {
            for (double j = 0; j <=1; j+=0.1) {
                result.setX(i);
                result.setY(j);
                if (j > - i / 2 + result.getR() / 2) {
                    result.setY(j);
                    result.checkTheArea();
                    assertFalse(result.getResult());
                }
            }
        }
    }

    @Test
    public void triangleHitTest() {
        result.setR(2.0);

        for (double i = 0; i <=2; i+=0.1) {
            for (double j = 0; j <=1; j+=0.1) {
                result.setX(i);
                result.setY(j);
                if (j <= -result.getX()/2 + result.getR()/2){
                    result.checkTheArea();
                    assertTrue(result.getResult());
                }
            }
        }
    }

    @Test
    public void emptyAreaHitTest() {
        result.setR(2.0);

        for (double i = 2; i > 0; i -= 0.1) {
            for (double j = -3; j < 0; j += 0.1) {
                result.setX(i);
                result.setY(j);
                assertFalse(result.getResult());

            }
        }
    }
}
