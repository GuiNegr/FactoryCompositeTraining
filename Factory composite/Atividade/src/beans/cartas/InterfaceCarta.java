package beans.cartas;

import beans.cartas.observer.Notififica;
import beans.cartas.tipos.NomeCarta;

import java.io.Serializable;

public interface InterfaceCarta extends Notififica {
    public int dano();
    public int vida();
    public int defesa();
    public void cartaTipo();

}
