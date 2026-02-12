package br.com.dio.desafio.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes unitários para a classe Dev.
 *
 * @author DIO - Digital Innovation One
 * @version 1.0
 */
@DisplayName("Testes da classe Dev")
class DevTest {

    private Dev dev;
    private Bootcamp bootcamp;
    private Curso curso1;
    private Curso curso2;
    private Mentoria mentoria;

    @BeforeEach
    void setUp() {
        // Inicializa o desenvolvedor
        dev = new Dev();
        dev.setNome("João Silva");

        // Inicializa o bootcamp
        bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Aprenda Java do zero ao avançado");

        // Cria cursos
        curso1 = new Curso();
        curso1.setTitulo("Java Básico");
        curso1.setDescricao("Fundamentos de Java");
        curso1.setCargaHoraria(8);

        curso2 = new Curso();
        curso2.setTitulo("Java POO");
        curso2.setDescricao("Programação Orientada a Objetos em Java");
        curso2.setCargaHoraria(10);

        // Cria mentoria
        mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria Java");
        mentoria.setDescricao("Tire suas dúvidas sobre Java");
        mentoria.setData(LocalDate.now());

        // Adiciona conteúdos ao bootcamp
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);
    }

    @Test
    @DisplayName("Deve inscrever Dev em Bootcamp com sucesso")
    void deveInscreverDevEmBootcamp() {
        // When
        dev.inscreverBootcamp(bootcamp);

        // Then
        assertEquals(3, dev.getConteudosInscritos().size(),
                "Dev deve ter 3 conteúdos inscritos");
        assertTrue(bootcamp.getDevsInscritos().contains(dev),
                "Bootcamp deve conter o Dev na lista de inscritos");
        assertEquals(0, dev.getConteudosConcluidos().size(),
                "Dev não deve ter conteúdos concluídos inicialmente");
    }

    @Test
    @DisplayName("Deve verificar se conteúdos foram adicionados corretamente")
    void deveAdicionarConteudosCorretos() {
        // When
        dev.inscreverBootcamp(bootcamp);

        // Then
        assertTrue(dev.getConteudosInscritos().contains(curso1),
                "Deve conter curso1");
        assertTrue(dev.getConteudosInscritos().contains(curso2),
                "Deve conter curso2");
        assertTrue(dev.getConteudosInscritos().contains(mentoria),
                "Deve conter mentoria");
    }

    @Test
    @DisplayName("Deve progredir um conteúdo com sucesso")
    void deveProgredirConteudo() {
        // Given
        dev.inscreverBootcamp(bootcamp);
        int conteudosInscritosInicial = dev.getConteudosInscritos().size();

        // When
        dev.progredir();

        // Then
        assertEquals(conteudosInscritosInicial - 1, dev.getConteudosInscritos().size(),
                "Deve ter um conteúdo a menos inscrito");
        assertEquals(1, dev.getConteudosConcluidos().size(),
                "Deve ter um conteúdo concluído");
    }

    @Test
    @DisplayName("Deve progredir múltiplos conteúdos")
    void deveProgredirMultiplosConteudos() {
        // Given
        dev.inscreverBootcamp(bootcamp);

        // When
        dev.progredir(); // Conclui primeiro conteúdo
        dev.progredir(); // Conclui segundo conteúdo

        // Then
        assertEquals(1, dev.getConteudosInscritos().size(),
                "Deve ter 1 conteúdo inscrito restante");
        assertEquals(2, dev.getConteudosConcluidos().size(),
                "Deve ter 2 conteúdos concluídos");
    }

    @Test
    @DisplayName("Não deve gerar erro ao progredir sem conteúdos inscritos")
    void naoDeveGerarErroAoProgredirSemConteudos() {
        // When & Then
        assertDoesNotThrow(() -> dev.progredir(),
                "Não deve lançar exceção ao progredir sem conteúdos");
        assertEquals(0, dev.getConteudosConcluidos().size(),
                "Não deve ter conteúdos concluídos");
    }

    @Test
    @DisplayName("Deve calcular XP total corretamente")
    void deveCalcularXpTotal() {
        // Given
        dev.inscreverBootcamp(bootcamp);

        // When
        dev.progredir(); // Conclui curso1 (8h * 10 XP = 80 XP)
        dev.progredir(); // Conclui curso2 (10h * 10 XP = 100 XP)
        dev.progredir(); // Conclui mentoria (10 + 20 = 30 XP)

        double xpEsperado = (8 * 10) + (10 * 10) + (10 + 20); // 80 + 100 + 30 = 210

        // Then
        assertEquals(xpEsperado, dev.calcularTotalXp(), 0.01,
                "XP total deve ser calculado corretamente");
    }

    @Test
    @DisplayName("Deve retornar XP zero quando não houver conteúdos concluídos")
    void deveRetornarXpZeroSemConteudosConcluidos() {
        // When
        double xpTotal = dev.calcularTotalXp();

        // Then
        assertEquals(0.0, xpTotal, "XP deve ser zero sem conteúdos concluídos");
    }

    @Test
    @DisplayName("Deve calcular XP parcial corretamente")
    void deveCalcularXpParcial() {
        // Given
        dev.inscreverBootcamp(bootcamp);

        // When
        dev.progredir(); // Conclui apenas curso1

        double xpEsperado = 8 * 10; // 80 XP

        // Then
        assertEquals(xpEsperado, dev.calcularTotalXp(), 0.01,
                "XP parcial deve ser calculado corretamente");
    }

    @Test
    @DisplayName("Deve manter integridade entre inscritos e concluídos")
    void deveManterIntegridadeEntreInscritosEConcluidos() {
        // Given
        dev.inscreverBootcamp(bootcamp);
        int totalConteudos = bootcamp.getConteudos().size();

        // When
        dev.progredir();
        dev.progredir();

        // Then
        assertEquals(totalConteudos,
                dev.getConteudosInscritos().size() + dev.getConteudosConcluidos().size(),
                "Soma de inscritos e concluídos deve ser igual ao total de conteúdos");
    }

    @Test
    @DisplayName("Deve garantir que conteúdo concluído não está mais inscrito")
    void deveGarantirQueConteudoConcluidoNaoEstaMaisInscrito() {
        // Given
        dev.inscreverBootcamp(bootcamp);

        // When
        dev.progredir();

        // Then
        dev.getConteudosConcluidos().forEach(conteudoConcluido ->
                assertFalse(dev.getConteudosInscritos().contains(conteudoConcluido),
                        "Conteúdo concluído não deve estar na lista de inscritos"));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Deve progredir N vezes corretamente")
    void deveProgredirNVezes(int numeroDeProgressoes) {
        // Given
        dev.inscreverBootcamp(bootcamp);
        int totalConteudos = bootcamp.getConteudos().size();

        // When
        for (int i = 0; i < numeroDeProgressoes; i++) {
            dev.progredir();
        }

        // Then
        int progressoEsperado = Math.min(numeroDeProgressoes, totalConteudos);
        assertEquals(progressoEsperado, dev.getConteudosConcluidos().size(),
                "Deve ter progredido " + progressoEsperado + " conteúdo(s)");
    }

    @Test
    @DisplayName("Deve manter o nome do Dev correto")
    void deveManterNomeCorreto() {
        // When
        String nome = dev.getNome();

        // Then
        assertEquals("João Silva", nome, "Nome do Dev deve estar correto");
    }

    @Test
    @DisplayName("Deve permitir atualizar nome do Dev")
    void devePermitirAtualizarNome() {
        // When
        dev.setNome("Maria Santos");

        // Then
        assertEquals("Maria Santos", dev.getNome(),
                "Nome do Dev deve ser atualizado");
    }

    @Test
    @DisplayName("Deve verificar equals e hashCode")
    void deveVerificarEqualsEHashCode() {
        // Given
        Dev dev1 = new Dev();
        dev1.setNome("João");

        Dev dev2 = new Dev();
        dev2.setNome("João");

        // Then
        assertEquals(dev1, dev2, "Devs com mesmo nome devem ser iguais");
        assertEquals(dev1.hashCode(), dev2.hashCode(),
                "Devs iguais devem ter mesmo hashCode");
    }
}

