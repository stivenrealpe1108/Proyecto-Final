

package com.mycompany.desafiobarajarcartas;

// Clase principal que interactúa con el usuario

import java.util.Scanner;

public class DesafioBarajarCartas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Baraja baraja = new Baraja();  // Crear una instancia de la clase Baraja

        // Bucle principal del juego
        while (true) {
            // Menú de opciones para el usuario
            System.out.println("\n1. Mostrar baraja");
            System.out.println("2. Barajar la baraja");
            System.out.println("3. Sacar una carta");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();  // Leer la opción del usuario
            scanner.nextLine();  // Consumir la nueva línea pendiente después de nextInt

            // Evaluar la opción seleccionada por el usuario
            switch (opcion) {
                case 1:
                    // Mostrar las cartas en la baraja
                    System.out.println("Mostrando la baraja:");
                    baraja.mostrarBaraja();
                    break;

                case 2:
                    // Barajar las cartas en la baraja
                    System.out.println("Barajando la baraja:");
                    baraja.barajar();
                    baraja.mostrarBaraja();
                    break;

                case 3:
                    // Sacar una carta de la baraja
                    System.out.println("Sacando una carta:");
                    Carta cartaRobada = baraja.robarCarta();
                    if (cartaRobada != null) {
                        System.out.println("Carta robada: " + cartaRobada);
                    }
                    break;

                case 4:
                    // Salir del programa
                    System.out.println("Saliendo del programa...");
                    System.exit(0);

                default:
                    // Mensaje para opciones no válidas
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}