package br.com.dio.desafio.dominio.interfaces;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Dev;

public interface Inscricao {
    void inscrever(Dev dev);
    void cancelarInscricao(Dev dev);
}