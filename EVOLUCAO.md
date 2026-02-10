# 🚀 Evolução do Projeto - Desafio POO DIO

## 📋 Melhorias Implementadas

Este projeto foi evoluído para demonstrar de forma mais completa os **4 Pilares da Programação Orientada a Objetos**.

---

## 🎯 Novas Funcionalidades

### 1️⃣ **Classe Abstrata Pessoa** 
**Pilares aplicados: ABSTRAÇÃO e HERANÇA**

- Criada classe base `Pessoa` com atributos comuns (nome, email)
- `Dev` e `Instrutor` agora herdam de `Pessoa`
- Demonstra reutilização de código e hierarquia de classes

```java
public abstract class Pessoa {
    private String nome;
    private String email;
    // ...
}

public class Dev extends Pessoa { /* ... */ }
public class Instrutor extends Pessoa { /* ... */ }
```

---

### 2️⃣ **Sistema de Níveis para Desenvolvedores**
**Pilares aplicados: ENCAPSULAMENTO e POLIMORFISMO**

- Enum `NivelDev` com 4 níveis: JUNIOR, PLENO, SENIOR, ESPECIALISTA
- Cálculo automático baseado no XP acumulado
- Método `getNivelAtual()` retorna o nível dinâmico do Dev

**Tabela de Níveis:**
| Nível | XP Mínimo |
|-------|-----------|
| Júnior | 0 |
| Pleno | 100 |
| Sênior | 300 |
| Especialista | 500 |

```java
public NivelDev getNivelAtual() {
    return NivelDev.calcularNivel(calcularTotalXp());
}
```

---

### 3️⃣ **Classe Instrutor**
**Pilares aplicados: HERANÇA e POLIMORFISMO**

- Nova classe que representa instrutores
- Instrutores podem ministrar Mentorias
- Relacionamento bidirecional entre `Instrutor` e `Mentoria`

```java
Instrutor instrutor = new Instrutor("Camila", "camila@dio.me", "Java Backend");
instrutor.ministrarMentoria(mentoria);
```

---

### 4️⃣ **Sistema de Certificados**
**Pilares aplicados: ABSTRAÇÃO e ENCAPSULAMENTO**

- Classe `Certificado` emitida ao completar bootcamp
- Código único gerado automaticamente (UUID)
- Registro de data de emissão e XP no momento da certificação
- Método `emitirCertificado()` valida se Dev completou todos os conteúdos

```java
devJoao.emitirCertificado(bootcamp);
// 🎓 Certificado emitido: Certificado{codigo='1051B4C5', ...}
```

---

### 5️⃣ **Validações e Exceptions Customizadas**
**Pilares aplicados: ENCAPSULAMENTO**

- Exception customizada `ValidacaoException`
- Validações no setter de `Bootcamp`:
  - Nome não pode ser vazio e deve ter mínimo 3 caracteres
  - Descrição não pode ser vazia

```java
public void setNome(String nome) {
    validarNome(nome);
    this.nome = nome;
}
```

---

### 6️⃣ **Main Aprimorado**
**Demonstração completa dos conceitos**

- Interface visual melhorada com emojis
- 3 desenvolvedores com cenários diferentes
- Demonstração clara de todos os pilares da POO
- Resumo final mostrando polimorfismo em ação

---

## 🔍 Pilares da POO Demonstrados

### 🔺 **ABSTRAÇÃO**
- Classes modelam conceitos do mundo real (Bootcamp, Dev, Curso, Mentoria, Certificado)
- Classe abstrata `Conteudo` define contrato para diferentes tipos de conteúdo
- Classe abstrata `Pessoa` unifica características comuns

### 🔺 **ENCAPSULAMENTO**
- Todos os atributos são privados
- Acesso controlado via getters/setters
- Validações de negócio protegidas (validarNome, validarDescricao)
- Lógica complexa escondida em métodos (emitirCertificado, calcularNivel)

### 🔺 **HERANÇA**
- `Curso` e `Mentoria` herdam de `Conteudo`
- `Dev` e `Instrutor` herdam de `Pessoa`
- Reutilização de código e especialização de classes

### 🔺 **POLIMORFISMO**
- Método `calcularXp()` implementado diferentemente:
  - **Curso**: `XP_PADRAO * cargaHoraria`
  - **Mentoria**: `XP_PADRAO + 20`
- Coleções de `Conteudo` podem conter `Curso` ou `Mentoria`
- Coleções de `Pessoa` podem conter `Dev` ou `Instrutor`

---

## 📊 Estrutura do Projeto

```
src/
├── Main.java
└── br/com/dio/desafio/dominio/
    ├── Pessoa.java (ABSTRATA)
    ├── Dev.java (herda Pessoa)
    ├── Instrutor.java (herda Pessoa)
    ├── Conteudo.java (ABSTRATA)
    ├── Curso.java (herda Conteudo)
    ├── Mentoria.java (herda Conteudo)
    ├── Bootcamp.java
    ├── Certificado.java
    ├── NivelDev.java (ENUM)
    └── exceptions/
        └── ValidacaoException.java
```

---

## 🎮 Como Executar

### Compilar:
```bash
javac -d out src/Main.java src/br/com/dio/desafio/dominio/*.java src/br/com/dio/desafio/dominio/exceptions/*.java
```

### Executar:
```bash
java -cp out Main
```

---

## 💡 Conceitos Avançados Aplicados

✅ **Classes Abstratas** - Pessoa e Conteudo  
✅ **Enums** - NivelDev  
✅ **Exceptions Customizadas** - ValidacaoException  
✅ **Collections** - Set, LinkedHashSet, HashSet  
✅ **Streams API** - Cálculo de XP  
✅ **Optional** - Progressão de conteúdos  
✅ **LocalDate** - Datas de mentorias e certificados  
✅ **UUID** - Geração de códigos únicos  
✅ **Override** - toString, equals, hashCode  

---

## 🎯 Resultados da Execução

O programa demonstra:
- ✅ Camila progride 2 conteúdos → Nível **PLENO** (120 XP)
- ✅ João completa todo bootcamp → Nível **PLENO** (270 XP) + **Certificado**
- ✅ Maria completa 1 curso avançado → Nível **PLENO** (200 XP)

---

## 👨‍💻 Autor

Projeto desenvolvido como parte do **Desafio POO da Digital Innovation One (DIO)**.

Evoluções implementadas para demonstrar domínio completo dos conceitos de Orientação a Objetos.

---

## 📚 Referências

- [Digital Innovation One](https://web.digitalinnovation.one/)
- [Slides do Projeto Original](https://academiapme-my.sharepoint.com/:p:/g/personal/camila_cavalcante_dio_me/EaXyYOjBaFpZjkxhexMo5EcBKMEEAI5t5aHlsTjnBQJlUw?e=nxdB6C)
