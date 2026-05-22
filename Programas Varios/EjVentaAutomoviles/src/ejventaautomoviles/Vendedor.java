
package ejventaautomoviles;

public class Vendedor {
    
    private String nombre;
    private int edad;
    private double salarioMinimo;
    private int numAutos;
    private double pagoMensual;

    public Vendedor() {
        
    }

    public Vendedor(String nombre, int edad, double salarioMinimo, int numAutos) {
        this.nombre = nombre;
        this.edad = edad;
        this.salarioMinimo = salarioMinimo;
        this.numAutos = numAutos;
        calcularPago();
    }

    public void calcularPago() {
        pagoMensual = salarioMinimo + (numAutos * 150);
    }

    public void mostrarDatos() {
        System.out.println("=================================");
        System.out.println("Datos del vendedor:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Salario mínimo: " + salarioMinimo);
        System.out.println("Número de autos: " + numAutos);
        System.out.println("Pago mensual: " + pagoMensual);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalarioMinimo() {
        return salarioMinimo;
    }

    public void setSalarioMinimo(double salarioMinimo) {
        this.salarioMinimo = salarioMinimo;
    }

    public int getNumAutos() {
        return numAutos;
    }

    public void setNumAutos(int numAutos) {
        this.numAutos = numAutos;
    }

    public double getPagoMensual() {
        return pagoMensual;
    }

    public void setPagoMensual(double pagoMensual) {
        this.pagoMensual = pagoMensual;
    }
}
