package juego;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Mecanicas: Gestiona el combate y la interacción del jugador con los objetos.
 */
public class Mecanicas {
    private Jugador jugador;  // Referencia al jugador
    private Scanner scanner;  // Para leer las decisiones del jugador durante el combate

    /**
     * Constructor de Mecanicas.
     * 
     * @param jugador El jugador que interactúa en el juego.
     */
    public Mecanicas(Jugador jugador) {
        this.jugador = jugador;
        this.scanner = new Scanner(System.in);  // Inicializa el escáner para leer las decisiones
    }

    /**
     * Método para iniciar un combate entre el jugador y un enemigo.
     * El jugador puede atacar o huir.
     * 
     * @param enemigo El enemigo con el que el jugador se enfrenta.
     * @return true si el enemigo es derrotado, false si el jugador huye.
     */
    public boolean iniciarCombate(Enemigo enemigo) {
        System.out.println("¡Te has encontrado con " + enemigo.getNombre() + "!");
        System.out.println(enemigo.getNombre() + " tiene " + enemigo.getGanasDeReprobarte() + " ganas de reprobarte.");

        while (jugador.getSueno() > 0 && enemigo.getGanasDeReprobarte() > 0) {
            int opcion = 0;
            boolean entradaValida = false; // Bandera para controlar entradas válidas

            // Ciclo para manejar entradas incorrectas
            while (!entradaValida) {
                try {
                    System.out.println("¿Qué deseas hacer?");
                    System.out.println("1. Usar conocimiento (atacar)");
                    System.out.println("2. Huir");
                    System.out.print("Elige una opción: ");
                    
                    opcion = scanner.nextInt(); // Intentar leer la opción como un número entero
                    entradaValida = true; // Si la entrada es correcta, salimos del ciclo
                } catch (InputMismatchException e) {
                    System.out.println("No existe esa opción. Por favor, ingresa 1 para atacar o 2 para huir."); // Mensaje de error
                    scanner.next(); // Limpiar la entrada no válida del escáner
                }
            }

            // Procesar la opción del jugador
            if (opcion == 1) {
                // Turno del jugador para atacar
                jugador.atacar(enemigo);
                if (enemigo.getGanasDeReprobarte() <= 0) {
                    System.out.println("¡Has derrotado a " + enemigo.getNombre() + "!");
                    return true;  // El enemigo ha sido derrotado
                }

                // Turno del enemigo para atacar
                enemigo.atacar(jugador);
                if (jugador.getSueno() <= 0) {
                    System.out.println("¡Has caído por falta de sueño! " + enemigo.getNombre() + " te ha derrotado.");
                    break;
                }
            } else if (opcion == 2) {
                System.out.println("Has decidido huir del combate.");
                return false;  // El jugador huye, enemigo no derrotado
            } else {
                // Si el jugador ingresa un número válido pero fuera de rango
                System.out.println("No existe esa opción.");
            }
        }
        return false;
    }

    // Método para recoger un objeto
    public void recogerObjeto(Objeto objeto) {
        jugador.recogerObjeto(objeto);
        System.out.println("Has recogido un " + objeto.getNombre() + ".");
    }
}
