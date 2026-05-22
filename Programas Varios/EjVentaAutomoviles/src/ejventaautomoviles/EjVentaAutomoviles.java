
package ejventaautomoviles;

import java.util.Scanner;

public class EjVentaAutomoviles {

    public static void main(String[] args) {
        
        Scanner e = new Scanner(System.in);
        String nombre;
        int edad, numAutos;
        double salarioMinimo;
        int opcion;

        do {
            System.out.println("=================================");
            System.out.print("Ingrese nombre: ");
            e.nextLine(); 
            nombre = e.nextLine();

            System.out.print("Ingrese edad: ");
            edad = e.nextInt();

            System.out.print("Ingrese salario minimo: ");
            salarioMinimo = e.nextDouble();

            System.out.print("Ingrese numero de autos vendidos: ");
            numAutos = e.nextInt();

            Vendedor v = new Vendedor(nombre, edad, salarioMinimo, numAutos);
            v.mostrarDatos();

            System.out.println("=================================");
            System.out.println("¿Desea ingresar otro vendedor?");
            System.out.println("1. Si");
            System.out.println("2. No");
            opcion = e.nextInt();

        } while (opcion == 1);

        System.out.println("Proceso finalizado.");
    }
}
