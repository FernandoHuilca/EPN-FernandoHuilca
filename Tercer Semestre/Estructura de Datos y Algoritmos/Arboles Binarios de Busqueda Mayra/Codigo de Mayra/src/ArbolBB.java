import javax.swing.*;

public class ArbolBB {

    private Nodo2 raiz;


    public ArbolBB() {
        super();
        this.raiz = null;
    }


    public Nodo2 getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo2 raiz) {
        this.raiz = raiz;
    }



    public void insertarNodo(int valorInsertar) {
        if (this.raiz == null) {
            this.raiz = new Nodo2(valorInsertar);
        } else {
            this.raiz.insertar(valorInsertar);
        }
    }





    public void buscarABB(int clave) {
        Nodo2 aux2 = new Nodo2();
        aux2 = ayudanteBuscar(this.raiz, clave);
        System.out.println(aux2.getInfo());

    }

    Nodo2 aux = new Nodo2();






    public Nodo2 ayudanteBuscar(Nodo2 nod, int clave) {
        if (nod.getInfo() == clave) {
            JOptionPane.showMessageDialog(null, "Clave encontrada, sus datos son: " + nod.getInfo());
            this.aux = nod;
        } else {
            if (clave < nod.getInfo()) {
                if (nod.getIZQ() != null) {
                    ayudanteBuscar(nod.getIZQ(), clave);
                } else {
                    JOptionPane.showMessageDialog(null, "La clave no fue encontrada");
                }
            } else {
                if (clave > nod.getInfo()) {
                    if (nod.getDER() != null) {
                        ayudanteBuscar(nod.getDER(), clave);
                    } else {
                        JOptionPane.showMessageDialog(null, "La clave no fue encontrada");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La clave no ha sido encontrada");
                }
            }
        }
        return this.aux;
    }






    public void borrarABB(int clave) {
        Nodo2 nodBorrar = ayudanteBuscar(this.raiz, clave);
        if (nodBorrar != null) {
            if (nodBorrar.getIZQ() == null && nodBorrar.getDER() == null) {
                this.aux = null;
                Nodo2 padre = buscarPadre(this.raiz, nodBorrar);
                if (padre.getIZQ() != null) {
                    if (padre.getIZQ().getInfo() == nodBorrar.getInfo()) {
                        padre.setIZQ(null);
                    }
                }
                if (padre.getDER() != null) {
                    if (padre.getDER().getInfo() == nodBorrar.getInfo()) {
                        padre.setDER(null);
                    }
                }

                System.out.println("\n  Se ha borrado la clave: " + clave);
            }
            if (nodBorrar.getIZQ() == null && nodBorrar.getDER() != null) {
                this.aux = null;
                Nodo2 padre = buscarPadre(this.raiz, nodBorrar);
                if (padre.getIZQ() != null) {
                    if (padre.getIZQ().getInfo() == nodBorrar.getInfo()) {
                        padre.setIZQ(nodBorrar.getDER());
                    }
                }
                if (padre.getDER() != null) {
                    if (padre.getDER().getInfo() == nodBorrar.getInfo()) {
                        padre.setDER(nodBorrar.getDER());
                    }
                }

                System.out.println("\n  Se ha borrado la clave: " + clave);
            }
            if (nodBorrar.getIZQ() != null && nodBorrar.getDER() == null) {
                this.aux = null;
                Nodo2 padre = buscarPadre(this.raiz, nodBorrar);
                if (padre.getIZQ().getInfo() == nodBorrar.getInfo()) {
                    padre.setIZQ(nodBorrar.getIZQ());
                }

                if (padre.getDER().getInfo() == nodBorrar.getInfo()) {
                    padre.setDER(nodBorrar.getIZQ());
                }

                System.out.println("\n  Se ha borrado la clave: " + clave);
            }
            if (nodBorrar.getIZQ() != null && nodBorrar.getDER() != null) {
                this.aux = null;
                Nodo2 sucesor = buscarSucesor(nodBorrar.getDER());
                this.aux = null;
                borrarABB(sucesor.getInfo());
                borrarNodoCaso3(this.raiz, nodBorrar, sucesor.getInfo());
                System.out.println("\n Se ha borrado la clave: " + clave);
            }
        }
    }





    private void borrarNodoCaso3(Nodo2 raiz, Nodo2 nodBorrar, int sucesor) {
        if (raiz.getInfo() == nodBorrar.getInfo()) {
            raiz.setInfo(sucesor);
        } else {
            if (nodBorrar.getInfo() < raiz.getInfo()) {
                borrarNodoCaso3(raiz.getIZQ(), nodBorrar, sucesor);
            }
            if (nodBorrar.getInfo() > raiz.getInfo()) {
                borrarNodoCaso3(raiz.getDER(), nodBorrar, sucesor);
            }
        }

    }





    public void borrarNodo(Nodo2 raiz, Nodo2 padre) {
        if (padre.getInfo() == this.raiz.getInfo()) {
            Nodo2 sucesor = buscarSucesor(padre.getDER());
            this.raiz = sucesor;
        } else {
            if (padre.getInfo() == raiz.getInfo()) {
                raiz = padre;
            } else {
                if (padre.getInfo() < raiz.getInfo()) {
                    borrarNodo(raiz.getIZQ(), padre);
                }
                if (padre.getInfo() > raiz.getInfo()) {
                    borrarNodo(raiz.getDER(), padre);
                }
            }

        }
    }




    private Nodo2 buscarSucesor(Nodo2 sucesor) {
        if (sucesor.getIZQ() != null) {
            buscarSucesor(sucesor.getIZQ());
        } else {
            this.aux = sucesor;
        }
        return this.aux;
    }





    public Nodo2 buscarPadre(Nodo2 raiz, Nodo2 clave) {
        if (this.raiz.getInfo() == clave.getInfo()) {
            this.aux = this.raiz;
        } else {
            if (clave.getInfo() < raiz.getInfo()) {
                if (raiz.getIZQ().getInfo() == clave.getInfo()) {
                    this.aux = raiz;
                } else {
                    buscarPadre(raiz.getIZQ(), clave);
                }
            } else {
                if (raiz.getDER().getInfo() == clave.getInfo()) {
                    this.aux = raiz;
                } else {
                    buscarPadre(raiz.getDER(), clave);
                }
            }
        }
        return this.aux;
    }





    public void recorridoInorden() {
        ayudanteInorden(this.raiz);
    }




    private void ayudanteInorden(Nodo2 nod) {
        if (nod == null) {
            return;
        }
        ayudanteInorden(nod.getIZQ());
        System.out.println("\t" + nod.getInfo());
        ayudanteInorden(nod.getDER());
    }

    private String BuscarABB(int clave) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
        // Tools | Templates.
    }
}

