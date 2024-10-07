package juego;

import java.util.Scanner;
import java.util.Random;

public class Mapa {
    private static final char[][] map = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'E', ' ', '#'},
            {'#', ' ', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', '#', ' ', '#'},
            {'#', ' ', '#', ' ', 'E', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'E', ' ', ' ', ' ', 'O', ' ', ' ', ' ', ' ', '#', ' ', ' ', 'O', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#', '#', '#', '#', '#', 'O', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', 'E', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'E', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', 'E', ' ', ' ', ' ', ' ', ' ', ' ', 'O', ' ', ' ', 'E', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'E', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', 'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'E', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'E', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'S'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        };
    private int playerX;
    private int playerY;
    private Jugador jugador;
    private Mecanicas mecanicas;
    private Random random;
    private Scanner scanner;

    private int totalDanioRecibido = 0;  // Para llevar la cuenta del daño recibido por el jugador
    private int totalDanioRealizado = 0; // Para llevar la cuenta del daño realizado por el jugador

    // Constructor de Mapa
    public Mapa(Jugador jugador, Scanner scanner) {
        this.jugador = jugador;
        this.mecanicas = new Mecanicas(jugador);
        this.playerX = 2;  // Posición inicial del jugador en X
        this.playerY = 1;  // Posición inicial del jugador en Y
        this.random = new Random();
        this.scanner = scanner;
    }

    // Método para imprimir el mapa completo en una sola vez
    public void printMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == playerX && j == playerY) {
                    System.out.print('P');  // Representa al jugador
                } else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println();
        }
    }

    // Método para mover al jugador
    public void movePlayer(char direction) {
        int newX = playerX;
        int newY = playerY;

        // Borrar la posición actual del jugador
        map[playerX][playerY] = ' ';  // Deja la posición anterior vacía

        // Control de movimiento basado en la dirección
        switch (direction) {
            case 'W': case 'w': newX--; break;  // Mover arriba
            case 'S': case 's': newX++; break;  // Mover abajo
            case 'A': case 'a': newY--; break;  // Mover izquierda
            case 'D': case 'd': newY++; break;  // Mover derecha
            default:
                System.out.println("Movimiento no válido.");
                return;
        }

        if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length) {
            char targetCell = map[newX][newY];

            if (targetCell == '#') {
                System.out.println("¡No puedes moverte en esa dirección! Hay una pared.");
            } else {
                // Actualiza las coordenadas del jugador
                playerX = newX;
                playerY = newY;

                if (targetCell == 'S') {
                    ganarJuego();  // El jugador ha llegado a la salida
                } else if (targetCell == 'E') {
                    System.out.println("¡Te has encontrado con un enemigo!");
                    Enemigo enemigo = generarEnemigoAleatorio();
                    boolean enemigoDerrotado = mecanicas.iniciarCombate(enemigo);

                    if (enemigoDerrotado) {
                        map[newX][newY] = ' ';  // Eliminar la 'E' del mapa al derrotar al enemigo
                    }
                } else if (targetCell == 'O') {
                    System.out.println("¡Te has encontrado un objeto!");
                    Objeto objeto = generarObjetoAleatorio();
                    mecanicas.recogerObjeto(objeto);
                    map[newX][newY] = ' ';  // Limpiar la celda después de recoger el objeto
                }

                // Actualiza el mapa
                printMap();
            }
        } else {
            System.out.println("¡No puedes moverte fuera del mapa!");
        }
    }

    // Método para manejar la derrota del jugador
    private void manejarDerrota() {
        System.out.println("¡Has perdido! Te quedaste sin sueño.");
        mostrarEstadisticasFinales();
        mostrarMenuFinal();
    }

    // Método para ganar el juego al llegar a la salida
    private void ganarJuego() {
        System.out.println("¡Felicidades! Has encontrado la salida del TEC y has ganado el juego.");
        mostrarEstadisticasFinales();
        mostrarMenuFinal();
    }

    // Método para mostrar las estadísticas finales del jugador
    private void mostrarEstadisticasFinales() {
        System.out.println("\n--- Estadísticas Finales ---");
        System.out.println("Daño total recibido: " + totalDanioRecibido);
        System.out.println("Daño total realizado: " + totalDanioRealizado);
        System.out.println("Sueño final: " + jugador.getSueno());
        System.out.println("Conocimiento final: " + jugador.getConocimiento());
        System.out.println("Hambre final: " + jugador.getHambre());
    }

    // Método para mostrar el menú final después de ganar o perder
    private void mostrarMenuFinal() {
        char opcion;
        do {
            System.out.println("\nR: Reiniciar juego");
            System.out.println("Q: Salir del juego");
            System.out.print("Elige una opción: ");
            opcion = scanner.next().charAt(0);

            if (opcion == 'R' || opcion == 'r') {
                reiniciarJuego();  // Reinicia el juego
                return;  // Salir del menú de fin de juego y reiniciar el ciclo de juego
            } else if (opcion == 'Q' || opcion == 'q') {
                System.out.println("Gracias por jugar Aventura en el TEC. ¡Hasta luego!");
                System.exit(0);  // Sale del juego
            } else {
                System.out.println("Opción no válida. Elige una opción correcta.");
            }
        } while (opcion != 'Q' && opcion != 'q');
    }

    // Método para reiniciar el juego
    private void reiniciarJuego() {
        this.jugador = new Jugador("Aventurero");  // Reinicia al jugador
        this.playerX = 2;  // Reiniciar la posición inicial del jugador
        this.playerY = 1;
        this.mecanicas = new Mecanicas(jugador);  // Reinicia las mecánicas
        this.totalDanioRecibido = 0;  // Reiniciar contador de daño recibido
        this.totalDanioRealizado = 0;  // Reiniciar contador de daño realizado
        System.out.println("¡El juego ha sido reiniciado!");
        jugar();  // Vuelve a iniciar el ciclo de juego para permitir la captura de movimientos
    }

    // Método principal del ciclo del juego
    public void jugar() {
        printMap();  // Imprimir el mapa completo una sola vez al inicio

        // Ciclo del juego
        while (true) {
            if (jugador.getSueno() <= 0) {
                manejarDerrota();  // Si el jugador se queda sin sueño, manejar la derrota
                return;  // Salir del ciclo si el jugador ha perdido
            }

            System.out.print("Movimiento: ");
            
            if (scanner.hasNext()) {
                char input = scanner.next().charAt(0);

                if (input == 'i' || input == 'I') {
                    jugador.mostrarInventario(scanner);  // Mostrar el inventario y pasar el scanner
                } else if (input != 'Q' && input != 'q') {
                    movePlayer(input);  // Mover al jugador
                } else if (input == 'Q' || input == 'q') {
                    System.out.println("¡Gracias por jugar!");
                    break;
                }
            } else {
                System.out.println("Error: No se puede leer la entrada.");
                break;
            }
        }
    }

    // Método para generar enemigos aleatorios
    private Enemigo generarEnemigoAleatorio() {
        int tipoEnemigo = random.nextInt(3);  // Generar un tipo de enemigo aleatorio
        switch (tipoEnemigo) {
            case 0: return new Cerecero();
            case 1: return new Esquivel();
            case 2: return new Caballero();
            default: return new Cerecero();  // Por defecto
        }
    }

    // Método para generar objetos aleatorios
    private Objeto generarObjetoAleatorio() {
        int tipoObjeto = random.nextInt(3);  // Generar un tipo de objeto aleatorio
        switch (tipoObjeto) {
            case 0: return new LibroDeCalculo();
            case 1: return new Protoboard();
            case 2: return new IDE();
            default: return new LibroDeCalculo();  // Por defecto
        }
    }

    // Método principal de ejecución
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Un solo objeto Scanner para todo el programa
        Jugador jugador = new Jugador("Aventurero");  // Crear el jugador
        Mapa mapa = new Mapa(jugador, scanner);  // Pasar el Scanner al mapa
        mapa.jugar();  // Ejecutar el ciclo del juego
    }
}
