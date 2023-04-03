import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Participante> participantes = null;

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Cargar participantes");
            System.out.println("2. Realizar sorteo");
            System.out.println("3. Salir del programa");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    try {
                        System.out.print("Ingrese la ruta del archivo CSV: ");
                        String ruta = scanner.next();
                        participantes = Archivo.cargarParticipantes(ruta);
                        System.out.println("Se han cargado " + participantes.size() + " participantes.");
                    } catch (IOException e) {
                        System.out.println("Error al cargar el archivo: " + e.getMessage());
                    }
                    break;
                case 2:
                    if (participantes != null) {
                        Sorteo sorteo = new Sorteo(participantes);
                        Participante ganador = sorteo.obtenerGanador();
                        System.out.println("El ganador del sorteo es: " + ganador.getNombre() + " " + ganador.getApellido());
                    } else {
                        System.out.println("Debe cargar los participantes primero.");
                    }
                    break;
                case 3:
                    System.out.println("Gracias por utilizar el programa.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }
}
