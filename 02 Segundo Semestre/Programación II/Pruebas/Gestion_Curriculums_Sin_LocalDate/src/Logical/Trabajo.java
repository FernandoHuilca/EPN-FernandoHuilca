package Logical;

import java.time.LocalDate;
import java.time.Period;

public class Trabajo {
    private final LocalDate fechaDeIngreso;
    private final LocalDate fechaDeFinalización;
    private final String nombreEmpresa;

    public Trabajo(LocalDate fechaDeIngreso, LocalDate fechaDeFinalización, String nombreEmpresa)throws FechaInicialYFinalIncorrectas {
        if (!fechaDeIngreso.isBefore(fechaDeFinalización)){
            throw new FechaInicialYFinalIncorrectas();
        }
        this.fechaDeIngreso = fechaDeIngreso;
        this.fechaDeFinalización = fechaDeFinalización;
        this.nombreEmpresa = nombreEmpresa;
    }
    public Trabajo(String fechaDeIngreso, LocalDate fechaDeFinalización, String nombreEmpresa)throws FechaInicialYFinalIncorrectas {
        this.fechaDeIngreso = LocalDate.parse(fechaDeIngreso);
        if (!this.fechaDeIngreso.isBefore(fechaDeFinalización)){
            throw new FechaInicialYFinalIncorrectas();
        }

        this.fechaDeFinalización = fechaDeFinalización;
        this.nombreEmpresa = nombreEmpresa;
    }

    @Override
    public String toString()  {
        return "\nFechaDeIngreso: " + fechaDeIngreso +
                "\nFechaDeFinalización: " + fechaDeFinalización +
                "\nNombreEmpresa: " + nombreEmpresa + "\n\n";
    }

    public double getExperiencia() {
        Period period = Period.between(fechaDeIngreso, fechaDeFinalización);
        return  (period.getYears() * 365) + (period.getMonths() * 30) + period.getDays();
    }
}

