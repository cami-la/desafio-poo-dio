package br.com.dio.desafio.dominio;

public class SemConteudoException extends RuntimeException {
    public SemConteudoException(String msg) {
        super(msg);
    }
}