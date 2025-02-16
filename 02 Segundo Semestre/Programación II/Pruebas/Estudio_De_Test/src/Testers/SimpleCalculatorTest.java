package Testers;

import Program.SimpleCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.TestCase;

public class SimpleCalculatorTest {
    @Test
    public void sumaDosMasDosResultadoCuatro(){
        //Dado:
        SimpleCalculator calculator = new SimpleCalculator();
        //Cuando:
        boolean resultado;
        if (calculator.sumarDosNúmeros(2,2) == 4){
            resultado = true;
        }
        else resultado= false;
        //Entonces:
        assertTrue(resultado);
    }

    @Test
    public void sumaDosMasDosResultadoCinco(){
        //Dado:
        SimpleCalculator calculator = new SimpleCalculator();
        //Cuando:
        double resultado = calculator.sumarDosNúmeros(2,3);
        //Entonces:
        assertEquals(5.0,resultado,0);
    }

}
