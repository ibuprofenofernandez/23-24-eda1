package v00;

import java.util.Scanner;

public class Visicalc {

    private static final int FILAS = 15;
    private static final int COLUMNAS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] hojaCalculo = new String[FILAS][COLUMNAS];

        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                hojaCalculo[fila][columna] = "";
            }
        }

        int[] posicion = { 0, 0 };
        boolean estaOperativo = true;

        while (estaOperativo) {
            int filaActual = posicion[0];
            int columnaActual = posicion[1];

            System.out.print("      ");
            for (int columna = 0; columna < COLUMNAS; columna++) {
                char letraColumna = (char) ('A' + columna);
                System.out.printf("%-8s", letraColumna);
            }
            System.out.println();

            System.out.print("     +");
            for (int columna = 0; columna < COLUMNAS; columna++) {
                System.out.print("-------+");
            }
            System.out.println();

            for (int fila = 0; fila < FILAS; fila++) {
                System.out.printf("%-5d|", fila + 1);

                for (int columna = 0; columna < COLUMNAS; columna++) {
                    String celda = hojaCalculo[fila][columna];
                    celda = celda.length() > 5 ? celda.substring(0, 5) : String.format("%-5s", celda);

                    if (fila == filaActual && columna == columnaActual) {
                        celda = "[" + celda + "]";
                    } else {
                        celda = " " + celda + " ";
                    }

                    System.out.print(celda + "|");
                }
                System.out.println();
            }

            System.out.print("     +");
            for (int columna = 0; columna < COLUMNAS; columna++) {
                System.out.print("-------+");
            }
            System.out.println();
            System.out.println("Celda actual -> [" + (char) ('A' + columnaActual) + (filaActual + 1) + "]");
            System.out.println("Utilice las teclas W, A, S y D para moverse.");
            System.out.println("Presione 'E' para ingresar texto en la celda actual.");
            System.out.println("Presione 'Q' para salir.");

            char comando = scanner.next().toUpperCase().charAt(0);

            switch (comando) {
                case 'W':
                    filaActual = Math.max(filaActual - 1, 0);
                    break;
                case 'A':
                    columnaActual = Math.max(columnaActual - 1, 0);
                    break;
                case 'S':
                    filaActual = Math.min(filaActual + 1, FILAS - 1);
                    break;
                case 'D':
                    columnaActual = Math.min(columnaActual + 1, COLUMNAS - 1);
                    break;
                case 'E':
                    System.out.println("Ingrese el texto para la celda [" + (char) ('A' + columnaActual)
                            + (filaActual + 1) + "]:");
                    String texto = scanner.next();
                    hojaCalculo[filaActual][columnaActual] = texto;
                    break;
                case 'Q':
                    System.out.println("Saliendo del programa.");
                    estaOperativo = false;
                default:
                    System.out.println("Comando inválido. Intente nuevamente.");
            }

            posicion[0] = filaActual;
            posicion[1] = columnaActual;

        }

        scanner.close();
    }
}
