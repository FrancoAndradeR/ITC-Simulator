package juego;

import java.util.Scanner;

/**
 * Clase Jugador: Representa al jugador del juego con atributos de sueño, conocimiento y hambre.
 */
public class Jugador {
    private String nombre;          // Nombre del jugador
    private int sueno;              // Nivel de sueño (similar a la salud)
    private int conocimiento;       // Nivel de conocimiento (similar al ataque)
    private int hambre;             // Nivel de hambre (similar a la defensa)
    private Inventario inventario;  // Inventario del jugador


    /**
     * Constructor del jugador.
     * Inicializa el jugador con valores predeterminados de sueño, conocimiento y hambre.
     * 
     * @param nombre El nombre del jugador.
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.sueno = 50;          // Comienza con 50 de sueño
        this.conocimiento = 10;   // Comienza con 10 de conocimiento
        this.hambre = 5;          // Comienza con 5 de hambre
        this.inventario = new Inventario();
    }

    // Métodos getter para obtener los valores de los atributos
    public String getNombre() {
        return nombre;
    }

    public int getSueno() {
        return sueno;
    }

    public int getConocimiento() {
        return conocimiento;
    }

    public int getHambre() {
        return hambre;
    }

    /**
     * Aumenta el nivel de sueño del jugador.
     * Si se supera el máximo de 100 puntos, se muestra un mensaje.
     * 
     * @param cantidad La cantidad de sueño a aumentar.
     */
    public void aumentarSueno(int cantidad) {
        if (sueno + cantidad > 100) {
            System.out.println("El nivel de sueño está al máximo. No puedes usar el objeto.");
        } else {
            this.sueno += cantidad;
            System.out.println(nombre + " ha aumentado su nivel de sueño en " + cantidad + " puntos. Sueño actual: " + sueno);
        }
    }

    /**
     * Aumenta el conocimiento del jugador.
     * Si se supera el máximo de 100 puntos, se muestra un mensaje.
     */
    public void aumentarConocimiento(int cantidad) {
        if (conocimiento + cantidad > 100) {
            System.out.println("El conocimiento está al máximo. No puedes usar el objeto.");
        } else {
            this.conocimiento += cantidad;
            System.out.println(nombre + " ha aumentado su conocimiento en " + cantidad + " puntos. Conocimiento actual: " + conocimiento);
        }
    }

    /**
     * Aumenta el hambre del jugador.
     */
    public void aumentarHambre(int cantidad) {
        if (hambre + cantidad > 100) {
            System.out.println("El hambre está al máximo. No puedes usar el objeto.");
        } else {
            this.hambre += cantidad;
            System.out.println(nombre + " ha aumentado su hambre en " + cantidad + " puntos. Hambre actual: " + hambre);
        }
    }

    /**
     * El jugador recibe daño, que se reduce en función de su nivel de hambre (defensa).
     */
    public void recibirDanio(int cantidad) {
        int danioFinal = cantidad - hambre;
        if (danioFinal < 0) danioFinal = 0;
        sueno -= danioFinal;
        System.out.println(nombre + " ha perdido " + danioFinal + " puntos de sueño. Sueño actual: " + sueno);
    }

    /**
     * El jugador ataca a un enemigo usando su conocimiento.
     */
    public void atacar(Enemigo enemigo) {
        System.out.println(nombre + " usa su conocimiento para atacar a " + enemigo.getNombre() + ", infligiendo " + conocimiento + " puntos de daño.");
        enemigo.recibirDanio(conocimiento);
    }

    // Métodos para gestionar el inventario
    public void mostrarAtributos() {
        System.out.println("Sueño: " + sueno);
        System.out.println("Conocimiento: " + conocimiento);
        System.out.println("Hambre: " + hambre);
    }

    public void mostrarInventario(Scanner scanner) {
        // Pasamos el Scanner al inventario
        inventario.mostrarInventario(this, scanner);
    }

    public void recogerObjeto(Objeto objeto) {
        inventario.agregarObjeto(objeto);
    }

    public void usarObjeto(int indice) {
        inventario.usarObjeto(indice, this);
    }
}
