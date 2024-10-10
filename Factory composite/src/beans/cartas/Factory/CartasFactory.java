package beans.cartas.Factory;

import beans.cartas.InterfaceCarta;
import beans.cartas.model.*;
import beans.cartas.tipos.NomeCarta;

public class CartasFactory {
    public static InterfaceCarta cartasFactory(int i){
        InterfaceCarta interfaceCarta = switch (i){
            default -> new CartaGenerica(NomeCarta.RAYQUAZA,20,10,20);
            case 1 -> new Pikachu();
            case 2 -> new Blastoise();
            case 3 -> new Charmander();
            case 4 -> new Gengar();
            case 5 -> new Geratina();
            case 6 -> new Mewtho();
            case 7 -> new Rayquaza();
            case 8 -> new Snorlax();
            case 9 -> new Squirtle();
            case 10 -> new Taurus();
            case 11 -> new Zubat();
        };
        return interfaceCarta;
    }
}
