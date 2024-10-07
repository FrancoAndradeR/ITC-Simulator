package juego;
public class LibroDeCalculo extends Objeto {
    public LibroDeCalculo() {
        super("Libro de cálculo");
    }

    @Override
    public void usar(Jugador jugador) {
        jugador.aumentarSueno(10); // Aumenta el sueño en 10 puntos
        System.out.println("Has usado un " + nombre + " y has aumentado tu sueño en 10 puntos.");
    }
}
