package Ahorcado;

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


}
