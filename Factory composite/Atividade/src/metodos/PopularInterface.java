package metodos;

import beans.cartas.InterfaceCarta;
import beans.cartas.deck.Deck;

public interface PopularInterface {
    Deck criarDeck();
    InterfaceCarta devolverCarta();
}
