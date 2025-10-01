package Test;

import Propuesta.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrimerEjercicioTest {

    private MaquinaDeChicles maquina;

    @BeforeEach
    void setUp() {
        // Dado: una máquina de chicles con 5 unidades
        maquina = new MaquinaDeChicles(5);
    }

    @Test
    void dadoMaquinaSinCuarto_cuandoInsertoCuarto_entoncesPasaATieneCuarto() {
        // Cuando: inserto una moneda
        maquina.insertarCuarto();

        // Entonces: el estado debería ser EstadoTieneCuarto
        assertInstanceOf(EstadoTieneCuarto.class, getEstadoActual(maquina));
    }

    @Test
    void dadoEstadoTieneCuarto_cuandoExpulsoCuarto_entoncesPasaANoCuarto() {
        maquina.insertarCuarto(); // estado tiene cuarto

        // Cuando: expulso la moneda
        maquina.expulsarCuarto();

        // Entonces: el estado debería ser EstadoNoCuarto
        assertInstanceOf(EstadoNoCuarto.class, getEstadoActual(maquina));
    }

    @Test
    void dadoMaquinaSinChicles_cuandoInsertoCuarto_entoncesPermaneceEnEstadoAgotado() {
        maquina = new MaquinaDeChicles(0); // vacía

        // Cuando: intento insertar moneda
        maquina.insertarCuarto();

        // Entonces: sigue en EstadoAgotado
        assertInstanceOf(EstadoAgotado.class, getEstadoActual(maquina));
    }

    // Función auxiliar para obtener el estado actual usando reflexión (ya que es privado)
    private Object getEstadoActual(MaquinaDeChicles maquina) {
        try {
            var field = MaquinaDeChicles.class.getDeclaredField("estadoActual");
            field.setAccessible(true);
            return field.get(maquina);
        } catch (Exception e) {
            fail("No se pudo acceder al estadoActual: " + e.getMessage());
            return null;
        }
    }
}
