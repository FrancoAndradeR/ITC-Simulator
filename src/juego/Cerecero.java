package juego;

public class Cerecero extends Enemigo {
    public Cerecero() {
        super("Cerecero", 50); // 50 ganas de reprobarte
    }

    @Override
    public void atacar(Jugador jugador) {
        System.out.println(getNombre() + " te ataca con un problema de cálculo avanzado.");
        jugador.recibirDanio(10); // Inflige 10 puntos de daño al jugador
    }
}
