package ejnotas;

public class Libreta {
    private String nombreEstudiante;
    private double [] notas;
    private double promedio;
    private String promedioCualitativo;

    public Libreta(String nombreEstudiante, double[] notas) {
        this.nombreEstudiante = nombreEstudiante;
        this.notas = notas;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public String getPromedioCualitativo() {
        return promedioCualitativo;
    }

    public void setPromedioCualitativo(String promedioCualitativo) {
        if (promedio >= 0 && promedio < 3.09) {
            promedioCualitativo = "Regular";  
        } else if (promedio >= 3.1 && promedio < 5.09) {
            promedioCualitativo = "Insuficiente"; 
        } else if (promedio >= 5.1 && promedio < 7.09) {
            promedioCualitativo = "Bueno"; 
        } else if (promedio >= 7.1 && promedio < 9.09) {
            promedioCualitativo = "Muy bueno"; 
        } else if (promedio >= 9.1 && promedio < 10) {
            promedioCualitativo = "Sobresaliente"; 
        }
    }
}
