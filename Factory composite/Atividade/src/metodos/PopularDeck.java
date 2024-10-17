package metodos;
import java.util.Random;
import beans.cartas.factory.CartasFactory;
import beans.cartas.InterfaceCarta;
import beans.cartas.deck.Deck;

import java.util.Scanner;
public class PopularDeck implements PopularInterface {

    private static String[] classes = {
            "Blastoise", "Charmander", "Gengar", "Giratina",
            "Mewtho", "Pikachu", "Raychu", "Rayquaza", "Snorlax", "Squirtle", "Taurus", "Zubat"
    };

    public Deck criarDeck(){
        Deck deck = new Deck();
        for (int i = 0; i < 6; i++) {
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
        Metodos.mostrarAtributos(deck);
        return deck;
    }

    public InterfaceCarta devolverCarta(){
        Random rand = new Random(classes.length);
        InterfaceCarta carta = CartasFactory.cartasFactory(rand.nextInt(classes.length));
        return carta;
    }
}