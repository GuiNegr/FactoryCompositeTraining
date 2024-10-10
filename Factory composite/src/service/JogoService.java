package service;

import Metodos.Metodos;
import Metodos.PopularDeck;
import beans.cartas.InterfaceCarta;
import beans.cartas.deck.Deck;

import java.util.Scanner;


public class JogoService {

    static Scanner sc = new Scanner(System.in);

    public void jogando(){
        System.out.println("Jogador 1 selecione as cartas do seu deck");
        Deck jogador1 = PopularDeck.criarDeck();
        System.out.println("Jogador 2 selecione as cartas do seu deck");
        Deck jogador2 = PopularDeck.criarDeck();

        System.out.println("Vamos iniciar o jogo");

        boolean jogoativo = true;
        int turno = 1;

        while (jogoativo) {
            Metodos.mostrarAtributos(jogador1);
            System.out.println("Jogador 1 Escolha a carta: ");
            int escolha = sc.nextInt();
            InterfaceCarta cartaJogador1 = jogador1.pegarUm(escolha);

            Metodos.mostrarAtributos(jogador2);
            System.out.println("Jogador 2 Escolha a carta:");
            escolha = sc.nextInt();
            InterfaceCarta cartaJogador2 = jogador1.pegarUm(escolha);

            System.out.println("Escolha o atributo a ser comparado: 1)Vida 2)Dano 3)Defesa ");
            int escolhaAtributo = sc.nextInt();

            boolean jogador1Venceu = false;

            switch (escolhaAtributo) {
                case 1:
                    if (cartaJogador1.vida() > cartaJogador2.vida()) {
                        System.out.println("Jogador 1 venceu esta rodada com Vida: " + cartaJogador1.vida());
                        jogador1Venceu = true;
                    } else if (cartaJogador1.vida() < cartaJogador2.vida()) {
                        System.out.println("Jogador 2 venceu esta rodada com Vida: " + cartaJogador2.vida());
                    } else {
                        System.out.println("Empate nesta rodada!");
                    }
                    break;
                case 2:
                    if (cartaJogador1.dano() > cartaJogador2.dano()) {
                        System.out.println("Jogador 1 venceu esta rodada com Dano: " + cartaJogador1.dano());
                        jogador1Venceu = true;
                    } else if (cartaJogador1.dano() < cartaJogador2.dano()) {
                        System.out.println("Jogador 2 venceu esta rodada com Dano: " + cartaJogador2.dano());
                    } else {
                        System.out.println("Empate nesta rodada!");
                    }
                    break;
                case 3:
                    if (cartaJogador1.defesa() > cartaJogador2.defesa()) {
                        System.out.println("Jogador 1 venceu esta rodada com Defesa: " + cartaJogador1.defesa());
                        jogador1Venceu = true;
                    } else if (cartaJogador1.defesa() < cartaJogador2.defesa()) {
                        System.out.println("Jogador 2 venceu esta rodada com Defesa: " + cartaJogador2.defesa());
                    } else {
                        System.out.println("Empate nesta rodada!");
                    }
                    break;
                default:
                    System.out.println("Atributo inválido! Tente novamente.");
                    continue;
            }

            if (jogador1Venceu) {
                jogador2.removeDeck(cartaJogador2);
            } else {
                jogador1.removeDeck(cartaJogador1);
            }

            if (jogador1.isEmpty()) {
                System.out.println("Jogador 2 venceu! Todas as cartas do Jogador 1 foram removidas.");
                jogoativo = false;
            } else if (jogador2.isEmpty()) {
                System.out.println("Jogador 1 venceu! Todas as cartas do Jogador 2 foram removidas.");
                jogoativo = false;
            }
            turno++;
        }
        System.out.println("Jogo encerrado. Obrigado por jogar!");
    }
}


