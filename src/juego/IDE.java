package juego;

public class IDE extends Objeto {
    public IDE() {
        super("IDE");
    }

    @Override
    public void usar(Jugador jugador) {
        jugador.aumentarHambre(10); // Aumenta el hambre en 10 puntos
        System.out.println("Has usado un " + nombre + " y tu hambre ha aumentado en 10 puntos.");
    }
}
