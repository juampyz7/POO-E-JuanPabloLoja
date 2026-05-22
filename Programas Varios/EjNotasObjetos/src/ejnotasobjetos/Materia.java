package ejnotasobjetos;

public class Materia {
    
    private String nombreMateria;
    private double nota;

    public Materia(String nombreMateria, double nota) {
        this.nombreMateria = nombreMateria;
        this.nota = nota;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    

    
}
