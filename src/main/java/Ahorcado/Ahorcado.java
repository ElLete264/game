package Ahorcado;
import java.util.Scanner;

public class Ahorcado {
    private String palabraSecreta; // La palabra que hay que adivinar
    private String progreso;       // Lo que el jugador ve ("_ _ _")

    // Constructor: recibe la palabra secreta y la guarda
    public Ahorcado(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta;
        this.progreso = generarProgreso(); // Inicializa con guiones bajos
    }

    // Cadena con guiones bajos del mismo tamaño que la palabra secreta
    private String generarProgreso() {
        StringBuilder sb = new StringBuilder(); // Crea una cadena vacía para rellenarla
        for (int i = 0; i < palabraSecreta.length(); i++) {
            // Recorre cada letra de la palabra secreta (sin mostrarla)
            sb.append("_"); // Añade un guion bajo por cada letra
        }
        return sb.toString(); // Devuelve la cadena completa con guiones ("____")
    }

    // Muestra el progreso actual del jugador
    public void mostrarProgreso() {
        System.out.println("Progreso: " + progreso); // Imprime los guiones
    }

    public void mostrarPalabra() { // Mostrar la palabra secreta
        System.out.println("Palabra secreta: " + palabraSecreta);
    }

    // Intenta adivinar una letra
    public void adivinarLetra(char letra) {
        StringBuilder nuevoProgreso = new StringBuilder(progreso); // Copia del progreso actual

        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                nuevoProgreso.setCharAt(i, letra); // Reemplaza el guion por la letra acertada
            }
        }
        progreso = nuevoProgreso.toString(); // Actualiza el progreso con los cambios
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido al juego del Ahorcado!");

        while (true) {
            mostrarProgreso();
            System.out.print("Adivina una letra: ");
            char letra = scanner.next().toLowerCase().charAt(0);

            adivinarLetra(letra);

            if (!progreso.contains("_")) {
                System.out.println("¡Felicidades! Has adivinado la palabra:");
                mostrarProgreso();
                break;
            }
        }
    }
    //Añadí getters (getProgreso(), getPalabraSecreta()) para poder comprobar
    // desde los tests el estado interno del juego, porque antes solo
    // mostrabas con System.out.println y eso no se puede.
    public String getProgreso() {
        return progreso;
    }

    public String getPalabraSecreta() {
        return palabraSecreta;
    }

}
