# Aventura en el TEC


## Descripción

**Aventura en el TEC** es un juego de aventura en consola donde los jugadores deben explorar una universidad, enfrentar enemigos, recolectar objetos y sobrevivir gestionando sus atributos de `sueño`, `conocimiento` y `hambre`. El objetivo principal es sobrevivir a los profesores antes de quedarse sin `sueño`, que actúa como tu energía vital.

## Instrucciones de Juego

1. **Movimiento**:
   - Usa las teclas `W`, `A`, `S`, `D` para moverte por la mazmorra:
     - `W`: Mover hacia arriba.
     - `A`: Mover hacia la izquierda.
     - `S`: Mover hacia abajo.
     - `D`: Mover hacia la derecha.
   - Ingresa `i` para ver tu inventario en cualquier momento.
   - Ingresa `Q` para salir del juego.

2. **Objetivo**:
   - Explora la mazmorra, encuentra objetos que te ayuden a mejorar tus atributos y lucha contra enemigos para sobrevivir.
   - Evita que tus puntos de `sueño` lleguen a 0, ya que eso resultará en una derrota.

3. **Interacciones**:
   - Cuando te encuentres con un enemigo (`E`), el juego te ofrecerá un menú para:
     - Atacar usando tu `conocimiento`.
     - Huir y evitar el combate.
   - Si encuentras un objeto (`O`), puedes recogerlo y usarlo desde tu inventario para mejorar tus atributos.

## Atributos del Jugador

Tu personaje tiene tres atributos principales que afectan tu desempeño en la mazmorra:

1. **Sueño (similar a salud)**:
   - Representa la energía vital de tu personaje.
   - Si llega a 0, perderás la partida.
   - Puedes aumentarlo usando el objeto `Libro de Cálculo`.

2. **Conocimiento (similar a ataque)**:
   - Representa tu capacidad de infligir daño a los enemigos durante el combate.
   - Puedes aumentarlo usando el objeto `Protoboard`.

3. **Hambre (similar a defensa)**:
   - Representa la cantidad de daño que puedes bloquear durante el combate.
   - Puedes aumentarlo usando el objeto `IDE`.

### Valores Iniciales:
- **Sueño**: 50 puntos (máximo 100).
- **Conocimiento**: 10 puntos (máximo 100).
- **Hambre**: 5 puntos (máximo 100).

### Uso de Objetos:
- Cada objeto puede aumentar un atributo en 10 puntos.
- El uso de un objeto no puede aumentar un atributo por encima de 100 puntos.
- Si intentas usar un objeto cuando un atributo ya está al máximo, recibirás un mensaje indicando que no se puede usar.

## Mecánicas de Juego

1. **Combate**:
   - Si te encuentras con un enemigo, puedes:
     - `1`: Atacar con tu `conocimiento`.
     - `2`: Huir del combate.
   - Durante el combate, cada enemigo tiene un nivel de "Ganas de Reprobarte", que actúa como su salud. Si reduces este valor a 0, derrotas al enemigo.
   - Los enemigos te atacarán y reducirán tu `sueño`. Si te quedas sin `sueño`, perderás la partida.

2. **Enemigos**:
   - Los enemigos son generados de manera aleatoria entre tres tipos:
     - **Cerecero**: Tiene 50 puntos de "Ganas de Reprobarte".
     - **Esquivel**: Tiene 40 puntos de "Ganas de Reprobarte".
     - **Caballero**: Tiene 60 puntos de "Ganas de Reprobarte".
   - Los enemigos infligen daño al jugador, reduciendo su `sueño`:
     - **Cerecero**: 10 puntos de daño.
     - **Esquivel**: 8 puntos de daño.
     - **Caballero**: 12 puntos de daño.

3. **Inventario**:
   - Puedes acceder a tu inventario en cualquier momento pulsando `i`.
   - El inventario te muestra los objetos que has recogido y los puntos actuales de tus atributos (`sueño`, `conocimiento` y `hambre`).
   - Puedes usar objetos seleccionando su número en el inventario. Cada objeto aumenta un atributo en 10 puntos.
   - Si no tienes objetos en tu inventario, se mostrará el mensaje "¡Tu mochila está vacía!".

## ¿Qué hacer al perder?

- Si tu `sueño` llega a 0, aparecerá un menú de derrota donde puedes:
  - `R`: Reiniciar el juego y comenzar desde el inicio.
  - `Q`: Abandonar el juego.

## Créditos

**Aventura en el TEC** fue desarrollado como parte de un proyecto de "Programación Avanzada" con el objetivo de aplicar conceptos de Programación Orientada a Objetos, incluyendo herencia, abstracción y manejo de colecciones como `ArrayList`.
