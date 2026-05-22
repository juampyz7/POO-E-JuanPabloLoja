
package ejecutarfiscalia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class EjecutarFiscalia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<CasoCorrupcion> listaCasos = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        int opcion = 0;

        do {
            System.out.println("\n--------------- MENU PRINCIPAL FISCALIA ---------------");
            System.out.println("1. Registrar nuevo caso");
            System.out.println("2. Agregar persona a un caso");
            System.out.println("3. Consultar informacion de un caso");
            System.out.println("4. Registrar colaboracion y calcular fianza de persona");
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
                    System.out.print("Nombre del caso: ");
                    String nombreCaso = scanner.nextLine();
                    
                    LocalDate fecha = null;
                    boolean fechaValida = false;
                    while (!fechaValida) {
                        System.out.print("Fecha de inicio (yyyy-MM-dd): ");
                        String fechaStr = scanner.nextLine();
                        try {
                            fecha = LocalDate.parse(fechaStr, formatter);
                            fechaValida = true;
                        } catch (Exception e) {
                            System.out.println("Formato incorrecto. Por favor use el formato yyyy-MM-dd.");
                        }
                    }

                    System.out.print("Detalles adicionales: ");
                    String detalles = scanner.nextLine();

                    CasoCorrupcion nuevoCaso = new CasoCorrupcion(nombreCaso, fecha, detalles);
                    listaCasos.add(nuevoCaso);
                    System.out.println("Caso registrado con exito.");
                    break;

                case 2:
                    if (listaCasos.isEmpty()) {
                        System.out.println("No hay casos registrados.");
                        break;
                    }
                    for (int i = 0; i < listaCasos.size(); i++) {
                        System.out.println((i + 1) + ". " + listaCasos.get(i).getNombreCaso());
                    }
                    System.out.print("Seleccione el numero de caso: ");
                    int indexCaso = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (indexCaso >= 0 && indexCaso < listaCasos.size()) {
                        System.out.print("Nombre de la persona: ");
                        String nombreP = scanner.nextLine();
                        System.out.print("Edad: ");
                        int edad = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Ocupacion: ");
                        String ocupacion = scanner.nextLine();
                        System.out.print("Nivel de implicacion (ej. acusado, testigo, victima): ");
                        String nivel = scanner.nextLine();

                        PersonaImplicada nuevaPersona = new PersonaImplicada(nombreP, edad, ocupacion, nivel);
                        listaCasos.get(indexCaso).agregarPersona(nuevaPersona);
                    } else {
                        System.out.println("Opcion no valida.");
                    }
                    break;

                case 3:
                    if (listaCasos.isEmpty()) {
                        System.out.println("No hay casos registrados.");
                        break;
                    }
                    for (int i = 0; i < listaCasos.size(); i++) {
                        System.out.println((i + 1) + ". " + listaCasos.get(i).getNombreCaso());
                    }
                    System.out.print("Seleccione el numero de caso: ");
                    int idxConsulta = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (idxConsulta >= 0 && idxConsulta < listaCasos.size()) {
                        CasoCorrupcion casoActual = listaCasos.get(idxConsulta);
                        casoActual.actualizarEstado();
                        casoActual.consultarInformacion();
                    } else {
                        System.out.println("Opcion no valida.");
                    }
                    break;

                case 4:
                    if (listaCasos.isEmpty()) {
                        System.out.println("No hay casos registrados.");
                        break;
                    }
                    for (int i = 0; i < listaCasos.size(); i++) {
                        System.out.println((i + 1) + ". " + listaCasos.get(i).getNombreCaso());
                    }
                    System.out.print("Seleccione el numero de caso: ");
                    int idxPersona = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (idxPersona >= 0 && idxPersona < listaCasos.size()) {
                        CasoCorrupcion casoP = listaCasos.get(idxPersona);
                        System.out.print("Ingrese el nombre exacto de la persona: ");
                        String nombreBuscado = scanner.nextLine();
                        
                        PersonaImplicada personaEncontrada = casoP.buscarPersona(nombreBuscado);
                        if (personaEncontrada != null) {
                            if (personaEncontrada.getNivelImplicacion().equalsIgnoreCase("acusado")) {
                                System.out.print("Ingrese los anios de sentencia: ");
                                double anios = scanner.nextDouble();
                                System.out.print("Ingrese el dano economico total del caso: ");
                                double dano = scanner.nextDouble();
                                scanner.nextLine();

                                personaEncontrada.setSentenciaAnios(anios);
                                personaEncontrada.setDanoEconomicoTotal(dano);

                                personaEncontrada.colaborarConFiscalia();
                                personaEncontrada.calcularFianza();
                            } else {
                                System.out.println("La persona no es acusada. No aplica para reduccion o fianza.");
                            }
                        }
                    } else {
                        System.out.println("Opcion no valida.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
