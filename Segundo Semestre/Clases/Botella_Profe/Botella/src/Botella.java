public class Botella extends Recipiente {

    private boolean tapado;

    public Botella(String color, double capacidadMáximaLitros, String material, double pesoOnzas) {
        super(color, capacidadMáximaLitros, material, pesoOnzas);
        tapado = true;
    }

    public void llenar(Botella otraBotella) throws RecipienteTapado {
        if(otraBotella.estaTapado() || estaTapado()){
            return;
        }
        super.llenar(otraBotella);
    }

    @Override
    public void llenar(double cantidadALlenar) throws RecipienteTapado {
        if(estaTapado()) {
            throw new RecipienteTapado();
        }
        super.llenar(cantidadALlenar);
    }

    @Override
    public void vaciar(double cantidadAVaciar) {
        if(estaTapado()) {
            return;
        }
        super.vaciar(cantidadAVaciar);
    }



    private boolean estaTapado() {
        return tapado;
    }

    public void tapar() {
        tapado = true;
    }

    public void destapar() {
        tapado = false;
    }


}
