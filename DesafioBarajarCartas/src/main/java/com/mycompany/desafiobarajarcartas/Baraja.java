
package com.mycompany.desafiobarajarcartas;

// Clase que representa una baraja de cartas

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Baraja {
    private Carta primeraCarta;
    private Carta ultimaCarta;

    // Constructor de la clase Baraja
    public Baraja() {
        inicializarBaraja();
    }

    // Inicializa la baraja con cartas ordenadas
    private void inicializarBaraja() {
        Carta cartaAnterior = null;

        String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        String[] rangos = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String palo : palos) {
            for (String rango : rangos) {
                Carta nuevaCarta = new Carta(palo, rango);

                if (cartaAnterior != null) {
                    nuevaCarta.anterior = cartaAnterior;
                    cartaAnterior.siguiente = nuevaCarta;
                }

                cartaAnterior = nuevaCarta;

                if (primeraCarta == null) {
                    primeraCarta = nuevaCarta;
                }
            }
        }

        ultimaCarta = cartaAnterior;
    }

    // Baraja las cartas en la baraja
    public void barajar() {
        List<Carta> listaCartas = convertirLista();
        Collections.shuffle(listaCartas);

        Carta cartaAnterior = null;

        for (Carta carta : listaCartas) {
            carta.anterior = cartaAnterior;
            carta.siguiente = null;

            if (cartaAnterior != null) {
                cartaAnterior.siguiente = carta;
            }

            cartaAnterior = carta;
        }

        primeraCarta = listaCartas.get(0);
        ultimaCarta = listaCartas.get(listaCartas.size() - 1);
    }

    // Convierte la baraja a una lista para barajar
    private List<Carta> convertirLista() {
        List<Carta> listaCartas = new LinkedList<>();
        Carta cartaActual = primeraCarta;

        while (cartaActual != null) {
            listaCartas.add(cartaActual);
            cartaActual = cartaActual.siguiente;
        }

        return listaCartas;
    }

    // Roba una carta de la baraja
    public Carta robarCarta() {
        if (primeraCarta == null) {
            System.out.println("La baraja está vacía. No se puede robar una carta.");
            return null;
        }

        Carta cartaRobada = primeraCarta;
        primeraCarta = cartaRobada.siguiente;

        if (primeraCarta != null) {
            primeraCarta.anterior = null;
        } else {
            ultimaCarta = null;
        }

        return cartaRobada;
    }

    // Muestra las cartas en la baraja
    public void mostrarBaraja() {
        Carta cartaActual = primeraCarta;
        while (cartaActual != null) {
            System.out.println(cartaActual);
            cartaActual = cartaActual.siguiente;
        }
    }
}

