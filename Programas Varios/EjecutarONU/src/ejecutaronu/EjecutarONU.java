
package ejecutaronu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class EjecutarONU {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ConflictoInternacional> listaConflictos = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        int opcion = 0;

        do {
            System.out.println("\n---- SISTEMA DE GESTION DE CONFLICTOS -- ONU ----");
            System.out.println("1. Registrar nuevo conflicto internacional");
            System.out.println("2. Agregar pais implicado a un conflicto");
            System.out.println("3. Registrar evento en un conflicto");
            System.out.println("4. Consultar informacion de un conflicto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                System.out.println("Entrada invalida.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del conflicto: ");
                    String nombreConflicto = scanner.nextLine();
                    
                    LocalDate fecha = null;
                    boolean fechaValida = false;
                    while (!fechaValida) {
                        System.out.print("Fecha de inicio (yyyy-MM-dd): ");
                        String fechaStr = scanner.nextLine();
                        try {
                            fecha = LocalDate.parse(fechaStr, formatter);
                            fechaValida = true;
                        } catch (Exception e) {
                            System.out.println("Formato incorrecto. Use yyyy-MM-dd.");
                        }
                    }

                    System.out.print("Detalles adicionales: ");
                    String detalles = scanner.nextLine();

                    ConflictoInternacional nuevoConflicto = new ConflictoInternacional(nombreConflicto, fecha, detalles);
                    listaConflictos.add(nuevoConflicto);
                    System.out.println("Conflicto registrado exitosamente.");
                    break;

                case 2:
                    if (listaConflictos.isEmpty()) {
                        System.out.println("No hay conflictos registrados.");
                        break;
                    }
                    for (int i = 0; i < listaConflictos.size(); i++) {
                        System.out.println((i + 1) + ". " + listaConflictos.get(i).getNombre());
                    }
                    System.out.print("Seleccione el conflicto: ");
                    int indexPais = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (indexPais >= 0 && indexPais < listaConflictos.size()) {
                        System.out.print("Nombre del pais a agregar: ");
                        String nombrePais = scanner.nextLine();
                        listaConflictos.get(indexPais).agregarPais(nombrePais);
                        System.out.println("Pais agregado. El sistema evaluara el estado del conflicto.");
                    } else {
                        System.out.println("Opcion no valida.");
                    }
                    break;

                case 3:
                    if (listaConflictos.isEmpty()) {
                        System.out.println("No hay conflictos registrados.");
                        break;
                    }
                    for (int i = 0; i < listaConflictos.size(); i++) {
                        System.out.println((i + 1) + ". " + listaConflictos.get(i).getNombre());
                    }
                    System.out.print("Seleccione el conflicto: ");
                    int indexEvento = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (indexEvento >= 0 && indexEvento < listaConflictos.size()) {
                        System.out.print("Nombre del evento: ");
                        String nomEvento = scanner.nextLine();
                        
                        LocalDate fechaEv = null;
                        boolean fevValida = false;
                        while (!fevValida) {
                            System.out.print("Fecha del evento (yyyy-MM-dd): ");
                            String fStr = scanner.nextLine();
                            try {
                                fechaEv = LocalDate.parse(fStr, formatter);
                                fevValida = true;
                            } catch (Exception e) {
                                System.out.println("Formato incorrecto. Use yyyy-MM-dd.");
                            }
                        }

                        System.out.print("Ubicacion: ");
                        String ubicacion = scanner.nextLine();
                        System.out.print("Descripcion: ");
                        String desc = scanner.nextLine();
                        System.out.print("Tipo de evento (batalla, tratado, reunion, etc.): ");
                        String tipo = scanner.nextLine();
                        
                        boolean nucleares = false;
                        boolean primerMundo = false;
                        double bajas = 0.0;

                        if (tipo.equalsIgnoreCase("batalla")) {
                            System.out.print("Se usaron armas nucleares? (true/false): ");
                            nucleares = scanner.nextBoolean();
                            System.out.print("Ocurrio en un pais de primer mundo? (true/false): ");
                            primerMundo = scanner.nextBoolean();
                        }
                        
                        System.out.print("Porcentaje maximo de bajas en un pais (ej. 55,5 o 55.5 dependiendo de tu region): ");
                        bajas = scanner.nextDouble();
                        scanner.nextLine();

                        Evento nuevoEvento = new Evento(nomEvento, fechaEv, ubicacion, desc, tipo, nucleares, primerMundo, bajas);
                        listaConflictos.get(indexEvento).agregarEvento(nuevoEvento);
                        System.out.println("Evento registrado. El sistema evaluara si es necesario convocar a la ONU o declarar Guerra Mundial.");
                    } else {
                        System.out.println("Opcion no valida.");
                    }
                    break;

                case 4:
                    if (listaConflictos.isEmpty()) {
                        System.out.println("No hay conflictos registrados.");
                        break;
                    }
                    for (int i = 0; i < listaConflictos.size(); i++) {
                        System.out.println((i + 1) + ". " + listaConflictos.get(i).getNombre());
                    }
                    System.out.print("Seleccione el conflicto a consultar: ");
                    int idxConsulta = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (idxConsulta >= 0 && idxConsulta < listaConflictos.size()) {
                        listaConflictos.get(idxConsulta).consultarInformacion();
                    } else {
                        System.out.println("Opcion no valida.");
                    }
                    break;

                case 5:
                    System.out.println("Cerrando el sistema de la ONU.");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}