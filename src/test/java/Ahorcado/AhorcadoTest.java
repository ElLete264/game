package Ahorcado;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AhorcadoTest {

    @Test
    void testProgresoInicialConGuiones() {
        Ahorcado juego = new Ahorcado("ordenador");
        assertEquals("_________", juego.getProgreso());
        // 9 guiones por 9 letras
    }

    @Test
    void testAdivinarLetraCorrecta() {
        Ahorcado juego = new Ahorcado("ordenador");
        juego.adivinarLetra('o');
        assertEquals("o______o_", juego.getProgreso());
    }

    @Test
    void testAdivinarLetraIncorrecta() {
        Ahorcado juego = new Ahorcado("ordenador");
        juego.adivinarLetra('z');
        assertEquals("_________", juego.getProgreso());
    }

    @Test
    void testAdivinarLetraVariasVeces() {
        Ahorcado juego = new Ahorcado("ordenador");
        juego.adivinarLetra('r');
        assertEquals("_r______r", juego.getProgreso());
        juego.adivinarLetra('d');
        assertEquals("_rd___d_r", juego.getProgreso());
    }



    @Test
    void testMostrarPalabra() {
        Ahorcado juego = new Ahorcado("ordenador");
        assertEquals("ordenador", juego.getPalabraSecreta());
    }
}
