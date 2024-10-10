package beans.cartas.model;

import beans.cartas.InterfaceCarta;
import beans.cartas.tipos.NomeCarta;

public class CartaGenerica implements InterfaceCarta {

    private NomeCarta nome;
    private int vida;
    private int dano;
    private int defesa;


    public CartaGenerica(NomeCarta nome, int vida, int dano, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
        this.defesa = defesa;
    }

    @Override
    public int dano() {
        return this.dano;
    }

    @Override
    public int vida() {
        return this.vida;
    }

    @Override
    public int defesa() {
        return this.defesa;
    }

    @Override
    public void cartaTipo() {
        System.out.println(this.nome);
    }

    @Override
    public String toString() {
        return
                "nome=" + nome +
                ", vida=" + vida +
                ", dano=" + dano +
                ", defesa=" + defesa;
    }
}
