package beans.cartas.deck;

import beans.cartas.InterfaceCarta;


import java.util.ArrayList;

public class Deck implements InterfaceCarta {

    private ArrayList<InterfaceCarta> deck;

    public Deck() {
        this.deck = new ArrayList<>();
    }

    public int size(){
        return this.deck.size();
    }
    public boolean isEmpty() {
        return this.deck.isEmpty();
    }

    public void addDeck(InterfaceCarta carta) {
        deck.add(carta);
    }
    public void removeDeck(InterfaceCarta carta) {
        deck.remove(carta);
    }

    public InterfaceCarta pegarUm(int i){
        return deck.get(i);
    }
    @Override
    public int dano() {
        int dano = 0;
        for (int i = 0; i < deck.size() ; i++) {
            dano += this.deck.get(i).dano();
        }
        return dano;
    }

    @Override
    public int vida() {
        int vida = 0;
        for (int i = 0; i < deck.size(); i++) {
            InterfaceCarta carta = deck.get(i);
            vida += carta.vida();
        }
        return vida;
    }
    @Override
    public int defesa() {
        int def = 0;
        for (int i = 0; i < deck.size(); i++) {
            InterfaceCarta carta = deck.get(i);
            def += carta.defesa();
        }
        return def;
    }
    @Override
    public void cartaTipo() {
        for (int i = 0; i < deck.size() ; i++) {
            deck.get(i).cartaTipo();
        }
    }

}
