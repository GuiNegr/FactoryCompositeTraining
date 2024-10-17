package beans.cartas.model;

import beans.cartas.InterfaceCarta;
import beans.cartas.observer.Escolhas;
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

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public NomeCarta getNome() {
        return nome;
    }

    public void setNome(NomeCarta nome) {
        this.nome = nome;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    @Override
    public void notificar(Escolhas escolhas) {
        System.out.println("carta generica sem ação");
    }
}
