package juego;

public class Caballero extends Enemigo {
    public Caballero() {
        super("Caballero", 60); // 60 ganas de reprobarte
    }

    @Override
    public void atacar(Jugador jugador) {
        System.out.println(getNombre() + " te lanza una pregunta de lógica.");
        jugador.recibirDanio(12); // Inflige 12 puntos de daño al jugador
    }
}
