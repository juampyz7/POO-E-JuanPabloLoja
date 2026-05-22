package ejecutarpersonasimc;

import java.util.Scanner;

public class EjecutarPersonasIMC {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String ced, nom;
        double peso, estatura;
        int ed;
        
        PersonasIMC perUno = new PersonasIMC();
        PersonasIMC perDos = new PersonasIMC();
        
        System.out.print("Ingrese cedula: ");
        ced = sc.nextLine();
        
        System.out.print("Ingrese nombre: ");
        nom = sc.nextLine();
        
        System.out.print("Ingrese peso en kg: ");
        peso = sc.nextDouble();
        
        System.out.print("Ingrese estatura en cm: ");
        estatura = sc.nextDouble();
        
        System.out.print("Ingrese edad: ");
        ed = sc.nextInt();
        
        perUno.setCedula(ced);
        perUno.setNombre(nom);
        perUno.setPeso(peso);
        perUno.setEstatura(estatura);
        perUno.setEdad(ed);
        
        perUno.CalcularIMC();

        System.out.println("Los datos del paciente " + perUno.getNombre() + " son, " + perUno.getPeso() + " kg en peso, y " + perUno.getEstatura() +  " m en estatura, con IMC = " + perUno.getIMC() );
            
    }
    
}
