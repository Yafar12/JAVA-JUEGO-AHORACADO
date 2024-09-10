import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String palabraSecreta = "clorofila";
        int intentosMaximos = 10;
        int intento = 0;
        int letrasRestantes = 0;
        boolean estaAdivinada = false;

        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_'; // Inicializamos el array con '_'
        }

        while (!estaAdivinada && intento < intentosMaximos) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + (palabraSecreta.length() - letrasRestantes) + " letras restantes)");
            System.out.println("Introduce una letra: ");
            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;
            boolean letraRepetida = false;

            // Comprobamos si la letra ya ha sido ingresada
            for (int i = 0; i < letrasAdivinadas.length; i++) {
                if (letrasAdivinadas[i] == letra) {
                    letraRepetida = true;  // Marcamos si la letra ya fue adivinada
                    break;
                }
            }

            if (!letraRepetida) {  // Si la letra no está repetida, la procesamos
                for (int i = 0; i < palabraSecreta.length(); i++) {
                    if (palabraSecreta.charAt(i) == letra) {
                        letrasAdivinadas[i] = letra;
                        letraCorrecta = true;
                        letrasRestantes++;
                    }
                }

                if (!letraCorrecta) {
                    intento++;
                    System.out.println("Incorrecto! Te quedan " + (intentosMaximos - intento) + " intentos");
                }
            } else {
                System.out.println("¡Ya has ingresado esa letra! Intenta con otra.");
            }

            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                estaAdivinada = true;
                System.out.println("¡Felicidades, has adivinado la palabra secreta! " + palabraSecreta);
            }
        }

        if (!estaAdivinada) {
            System.out.println("Que pena, te has quedado sin intentos. ¡Lo siento!");
        }

        scanner.close();
    }
}
