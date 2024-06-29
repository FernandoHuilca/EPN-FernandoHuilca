import javax.swing.*;

public class ÁrbolBinarioDeBúsqueda {
    private Nodo raíz; // Nodo raíz del árbol
    private Nodo aux; // Nodo auxiliar usado en diferentes métodos

    // Método para crear el árbol
    public void crearÁrbol() {
        // Solicitar al usuario que ingrese la información de la raíz del árbol
        int infoDeLaRaíz = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la raíz del árbol: "));
        raíz = new Nodo(infoDeLaRaíz); // Crear el nodo raíz

        // Preguntar al usuario si desea agregar más nodos
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea ingresar más nodos?");
        while (opcion == JOptionPane.YES_OPTION) {
            // Solicitar al usuario que ingrese la información del nuevo nodo
            int infoNuevoNodo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la info del nuevo nodo "));
            // Agregar el nuevo nodo al árbol binario de búsqueda
            agregarNodosAlÁrbolBB(raíz, new Nodo(infoNuevoNodo));
            // Preguntar nuevamente si desea ingresar más nodos
            opcion = JOptionPane.showConfirmDialog(null, "¿Desea ingresar más nodos?");
        }
    }

    // Método para agregar nodos al árbol binario de búsqueda
    public void agregarNodosAlÁrbolBB(Nodo nodoInicial, Nodo nodoAAgregar) {
        // Comparar el valor del nodo a agregar con el nodo inicial
        if (nodoAAgregar.getInfo() < nodoInicial.getInfo()) {
            // Si el valor es menor y el nodo izquierdo está vacío, agregar el nodo allí
            if (nodoInicial.getNodoIzquierdo() == null) {
                nodoInicial.setNodoIzquierdo(nodoAAgregar);
            } else {
                // Si el nodo izquierdo no está vacío, llamar recursivamente
                agregarNodosAlÁrbolBB(nodoInicial.getNodoIzquierdo(), nodoAAgregar);
            }
        } else if (nodoAAgregar.getInfo() > nodoInicial.getInfo()) {
            // Si el valor es mayor y el nodo derecho está vacío, agregar el nodo allí
            if (nodoInicial.getNodoDerecho() == null) {
                nodoInicial.setNodoDerecho(nodoAAgregar);
            } else {
                // Si el nodo derecho no está vacío, llamar recursivamente
                agregarNodosAlÁrbolBB(nodoInicial.getNodoDerecho(), nodoAAgregar);
            }
        } else {
            // Si el valor ya existe, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null,
                    "Elemento ya existente: " +
                            "\n\nEn un Árbol Binario de Búsqueda (BST), cada nodo " +
                            "\ndebe tener un valor único. Esto significa que no se permiten " +
                            "\nvalores duplicados en el árbol ");
        }
    }

    // Método para buscar un nodo dentro del árbol
    public void buscarNodoDentroDelÁrbol(Nodo nodoInicial, int infoABuscar) {
        // Si el nodo inicial es null, el elemento no se encuentra en el árbol
        if (nodoInicial == null) {
            JOptionPane.showMessageDialog(null, "El elemento no se encuentra dentro del árbol");
        } else if (infoABuscar == nodoInicial.getInfo()) {
            // Si se encuentra el nodo, mostrar un mensaje de éxito
            JOptionPane.showMessageDialog(null, "El elemento " + infoABuscar + " fue encontrado con éxito." + nodoInicial);
        } else if (infoABuscar < nodoInicial.getInfo()) {
            // Si el valor a buscar es menor, buscar en el subárbol izquierdo
            buscarNodoDentroDelÁrbol(nodoInicial.getNodoIzquierdo(), infoABuscar);
        } else {
            // Si el valor a buscar es mayor, buscar en el subárbol derecho
            buscarNodoDentroDelÁrbol(nodoInicial.getNodoDerecho(), infoABuscar);
        }
    }

    // Método auxiliar para buscar un nodo en el árbol
    public Nodo ayudanteBuscar(Nodo nod, int clave) {
        if (nod.getInfo() == clave) {
            // Si se encuentra la clave, mostrar un mensaje y asignar el nodo a aux
            JOptionPane.showMessageDialog(null, "Clave encontrada, sus datos son: " + nod.getInfo());
            this.aux = nod;
        } else {
            // Si la clave es menor, buscar en el subárbol izquierdo
            if (clave < nod.getInfo()) {
                if (nod.getNodoIzquierdo() != null) {
                    ayudanteBuscar(nod.getNodoIzquierdo(), clave);
                } else {
                    JOptionPane.showMessageDialog(null, "La clave no fue encontrada");
                }
            } else {
                // Si la clave es mayor, buscar en el subárbol derecho
                if (clave > nod.getInfo()) {
                    if (nod.getNodoDerecho() != null) {
                        ayudanteBuscar(nod.getNodoDerecho(), clave);
                    } else {
                        JOptionPane.showMessageDialog(null, "La clave no fue encontrada");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La clave no ha sido encontrada");
                }
            }
        }
        return this.aux; // Devolver el nodo encontrado
    }

    // Método para borrar un nodo del árbol
    public void borrarABB(int clave) {
        // Buscar el nodo a borrar
        Nodo nodBorrar = ayudanteBuscar(this.raíz, clave);
        if (nodBorrar != null) {
            // Caso 1: El nodo a borrar es una hoja
            if (nodBorrar.getNodoIzquierdo() == null && nodBorrar.getNodoDerecho() == null) {
                this.aux = null;
                Nodo padre = buscarPadre(this.raíz, nodBorrar);
                if (padre.getNodoIzquierdo() != null) {
                    if (padre.getNodoIzquierdo().getInfo() == nodBorrar.getInfo()) {
                        padre.setNodoIzquierdo(null);
                    }
                }
                if (padre.getNodoDerecho() != null) {
                    if (padre.getNodoDerecho().getInfo() == nodBorrar.getInfo()) {
                        padre.setNodoDerecho(null);
                    }
                }

                System.out.println("\n  Se ha borrado la clave: " + clave);
            }
            // Caso 2: El nodo a borrar tiene solo un hijo derecho
            if (nodBorrar.getNodoIzquierdo() == null && nodBorrar.getNodoDerecho() != null) {
                this.aux = null;
                Nodo padre = buscarPadre(this.raíz, nodBorrar);
                if (padre.getNodoIzquierdo() != null) {
                    if (padre.getNodoIzquierdo().getInfo() == nodBorrar.getInfo()) {
                        padre.setNodoIzquierdo(nodBorrar.getNodoDerecho());
                    }
                }
                if (padre.getNodoDerecho() != null) {
                    if (padre.getNodoDerecho().getInfo() == nodBorrar.getInfo()) {
                        padre.setNodoDerecho(nodBorrar.getNodoDerecho());
                    }
                }

                System.out.println("\n  Se ha borrado la clave: " + clave);
            }
            // Caso 3: El nodo a borrar tiene solo un hijo izquierdo
            if (nodBorrar.getNodoIzquierdo() != null && nodBorrar.getNodoDerecho() == null) {
                this.aux = null;
                Nodo padre = buscarPadre(this.raíz, nodBorrar);
                if (padre.getNodoIzquierdo().getInfo() == nodBorrar.getInfo()) {
                    padre.setNodoIzquierdo(nodBorrar.getNodoIzquierdo());
                }

                if (padre.getNodoDerecho().getInfo() == nodBorrar.getInfo()) {
                    padre.setNodoDerecho(nodBorrar.getNodoIzquierdo());
                }

                System.out.println("\n  Se ha borrado la clave: " + clave);
            }
            // Caso 4: El nodo a borrar tiene dos hijos
            if (nodBorrar.getNodoIzquierdo() != null && nodBorrar.getNodoDerecho() != null) {
                this.aux = null;
                Nodo sucesor = buscarSucesor(nodBorrar.getNodoDerecho());
                this.aux = null;
                borrarABB(sucesor.getInfo());
                borrarNodoCaso3(this.raíz, nodBorrar, sucesor.getInfo());
                System.out.println("\n Se ha borrado la clave: " + clave);
            }
        }
    }

    // Método auxiliar para borrar un nodo con dos hijos
    private void borrarNodoCaso3(Nodo raiz, Nodo nodBorrar, int sucesor) {
        if (raiz.getInfo() == nodBorrar.getInfo()) {
            raiz.setInfo(sucesor);
        } else {
            if (nodBorrar.getInfo() < raiz.getInfo()) {
                borrarNodoCaso3(raiz.getNodoIzquierdo(), nodBorrar, sucesor);
            }
            if (nodBorrar.getInfo() > raiz.getInfo()) {
                borrarNodoCaso3(raiz.getNodoDerecho(), nodBorrar, sucesor);
            }
        }
    }

    // Método para buscar el sucesor de un nodo
    private Nodo buscarSucesor(Nodo sucesor) {
        if (sucesor.getNodoIzquierdo() != null) {
            buscarSucesor(sucesor.getNodoIzquierdo());
        } else {
            this.aux = sucesor;
        }
        return this.aux;
    }

    // Método para buscar el padre de un nodo
    public Nodo buscarPadre(Nodo raíz, Nodo clave) {
        if (this.raíz.getInfo() == clave.getInfo()) {
            this.aux = this.raíz;
        } else {
            if (clave.getInfo() < raíz.getInfo()) {
                if (raíz.getNodoIzquierdo().getInfo() == clave.getInfo()) {
                    this.aux = raíz;
                } else {
                    buscarPadre(raíz.getNodoIzquierdo(), clave);
                }
            } else {
                if (raíz.getNodoDerecho().getInfo() == clave.getInfo()) {
                    this.aux = raíz;
                } else {
                    buscarPadre(raíz.getNodoDerecho(), clave);
                }
            }
        }
        return this.aux;
    }

    @Override
    public String toString() {
        StringBuilder arbol = new StringBuilder();
        imprimirÁrbolAux(raíz, 0, arbol);
        return arbol.toString();
    }

    // Método auxiliar para imprimir el árbol en forma de texto
    private void imprimirÁrbolAux(Nodo nodo, int nivel, StringBuilder arbol) {
        if (nodo != null) {
            imprimirÁrbolAux(nodo.getNodoDerecho(), nivel + 1, arbol);
            for (int i = 0; i < nivel; i++) {
                arbol.append("                 ");
            }
            arbol.append(nodo.getInfo()).append("\n");
            imprimirÁrbolAux(nodo.getNodoIzquierdo(), nivel + 1, arbol);
        }
    }

    // Método para obtener la raíz del árbol
    public Nodo getRaíz() {
        return raíz;
    }
}
