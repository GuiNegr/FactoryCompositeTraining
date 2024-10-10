package Metodos;

import beans.cartas.InterfaceCarta;
import beans.cartas.deck.Deck;

public class Metodos {

    public static void mostrarAtributos(Deck deck){
        for (int i = 0; i < deck.size() ; i++) {
            InterfaceCarta carta = deck.pegarUm(i);
            System.out.println(i+ carta.toString());
        }
    }
}
