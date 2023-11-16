package Zapato;

public class Zapato {
    private String color;
    private String marca;
    private String material;
    private boolean atado;
    private int talla;
    private boolean estadoDeUso;
    //NO SE SI ESTE BIEN ESTO QUE SIGUE:
    private int tallaPieDePersona;

    public Zapato(String color, String marca, String material, int talla, int tallaPieDePersona) {
        this.color = color;
        this.marca = marca;
        this.material = material;
        this.talla = talla;
        this.estadoDeUso = false; //Asumimos que nadie lo ocupa al principio
        atado = false; // Digamos que siempre estan desatados los cordones
        this.tallaPieDePersona = tallaPieDePersona;
    }


    public void ponerZapato() {
        if (estaAtado() && (tallaPieDePersona <= talla)) {
            estadoDeUso = true;
        }
        else
            System.out.println("ERROR: Pie grande xd");
    }

    public void sacarZapato() {
        if (estaAtado()) {
            estadoDeUso = false;
        }
    }

    public void atarCordones() {
        atado = true;
    }


    public void desatarCordones() {
        atado = false;
    }

    public void imprimirSiLoEstanOcupando() {
        if (estadoDeUso) {
            System.out.println("Estan ocupando los zapatos");
        } else {
            System.out.println("No estan en uso los zapatos");
        }
    }
    private boolean estaAtado() {
        return atado;
    }

}

