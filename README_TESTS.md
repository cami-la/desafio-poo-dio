# Testes Unitários - Desafio POO DIO

## 📋 Sobre

Este documento descreve os testes unitários implementados para a classe `Dev` do projeto Desafio POO DIO.

## 🧪 Tecnologias Utilizadas

- **JUnit 5** (v5.10.1) - Framework de testes unitários
- **Maven** - Gerenciamento de dependências

## 📦 Estrutura de Testes

Os testes estão localizados em:
```
test/br/com/dio/desafio/dominio/DevTest.java
```

## ✅ Casos de Teste Implementados

### 1. Testes de Inscrição em Bootcamp
- ✓ **deveInscreverDevEmBootcamp**: Verifica se o Dev é inscrito corretamente no bootcamp
- ✓ **deveAdicionarConteudosCorretos**: Valida se todos os conteúdos foram adicionados

### 2. Testes de Progresso
- ✓ **deveProgredirConteudo**: Verifica se o Dev progride um conteúdo com sucesso
- ✓ **deveProgredirMultiplosConteudos**: Valida progressão de múltiplos conteúdos
- ✓ **naoDeveGerarErroAoProgredirSemConteudos**: Testa comportamento quando não há conteúdos
- ✓ **deveProgredirNVezes**: Teste parametrizado para N progressões

### 3. Testes de Cálculo de XP
- ✓ **deveCalcularXpTotal**: Verifica o cálculo correto do XP total
- ✓ **deveRetornarXpZeroSemConteudosConcluidos**: Valida XP inicial
- ✓ **deveCalcularXpParcial**: Testa XP com conclusão parcial

### 4. Testes de Integridade
- ✓ **deveManterIntegridadeEntreInscritosEConcluidos**: Valida que o total de conteúdos se mantém
- ✓ **deveGarantirQueConteudoConcluidoNaoEstaMaisInscrito**: Verifica não duplicação

### 5. Testes de Propriedades
- ✓ **deveManterNomeCorreto**: Verifica getter do nome
- ✓ **devePermitirAtualizarNome**: Verifica setter do nome
- ✓ **deveVerificarEqualsEHashCode**: Valida métodos equals e hashCode

## 🚀 Como Executar os Testes

### Configuração Inicial no IntelliJ IDEA

1. **Marcar pasta de testes:**
   - Clique com botão direito na pasta `test`
   - Selecione `Mark Directory as` > `Test Sources Root`

2. **Adicionar biblioteca JUnit:**
   - Vá em `File` > `Project Structure` > `Libraries`
   - Clique no `+` e selecione `Java`
   - Navegue até a pasta `lib` e selecione o arquivo `junit-platform-console-standalone-1.10.1.jar`
   - Clique `OK`

3. **Executar os testes:**
   - Clique com o botão direito na classe `DevTest`
   - Selecione `Run 'DevTest'`
   - Visualize os resultados na janela de testes

### Via Linha de Comando (PowerShell)

```powershell
# Compilar código fonte
javac -d out/production/desafio-poo-dio src/Main.java src/br/com/dio/desafio/dominio/*.java

# Compilar testes
javac -d out/test/desafio-poo-dio -cp "out/production/desafio-poo-dio;lib/junit-platform-console-standalone-1.10.1.jar" test/br/com/dio/desafio/dominio/DevTest.java

# Executar testes
java -jar lib/junit-platform-console-standalone-1.10.1.jar --class-path "out/production/desafio-poo-dio;out/test/desafio-poo-dio" --scan-class-path
```

## 📊 Cobertura de Testes

Os testes cobrem:
- ✅ Métodos públicos da classe Dev (100%)
- ✅ Casos de sucesso
- ✅ Casos limites (edge cases)
- ✅ Validação de integridade de dados

## 🔧 Melhorias Implementadas

### 1. Refatoração do método `progredir()`
**Antes:**
```java
public void progredir() {
    Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
    if(conteudo.isPresent()) {
        this.conteudosConcluidos.add(conteudo.get());
        this.conteudosInscritos.remove(conteudo.get());
    } else {
        System.err.println("Você não está matriculado em nenhum conteúdo!");
    }
}
```

**Depois:**
```java
public void progredir() {
    this.conteudosInscritos.stream()
            .findFirst()
            .ifPresentOrElse(
                    conteudo -> {
                        this.conteudosConcluidos.add(conteudo);
                        this.conteudosInscritos.remove(conteudo);
                    },
                    () -> System.err.println("Você não está matriculado em nenhum conteúdo!")
            );
}
```

### 2. Refatoração do método `calcularTotalXp()`
**Antes:**
```java
public double calcularTotalXp() {
    Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
    double soma = 0;
    while(iterator.hasNext()){
        double next = iterator.next().calcularXp();
        soma += next;
    }
    return soma;
}
```

**Depois:**
```java
public double calcularTotalXp() {
    return this.conteudosConcluidos
            .stream()
            .mapToDouble(Conteudo::calcularXp)
            .sum();
}
```

### 3. Adição de JavaDoc
Documentação completa da classe e seus métodos públicos.

## 🎯 Benefícios

1. **Confiabilidade**: Testes garantem que o código funciona conforme esperado
2. **Manutenibilidade**: Facilita refatorações futuras
3. **Documentação**: Testes servem como documentação executável
4. **Qualidade**: Aproxima o projeto de padrões profissionais
5. **Regressão**: Previne bugs ao adicionar novas funcionalidades

## 📝 Convenções Utilizadas

- Nomenclatura de testes em português (por consistência com o código)
- Padrão **Given-When-Then** (Arrange-Act-Assert) comentado quando aplicável
- Uso de `@DisplayName` para descrições legíveis
- Assertions com mensagens descritivas

## 🤝 Contribuição

Este PR demonstra boas práticas de desenvolvimento Java:
- ✅ Testes unitários abrangentes
- ✅ Código limpo e idiomático
- ✅ Documentação com JavaDoc
- ✅ Uso adequado de Streams API
- ✅ Uso adequado de Optional

---

**Autor**: Contribuição da comunidade DIO  
**Data**: Fevereiro 2026  
**Versão**: 1.0

