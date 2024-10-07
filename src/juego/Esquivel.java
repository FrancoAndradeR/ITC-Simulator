package juego;
public class Esquivel extends Enemigo {
    public Esquivel() {
        super("Esquivel", 40); // 40 ganas de reprobarte
    }

    @Override
    public void atacar(Jugador jugador) {
        System.out.println(getNombre() + " te ataca con una fórmula de física.");
        jugador.recibirDanio(8); // Inflige 8 puntos de daño al jugador
    }
}
