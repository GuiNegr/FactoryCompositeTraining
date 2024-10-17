package beans.cartas.model;

import beans.cartas.observer.Escolhas;
import beans.cartas.observer.Notififica;
import beans.cartas.tipos.NomeCarta;

public class Mewtho extends CartaGenerica implements Notififica {
    public Mewtho() {
        super(NomeCarta.MEWTWO, 500, 150, 200);
    }
    @Override
    public void notificar(Escolhas escolhas) {
        switch (escolhas){
            case AUEMNTAREM1:
                setDano(this.dano() + 1);
                setDefesa(defesa() + 1);
                setVida(vida() + 1);
                break;
            case AUEMNTAREM10:
                setDano(dano() + 10);
                setDefesa(defesa() + 10);
                setVida(vida() + 10);
                break;
        }
    }
}
