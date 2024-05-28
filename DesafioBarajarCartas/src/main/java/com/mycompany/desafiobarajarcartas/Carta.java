
package com.mycompany.desafiobarajarcartas;

// Clase que representa una carta
class Carta {
    String palo;
    String rango;
    Carta siguiente;
    Carta anterior;

    // Constructor de la clase Carta
    public Carta(String palo, String rango) {
        this.palo = palo;
        this.rango = rango;
        this.siguiente = null;
        this.anterior = null;
    }

    // Método para mostrar la representación de la carta como cadena
    @Override
    public String toString() {
        return rango + " de " + palo;
    }
}
