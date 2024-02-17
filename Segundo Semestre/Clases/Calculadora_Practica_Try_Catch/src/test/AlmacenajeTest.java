package test;

import Calculadora.*;
import junit.framework.TestCase;
import org.junit.Test;

public class AlmacenajeTest extends TestCase {
    @Test
    private void divisionParaCero() {
        //DADO:
        Calculadora policalculadora = new Calculadora();
        int ok = 0;
        //CUANDO:
        try {
            ok = policalculadora.dividir(3, 3);
        } catch (DividirPorCero e) {
            System.out.println();
        }
        //ENTONCES
        assertEquals(1, ok);

    }
}
