package ejnotasobjetos;

public class Libreta {
    private String nombreEstudiante;
    private double promedio;
    private String promedioCualitativo;
    // conjunto de arreglos del objetos -> materia
    private Materia [] m;

    public Libreta(String nombreEstudiante, Materia[] m) {
        this.nombreEstudiante = nombreEstudiante;
        this.m = m;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public double getPromedio() {
        return promedio;
    }

    public void calcularPromedio() {
        
        int j;
        double suma =0;
        
        for (j=0; j < m.length; j++){
        
            suma = suma + getM()[j].getNota();
        
        }
        
        promedio = suma / m.length;
        
        
    }

    public String getPromedioCualitativo() {
        return promedioCualitativo;
    }

    public void calcularPromedioCualitativo() {
      
        if (promedio >= 0 && promedio <3.1){
            
            promedioCualitativo = "Regular";
        
        } else if(promedio >= 3.1 && promedio <5.1){
        
            promedioCualitativo = "Insuficiente";
        
        } else if(promedio >= 5.1 && promedio <7.1){
        
            promedioCualitativo = "Bueno";
        
        }else if(promedio >= 7.1 && promedio <9.1){
        
            promedioCualitativo = "Muy Bueno";
        
        }else if (promedio >= 9.1 && promedio <=10){
        
            promedioCualitativo = "Excelente";
        }
        
        
        
    }

    public Materia[] getM() {
        return m;
    }

    public void setM(Materia[] m) {
        this.m = m;
    }
    
    

    
}
