package br.com.dio.desafio.dominio;
import java.util.*;

public class Ranking {
        private Set<Dev> rankingDevs = new TreeSet<>();

        public void adicionarDev(Dev dev) {
            rankingDevs.add(dev);
        }

        public List<Dev> getRanking() {
            return new ArrayList<>(rankingDevs);
        }

        public void exibirRanking() {
            System.out.println("=== Ranking dos Devs ===");
            int posicao = 1;
            for (Dev dev : rankingDevs) {
                System.out.println(posicao++ + ". " + dev);
            }
        }
    }

