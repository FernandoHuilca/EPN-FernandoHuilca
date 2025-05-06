package agentes2025a.Modelo;

import java.io.Serializable;

public class Cliente implements Serializable{
    int idPersona, idCliente, totalProductos, totalPagos ;
    double precioPromedio, totalFacturasUltimoMes, cupo, pagoUltimoMes;

    


    public Cliente(int idPersona, int idCliente, int totalProductos, int totalPagos, double precioPromedio,
            double totalFacturasUltimoMes, double cupo, double pagoUltimoMes) {
        this.idPersona = idPersona;
        this.idCliente = idCliente;
        this.totalProductos = totalProductos;
        this.totalPagos = totalPagos;
        this.precioPromedio = precioPromedio;
        this.totalFacturasUltimoMes = totalFacturasUltimoMes;
        this.cupo = cupo;
        this.pagoUltimoMes = pagoUltimoMes;
    }
    public int getIdPersona() {
        return idPersona;
    }
    public double getPrecioPromedio() {
        return precioPromedio;
    }
    public double getTotalFacturasUltimoMes() {
        return totalFacturasUltimoMes;
    }
    public double getCupo() {
        return cupo;
    }
    public double getPagoUltimoMes() {
        return pagoUltimoMes;
    }
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    public void setPrecioPromedio(double precioPromedio) {
        this.precioPromedio = precioPromedio;
    }
    public void setTotalFacturasUltimoMes(double totalFacturasUltimoMes) {
        this.totalFacturasUltimoMes = totalFacturasUltimoMes;
    }
    public void setCupo(double cupo) {
        this.cupo = cupo;
    }
    public void setPagoUltimoMes(double pagoUltimoMes) {
        this.pagoUltimoMes = pagoUltimoMes;
    }


    @Override
    public String toString() {
       return "IdPersona; " + idPersona + "\n" + "Cupo " + cupo;
    }


}
