package metodos;

import beans.cartas.InterfaceCarta;
import beans.cartas.deck.Deck;

public class Metodos {

    public static void mostrarAtributos(Deck deck){
        try {
            for (int i = 0; i < deck.size() ; i++) {
                InterfaceCarta carta = deck.pegarUm(i);
                System.out.println(i+ carta.toString());
            }
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
