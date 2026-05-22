
package ejnotasobjetos;

import java.util.Scanner;

public class EjNotasObjetos {

    public static void main(String[] args) {
        
        Scanner e = new Scanner(System.in);
        
        String nombre, materia;
        double nota;
        int n;
        Materia [] mat;
        
        System.out.println("");
        System.out.println("Ingrese nombre del estudiante: ");
        nombre = e.nextLine();
        System.out.println("Ingrese la cantidad de materias: ");
        n = e.nextInt();
        System.out.println("-------------------------------------");
        
        mat = new Materia[n];
        
        for (int i = 0; i < mat.length; i++) {
            e.nextLine();
            System.out.println("Ingrese el nombre de la materia: ");
            materia = e.nextLine();
            System.out.println("Ingrese la nota de la materia: ");
            nota = e.nextDouble();
            
            Materia mt = new Materia(materia, nota);
            
            mat[i] = mt;
        }
        
        Libreta l = new Libreta(nombre, mat);
        System.out.println("--------------------");
        
        l.calcularPromedio();
        l.calcularPromedioCualitativo();
        
        System.out.println("El alumno " + l.getNombreEstudiante() + ", tiene un promedio de " + l.getPromedio() + ", equivalente a " + l.getPromedioCualitativo());
        
    }
    
}
