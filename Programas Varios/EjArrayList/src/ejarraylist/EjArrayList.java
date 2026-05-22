
package ejarraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class EjArrayList {

    public static void main(String[] args) {
        
        ArrayList<bus> buses = new ArrayList <>();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Cuantos buses desea registrar? ");
        int cantidad = sc.nextInt();
        sc.nextLine(); 
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Bus #" + (i + 1) + " ---");     
            System.out.print("Id: ");
            String id = sc.nextLine();
            System.out.print("Placa: ");
            String placa = sc.nextLine();           
            System.out.print("Color: ");
            String color = sc.nextLine();           
            System.out.print("Capacidad: ");
            int capacidad = sc.nextInt();
            sc.nextLine();           
            buses.add(new bus(id, placa, color, capacidad));
        }
        
        System.out.println("\nBUSES");
        for (int i = 0; i < buses.size(); i++) {
            bus b = buses.get(i);
            System.out.println("\nBus #" + (i + 1));
            System.out.println("Id: " + b.getId());
            System.out.println("Placa: " + b.getPalca());
            System.out.println("Color: " + b.getColor());
            System.out.println("Capacidad: " + b.getCapacidad());
        }  
        sc.close();
    }
}
