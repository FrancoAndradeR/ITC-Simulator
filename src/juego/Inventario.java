package juego;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Inventario: Gestiona los objetos que el jugador puede recolectar y usar.
 */
public class Inventario {
    private ArrayList<Objeto> objetos;  // Lista de objetos en el inventario

    /**
     * Constructor de Inventario.
     * Inicializa la lista de objetos vacía.
     */
    public Inventario() {
        this.objetos = new ArrayList<>();
    }

    /**
     * Método para agregar un objeto al inventario.
     * 
     * @param objeto El objeto a agregar.
     */
    public void agregarObjeto(Objeto objeto) {
        objetos.add(objeto);
        System.out.println("Has añadido " + objeto.getNombre() + " al inventario.");
    }

    /**
     * Método para mostrar el inventario y permitir al jugador usar objetos.
     * 
     * @param jugador El jugador que usa el inventario.
     */
    public void mostrarInventario(Jugador jugador, Scanner scanner) {
        if (objetos.isEmpty()) {
            System.out.println("¡Tu mochila está vacía!");
        } else {
            System.out.println("\n--- Inventario ---");
            for (int i = 0; i < objetos.size(); i++) {
                System.out.println(i + ": " + objetos.get(i).getNombre());
            }
        }

        System.out.println("\n--- Atributos del jugador ---");
        jugador.mostrarAtributos();

        // Si hay objetos en el inventario, permitir su uso
        if (!objetos.isEmpty()) {
            System.out.print("\nSelecciona el número del objeto que deseas usar o -1 para salir: ");
            
            // Asegurarse de que hay entrada disponible antes de leerla
            if (scanner.hasNextInt()) {
                int indice = scanner.nextInt();  // Continuar usando el mismo scanner

                if (indice >= 0 && indice < objetos.size()) {
                    usarObjeto(indice, jugador);  // Usa el objeto seleccionado
                } else if (indice == -1) {
                    System.out.println("Has salido del inventario.");
                } else {
                    System.out.println("Índice no válido.");
                }
            } else {
                System.out.println("Error en la entrada. Selecciona un número válido.");
                scanner.next();  // Limpiar la entrada inválida
            }
        }
    }


    /**
     * Método para usar un objeto del inventario.
     * 
     * @param indice El índice del objeto en el inventario.
     * @param jugador El jugador que usa el objeto.
     */
    public void usarObjeto(int indice, Jugador jugador) {
        if (indice >= 0 && indice < objetos.size()) {
            Objeto objeto = objetos.get(indice);
            objeto.usar(jugador);  // Aplicar el efecto del objeto en el jugador
            objetos.remove(indice);  // Eliminar el objeto del inventario después de usarlo
        } else {
            System.out.println("Índice no válido.");
        }
    }
}
