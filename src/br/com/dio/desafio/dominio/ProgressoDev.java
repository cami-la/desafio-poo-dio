package br.com.dio.desafio.dominio;

public class ProgressoDev implements Runnable {
    private Dev dev;

    public ProgressoDev(Dev dev) {
        this.dev = dev;
    }

    @Override
    public void run() {
        System.out.println("Iniciando progresso para o dev: " + dev.getNome());
        while(!dev.getConteudosInscritos().isEmpty()) {
            dev.progredir();
            System.out.println(dev.getNome() + " progrediu!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Progresso finalizado para: " + dev.getNome() + ". XP Total: " + dev.calcularTotalXp());
    }
}