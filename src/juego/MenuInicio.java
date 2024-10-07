package juego;

import java.util.Scanner;

public class MenuInicio {
    private Scanner scanner;

    public MenuInicio(Scanner scanner) {
        this.scanner = scanner;
    }

    // Método para mostrar el menú principal
    public void mostrarMenuPrincipal() {
        char opcion;

        do {
            System.out.println("****************************************");
            System.out.println("      Bienvenido a Aventura en el TEC");
            System.out.println("****************************************");
            System.out.println("1. Iniciar Nuevo Juego");
            System.out.println("2. Ver Instrucciones");
            System.out.println("Q. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.next().charAt(0);

            switch (opcion) {
                case '1':
                    iniciarJuego();  // Iniciar el juego
                    break;
                case '2':
                    mostrarInstrucciones();  // Mostrar las instrucciones
                    break;
                case 'Q': case 'q':
                    System.out.println("Gracias por jugar Aventura en el TEC. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción correcta.");
            }

        } while (opcion != 'Q' && opcion != 'q');
    }

    // Método para iniciar el juego
    private void iniciarJuego() {
        System.out.println("¡El semestre ha comenzado y las batallas contra los profesores se acercan!");
        // Crear el jugador e iniciar el juego
        Jugador jugador = new Jugador("Aventurero del TEC");
        Mapa mapa = new Mapa(jugador, scanner);
        mapa.jugar();  // Iniciar el ciclo de juego
    }

    // Método para mostrar las instrucciones del juego
    private void mostrarInstrucciones() {
        System.out.println("\n--- Instrucciones ---");
        System.out.println("En Aventura en el TEC, debes enfrentarte a profesores para no reprobar.");
        System.out.println("Usa las teclas W, A, S, D para moverte por la mazmorra.");
        System.out.println("Encuentra objetos (O) que mejorarán tus atributos:");
        System.out.println(" - Libro de cálculo: Aumenta tu sueño.");
        System.out.println(" - Protoboard: Aumenta tu conocimiento.");
        System.out.println(" - IDE: Aumenta tu hambre.");
        System.out.println("Enfréntate a profesores (E) y usa tu conocimiento para derrotarlos.");
        System.out.println("¡Ten cuidado! Si tu sueño llega a 0, perderás el juego.");
        System.out.println("\nPresiona cualquier tecla para regresar al menú principal.");
        scanner.next();  // Espera a que el jugador presione una tecla para continuar
    }

    // Método principal para ejecutar el menú desde el inicio
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuInicio menu = new MenuInicio(scanner);
        menu.mostrarMenuPrincipal();
    }
}
