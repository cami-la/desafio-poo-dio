package br.com.dio.desafio.dominio.exceptions;

/**
 * Exception customizada para erros de validação
 * Demonstra ABSTRAÇÃO: modelagem de erros específicos do domínio
 */
public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String mensagem) {
        super(mensagem);
    }

    public ValidacaoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
