package Testers;

import Logical.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrdenesPizzasTest {

    //Dado:
    //Cuando:
    //Entonces:
    //-------------------------------------------------
    Empresa empresa = new Empresa();
    //-------------------------------------------------

    @Test
    public void calcularValorAPagarSinDescuentosTest() {
        //DADO: (que existe una empresa con órdenes)
        inicializarTodo();
        //CUANDO: (quiero calcular el valor a pagar de una órden)
        double aux = 0.0;
        aux = empresa.valorAPagar(2); //el número indica la orden de la lista de órdenes :)
        //ENTONCES:
        assertTrue(aux == 12.0);

    }

    @Test
    public void calcularValorAPagarMitadDePrecioSegundaPizzaTest() {
        //DADO: (que existe una empresa con órdenes)
        inicializarTodo();
        //CUANDO: (quiero calcular el valor a pagar de una órden)
        double aux = 0.0;
        aux = empresa.valorAPagar(1); //el número indica la orden de la lista de órdenes :)
        //ENTONCES:
        assertTrue(aux == 16.5);

    }

    @Test
    public void calcularValorAPagarPorCuatroPizzas() {
        //DADO: (que existe una empresa con órdenes)
        inicializarTodo();
        //CUANDO: (quiero calcular el valor a pagar de una órden)
        double aux = 0.0;
        aux = empresa.valorAPagar(0); //el número indica la orden de la lista de órdenes :)
        //ENTONCES:
        assertTrue(aux == 28.0);

    }





    public void inicializarTodo() {
        //------------------------ Ingredientes ---------------------
        Ingrediente ingrediente1 = new Ingrediente("Queso");
        Ingrediente ingrediente2 = new Ingrediente("Peperoni");
        Ingrediente ingrediente3 = new Ingrediente("Mostaza");
        Ingrediente ingrediente4 = new Ingrediente("Ají");
        Ingrediente ingrediente5 = new Ingrediente("SalsaChampiñones");

        ArrayList<Ingrediente> ingredientes1;
        ingredientes1 = new ArrayList<>();
        ingredientes1.add(ingrediente1);
        ingredientes1.add(ingrediente2);
        ingredientes1.add(ingrediente3);

        ArrayList<Ingrediente> ingredientes2;
        ingredientes2 = new ArrayList<>();
        ingredientes2.add(ingrediente4);
        ingredientes2.add(ingrediente5);

        ArrayList<Ingrediente> ingredientes3;
        ingredientes3 = new ArrayList<>();
        ingredientes3.add(ingrediente1);
        ingredientes3.add(ingrediente5);
        ingredientes3.add(ingrediente2);


        //------------------------ Pizzas ---------------------
        Pizza pizza1 = new Pizza(TipoPiza.GRANDE, ingredientes1);  // Sin descuento se paga 4 * 3 = 12
        Pizza pizza2 = new Pizza(TipoPiza.PEQUENIA, ingredientes2); // Sin descuento se paga 2 * 2 = 4


        Pizza pizza3 = new Pizza(TipoPiza.MEDIANA, ingredientes3); // Sin descuento se paga 3 * 3 = 9


        ArrayList<Pizza> pizzas1;   //PIZZAS1 tiene pizza 1 y 2, entonces la pizza 1 es Grande(uff) y tiene 3 ingredientes o sea sin descuento hay que pagar 12$
                                                                // y la pizza 2 es pequeña y tiene 2 ingredientes entonces se paga sin descuento 4$. Total 16$
        pizzas1 = new ArrayList<>();
        pizzas1.add(pizza1); // 12
        pizzas1.add(pizza2); //4
        pizzas1.add(pizza1); // 12
        pizzas1.add(pizza2); //4   total 32



        ArrayList<Pizza> pizzas2;
        pizzas2 = new ArrayList<>();
        pizzas2.add(pizza1);
        pizzas2.add(pizza3);

        ArrayList<Pizza> pizzas3;
        pizzas3 = new ArrayList<>();
        pizzas3.add(pizza1);



        //----------- Agregar Orden de pizzas a la empresa -------------
        empresa.agregarOrden(new Orden(pizzas1));  // total 32
        empresa.agregarOrden(new Orden(pizzas2)); //Solo agregué dos pizzas y hay que pagar 12 + 9 = 21$ pero segunda pizza mitad precio 12 + 4.5 = 16.5
        empresa.agregarOrden(new Orden(pizzas3)); //hay que pagar 12




    }















  /*  @Test
    public void curriculumsOrdenadosPorCanCompetencias() {
        //Dado: (que existe)
        inicializarCVs();

        //Cuando:
        empresa.ordenarPorCompetencias();
        //empresa.imprimirCVs();

        // Entonces: Verificar que la lista esté ordenada por cantidad de competencias
        ArrayList<CV> listaOrdenada = empresa.getCVs();
        for (int i = 1; i < listaOrdenada.size(); i++) {
            int competenciasAnterior = listaOrdenada.get(i - 1).getCompetencias().size();
            int competenciasActual = listaOrdenada.get(i).getCompetencias().size();
            // La cantidad de competencias debe ser igual o mayor para los elementos subsiguientes
            assertTrue(competenciasActual >= competenciasAnterior);
            assertEquals();
        }

    } */


}
