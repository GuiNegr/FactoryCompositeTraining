package Metodos;

import beans.cartas.Factory.CartasFactory;
import beans.cartas.InterfaceCarta;
import beans.cartas.deck.Deck;
import java.util.Scanner;
public class PopularDeck {
    public static Deck criarDeck(){
        Deck deck = new Deck();
        String[] classes = {
                "Blastoise", "Charmander", "Gengar", "Giratina",
                "Mewtho", "Pikachu", "Raychu", "Rayquaza", "Snorlax", "Squirtle", "Taurus", "Zubat"
        };

        for (int i = 0; i < deck.size() ; i++) {
            System.out.println("Lista de pokemons disponiveis:");
            for (int j = 0; j < classes.length; j++) {
                System.out.println((j + 1) + ". " + classes[j]);
            }
            System.out.println("SEU DECK TEM:" + deck.size());
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe o numero do pokemon desejado:");
            int resp = scanner.nextInt();
            InterfaceCarta carta = CartasFactory.cartasFactory(resp);
            deck.addDeck(carta);
        }
        System.out.println("seu deck está Com " +deck.size());
        for (int i = 0; i < deck.size(); i++) {
            InterfaceCarta carta = deck.pegarUm(i);
            System.out.println(carta);
        }
        return deck;
    }

}