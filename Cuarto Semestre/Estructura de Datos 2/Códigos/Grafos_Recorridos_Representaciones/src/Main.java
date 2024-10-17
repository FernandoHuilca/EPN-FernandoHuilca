
// Author: Fernando Huilca
public class Main {
    public static void main(String[] args) {

        System.out.println("CASO 1 Agregar un grafo a la App ________________________________");
        App app = new App();
        Nodo nodo2 = new Nodo("B");
        Nodo nodo1 = new Nodo("A");
        Nodo nodo3 = new Nodo("C");
        //Hacemos un Grafo y definimos de qué tipo es, dado que hemos estudiado algunos
        GrafoDirigido grafoDirigido1 = new GrafoDirigido();
        grafoDirigido1.agregarNodo(nodo1);
        grafoDirigido1.agregarNodo(nodo2);
        grafoDirigido1.dirigirAristaANodo(0,1);
        grafoDirigido1.agregarNodo(nodo3);
        grafoDirigido1.dirigirAristaANodo(2,0);

        app.agregarGrafoDirigido(grafoDirigido1);

        app.imprimirGrafoDirigido(0);


    }
}