package juego;
/**
 * Clase abstracta Enemigo: Representa a los enemigos del juego.
 * Cada enemigo tiene un nombre y un atributo de "ganas de reprobarte" en lugar de salud.
 */
public abstract class Enemigo {
    private String nombre;  // Nombre del enemigo
    private int ganasDeReprobarte;  // Atributo similar a la salud

    /**
     * Constructor del enemigo.
     */
    public Enemigo(String nombre, int ganasDeReprobarte) {
        this.nombre = nombre;
        this.ganasDeReprobarte = ganasDeReprobarte;
    }

    // Métodos getter
    public String getNombre() {
        return nombre;
    }

    public int getGanasDeReprobarte() {
        return ganasDeReprobarte;
    }

    /**
     * Método para recibir daño y reducir las ganas de reprobar al jugador.
     */
    public void recibirDanio(int cantidad) {
        ganasDeReprobarte -= cantidad;
        if (ganasDeReprobarte <= 0) {
            System.out.println(nombre + " ha sido derrotado. ¡Ya no tiene ganas de reprobarte!");
        } else {
            System.out.println(nombre + " ha recibido " + cantidad + " puntos de daño. Ganas de reprobarte actual: " + ganasDeReprobarte);
        }
    }

    /**
     * Método abstracto para atacar al jugador.
     * Cada enemigo tiene su propia forma de atacar.
     */
    public abstract void atacar(Jugador jugador);
}
