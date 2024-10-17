package service;

import beans.cartas.observer.Escolhas;
import metodos.Metodos;
import metodos.PopularDeck;
import beans.cartas.InterfaceCarta;
import beans.cartas.deck.Deck;
import  java.util.Random;
import java.util.Scanner;


public class JogoService {

    private Scanner sc;

    public JogoService(){
        sc = new Scanner(System.in);
    }

    public void jogando(){
        PopularDeck popularDeck = new PopularDeck();
        System.out.println("Jogador 1 selecione as cartas do seu deck");
        Deck jogador1 = popularDeck.criarDeck();
        System.out.println("Jogador 2 selecione as cartas do seu deck");
        Deck jogador2 = popularDeck.criarDeck();

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
            System.out.println("JOGADOR 1 QUER TENTAR A SORTE?");
            System.out.println("1 - SIM");
            System.out.println("2 - NAO");
            escolha = sc.nextInt();
            if(escolha == 1){
                acaoObserver(jogador1,jogador2);
            }
            System.out.println("JOGADOR 2 QUER TENTAR A SORTE?");
            System.out.println("1 - SIM");
            System.out.println("2 - NAO");
            escolha = sc.nextInt();
            if(escolha == 1){
                acaoObserver(jogador2,jogador1);
            }

            boolean[] quemGanha = jogoTurnoTrunfo(cartaJogador1,cartaJogador2);

            if (quemGanha[0] && !quemGanha[1]) {
                jogador2.removeDeck(cartaJogador2);
            } else if(quemGanha[1] && !quemGanha[0]) {
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
    }

    public void acaoObserver(Deck jogadorPrimario,Deck jogadorSecundario){
        Random rand = new Random();
        try {
            System.out.println("UMA DAS AÇÕES SERÁ ESCOLHIDA ALEATORIAMENTE");
            System.out.println("1 - ADICIONA MAIS 1 EM TODOS OS ATRIBUTOS");
            System.out.println("2 - ADICIONA MAIS 10  EM TODOS OS ATRIBUTOS");
            System.out.println("3 - REMOVE 1 CARTA DO DECK ADVERSARIO");
            System.out.println("4 - ADICIONA MAIS UMA CARTA NO SEU DECK");
            Thread.sleep(2000);
            int random = rand.nextInt(50);

            if(random > 0 && random < 10){
                System.out.println("FOI ESCOLHIDO AUMENTAR EM 1 ");
                jogadorPrimario.notificar(Escolhas.AUEMNTAREM1);
            }else if(random > 11 && random < 20){
                System.out.println("FOI ESCOLHIDO AUMENTAR EM 10");
                jogadorPrimario.notificar(Escolhas.AUEMNTAREM10);
            }else if(random > 21 && random < 30){
                System.out.println("FOI ESCOLHIDO REMOVER 1 CARTA DO DECK");
                jogadorSecundario.notificar(Escolhas.REMOVERADVERSARIO);
            }else {
                System.out.println("FOI ESCOLHIDO ADICIONAR MAIS UMA CARTA NO SEU DECK");
                jogadorPrimario.notificar(Escolhas.PEGARMAISUMA);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean[] jogoTurnoTrunfo(InterfaceCarta cartaJogador1, InterfaceCarta cartaJogador2){
        sc = new Scanner(System.in);
        System.out.println("Escolha o atributo a ser comparado: 1)Vida 2)Dano 3)Defesa ");
        int escolhaAtributo = sc.nextInt();

        boolean[] vitorias = new boolean[2];

        switch (escolhaAtributo) {
            case 1:
                if (cartaJogador1.vida() > cartaJogador2.vida()) {
                    System.out.println("Jogador 1 venceu esta rodada com Vida: " + cartaJogador1.vida());
                    vitorias[0] = true;
                    vitorias[1] = false;
                } else if (cartaJogador1.vida() < cartaJogador2.vida()) {
                    System.out.println("Jogador 2 venceu esta rodada com Vida: " + cartaJogador2.vida());
                    vitorias[0] = false;
                    vitorias[1] = true;
                } else {
                    System.out.println("Empate nesta rodada!");
                    vitorias[0] = false;
                    vitorias[1] = false;
                }
                break;
            case 2:
                if (cartaJogador1.dano() > cartaJogador2.dano()) {
                    System.out.println("Jogador 1 venceu esta rodada com Dano: " + cartaJogador1.dano());
                    vitorias[0] = true;
                    vitorias[1] = false;
                } else if (cartaJogador1.dano() < cartaJogador2.dano()) {
                    System.out.println("Jogador 2 venceu esta rodada com Dano: " + cartaJogador2.dano());
                    vitorias[0] = false;
                    vitorias[1] = true;
                } else {
                    System.out.println("Empate nesta rodada!");
                    vitorias[0] = false;
                    vitorias[1] = false;
                }
                break;
            case 3:
                if (cartaJogador1.defesa() > cartaJogador2.defesa()) {
                    System.out.println("Jogador 1 venceu esta rodada com Defesa: " + cartaJogador1.defesa());
                    vitorias[0] = true;
                    vitorias[1] = false;
                } else if (cartaJogador1.defesa() < cartaJogador2.defesa()) {
                    System.out.println("Jogador 2 venceu esta rodada com Defesa: " + cartaJogador2.defesa());
                    vitorias[0] = false;
                    vitorias[1] = true;
                } else {
                    System.out.println("Empate nesta rodada!");
                    vitorias[0] = false;
                    vitorias[1] = false;
                }
                break;
            default:
                System.out.println("Atributo inválido! Tente novamente.");
        }
        return vitorias;
    }
}


