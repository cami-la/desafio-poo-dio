# Desafio Concluído: Aprendendo na Prática Programação Orientada a Objetos

📜 **Conclusão do Projeto e Melhorias Implementadas** 📜

Bem-vindos ao resultado do desafio **APRENDENDO NA PRÁTICA O PARADIGMA DE ORIENTAÇÃO A OBJETOS**, promovido pela plataforma **Digital Innovation One** 💙. Este projeto teve como objetivo aplicar os pilares fundamentais da Programação Orientada a Objetos (POO): **Abstração**, **Encapsulamento**, **Herança** e **Polimorfismo**. Abaixo, detalho as melhorias realizadas no código original e o progresso alcançado.

---

## 💎 Objetivo do Projeto
O objetivo principal foi implementar um sistema que modela o domínio de um **Bootcamp**, utilizando as ferramentas da POO para criar classes como `Bootcamp`, `Course`, `Mentoring` e `Dev`, com relacionamentos definidos e comportamentos encapsulados.

---

## 🛑 Ferramentas

- ✅ Java JDK 21
- ✅ IDE para desenvolvimento VsCode


---

## 🔧 Melhorias Implementadas
Para tornar o projeto mais robusto e acessível, foram realizadas as seguintes alterações no código original:

1. **Refatoração para o Inglês**:
   - Todos os nomes de classes, atributos, métodos e comentários foram traduzidos do português para o inglês, seguindo convenções de nomenclatura em inglês (ex.: `Curso` → `Course`, `Mentoria` → `Mentoring`.
   - Essa mudança melhora a legibilidade para desenvolvedores internacionais e alinha o projeto com padrões globais de desenvolvimento.
   - Exemplo: A classe `Bootcamp` agora possui atributos como `name` e `description` em vez de `nome` e `descrição`.

2. **Inicialização de Construtores**:
   - Todos os construtores das classes foram revisados e inicializados adequadamente.
   - Foram adicionados construtores com parâmetros para inicializar os atributos diretamente na criação dos objetos, garantindo que nenhum objeto seja instanciado com valores nulos ou indefinidos.
   - Exemplo: O construtor da classe `Course` agora inicializa `title`, `description` e `workload` diretamente:
     ```java
     public Course(String title, String description, int workload) {
         this.title = title;
         this.description = description;
         this.workload = workload;
     }
     ```

3. **Melhoria na Legibilidade e Manutenção**:
   - O código foi reorganizado para seguir as melhores práticas de POO, com métodos claros e bem documentados.
   - Uso consistente de modificadores de acesso (`private`, `public`, etc.) para reforçar o encapsulamento.
   


---

## 🧮 Estrutura do Código
O projeto agora possui as seguintes classes principais, todas em inglês:
- **Content** (classe abstrata): Define atributos e métodos comuns para `Course` e `Mentorship`.
- **Course**: Representa um curso com título, descrição e carga horária.
- **Mentoring**: Representa uma mentoria com título, descrição e data.
- **Bootcamp**: Contém uma lista de conteúdos (`Content`) e desenvolvedores inscritos (`Developer`).
- **Dev**: Representa um desenvolvedor que pode se inscrever em um bootcamp e progredir nos conteúdos.

---

## 🤝 Como Contribuir
Este projeto é aberto para contribuições! Sinta-se à vontade para:
- ⭐ Dar um *star* no repositório.
- 🐛 Relatar *issues* ou sugerir melhorias.
- 🍴 Fazer um *fork* para adicionar suas próprias evoluções.

 🚀

---
Arquivo original por disponibilizado com ♥ por [cami-la](https://www.linkedin.com/in/cami-la/ "cami-la").


**Desenvolvido com 💙 por Caroline.**
