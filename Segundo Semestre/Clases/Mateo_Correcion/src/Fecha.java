public class Fecha {
    private int año;
    private Mes mes;
    private int dia;

    public Fecha(int diaTurno, Mes mesTurno, int añoTurno) {
        this.dia = diaTurno;
        this.mes = mesTurno;
        this.año = añoTurno;
    }

    @Override
    public String toString() {
        return dia + ", " + mes + ", " + año;
    }

    public boolean esLaMismaFecha(Fecha fechaComparar) {
        if(!(año == fechaComparar.año)){
            return false;
        }
        if(!(mes == fechaComparar.mes)){
            return false;
        }
        if(!(dia == fechaComparar.dia)){
            return false;
        }
        return true;
    }

    public boolean esPosteriorALaFechaConstante(Fecha nuevaFechaAComparar) {
        if(año < nuevaFechaAComparar.año){
            return true;
        }
        if(mes.getNumeroDeMes() < nuevaFechaAComparar.mes.getNumeroDeMes()){
            return true;
        }
        if (dia < nuevaFechaAComparar.dia){
            return true;
        }
        return false;
    }
}