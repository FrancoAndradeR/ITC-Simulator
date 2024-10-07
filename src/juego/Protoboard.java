package juego;
public class Protoboard extends Objeto {
    public Protoboard() {
        super("Protoboard");
    }

    @Override
    public void usar(Jugador jugador) {
        jugador.aumentarConocimiento(10); // Aumenta el conocimiento en 10 puntos
        System.out.println("Has usado un " + nombre + " y tu conocimiento ha aumentado en 10 puntos.");
    }
}
