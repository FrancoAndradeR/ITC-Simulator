package juego;

/**
 * Clase abstracta Objeto: Representa los objetos que el jugador puede usar.
 */
public abstract class Objeto {
    protected String nombre;  // Nombre del objeto

    /**
     * Constructor de Objeto.
     * 
     */
    public Objeto(String nombre) {
        this.nombre = nombre;
    }

    // Método getter para obtener el nombre del objeto
    public String getNombre() {
        return nombre;
    }

    /**
     * Método abstracto para aplicar el efecto del objeto en el jugador.
     */
    public abstract void usar(Jugador jugador);
}
