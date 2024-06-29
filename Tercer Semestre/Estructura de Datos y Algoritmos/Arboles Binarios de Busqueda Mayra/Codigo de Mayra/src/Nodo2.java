import javax.swing.*;

public class Nodo2 {

    private Nodo2 IZQ;
    private Nodo2 DER;
    private int info;

    public Nodo2(int inf) {
        super();
        this.IZQ = null;
        this.DER = null;
        this.info = inf;
    }

    // constructores
    public Nodo2() {
        super();
    }

    public Nodo2 getIZQ() {
        return IZQ;
    }

    // funciones get y setter
    public void setIZQ(Nodo2 iZQ) {
        this.IZQ = iZQ;
    }

    public Nodo2 getDER() {
        return DER;
    }

    public void setDER(Nodo2 dER) {
        this.DER = dER;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }


    public void insertar(int valorInsertar) {
        if (valorInsertar < this.info) {
            if (this.IZQ == null) {
                this.IZQ = new Nodo2(valorInsertar);
            } else {
                this.IZQ.insertar(valorInsertar);
            }
        } else {
            if (valorInsertar > this.info) {
                if (this.DER == null) {
                    this.DER = new Nodo2(valorInsertar);
                } else {
                    this.DER.insertar(valorInsertar);
                }
            } else {
                if (valorInsertar == this.info) {
                    JOptionPane.showMessageDialog(null, "El dato ya existe");
                }
            }
        }
    }
}
