
package ejecutarpersonasimc;

public class PersonasIMC {
    
     private String cedula;
     private String nombre;
     private double estatura;
     private double peso;
     private int edad;
     private double IMC;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getIMC() {
        return IMC;
    }

    public void CalcularIMC(){
        
        IMC = peso / (estatura * estatura);
    }
     
}
