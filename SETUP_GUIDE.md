# 🔧 Guia de Configuração do Projeto - Testes Unitários

## Passo a Passo para Configurar no IntelliJ IDEA

### 📁 Passo 1: Marcar a pasta `test` como Test Sources Root

1. No painel **Project** (à esquerda), localize a pasta `test`
2. Clique com o **botão direito** na pasta `test`
3. Selecione: `Mark Directory as` → `Test Sources Root`
4. A pasta ficará **verde** indicando que é pasta de testes

---

### 📚 Passo 2: Adicionar a biblioteca JUnit 5 ao projeto

1. Vá em: `File` → `Project Structure...` (ou pressione `Ctrl + Alt + Shift + S`)
2. No menu lateral esquerdo, selecione **Libraries**
3. Clique no ícone **+** (Add)
4. Selecione **Java**
5. Navegue até a pasta `lib` do projeto
6. Selecione o arquivo: `junit-platform-console-standalone-1.10.1.jar`
7. Clique em **OK**
8. Na janela que aparecer, clique em **OK** novamente
9. Clique em **Apply** e depois **OK**

---

### ▶️ Passo 3: Executar os testes

#### Opção 1: Executar todos os testes da classe
1. Abra o arquivo `DevTest.java` (está em `test/br/com/dio/desafio/dominio/`)
2. Clique com o **botão direito** no nome da classe `DevTest`
3. Selecione: `Run 'DevTest'`
4. Os resultados aparecerão na janela **Run** na parte inferior

#### Opção 2: Executar um teste específico
1. Abra o arquivo `DevTest.java`
2. Localize o método de teste que deseja executar (ex: `deveInscreverDevEmBootcamp`)
3. Clique no ícone **▶** verde ao lado do método
4. Selecione `Run 'deveInscreverDevEmBootcamp()'`

#### Opção 3: Executar com cobertura de código
1. Clique com o **botão direito** na classe `DevTest`
2. Selecione: `Run 'DevTest' with Coverage`
3. Veja a porcentagem de código testado

---

### ✅ Verificando se está tudo funcionando

Após executar os testes, você verá:
- **✓ Verde**: Teste passou com sucesso
- **✗ Vermelho**: Teste falhou
- **Número total**: Quantidade de testes executados

**Resultado esperado:** Todos os 16 testes devem passar (16/16) ✓

---

### ⚠️ Solução de Problemas

#### Problema: "Cannot resolve symbol 'org.junit'"
**Solução:** Certifique-se de que adicionou a biblioteca JUnit no Passo 2

#### Problema: "Java file is located outside of the module source root"
**Solução:** Marque a pasta `test` como Test Sources Root (Passo 1)

#### Problema: Testes não aparecem para executar
**Solução:** 
1. Faça Rebuild do projeto: `Build` → `Rebuild Project`
2. Invalide o cache: `File` → `Invalidate Caches / Restart...`

---

### 🎯 Próximos Passos

Depois de configurar e executar com sucesso:
1. ✅ Revise as melhorias no código (método `progredir()` e `calcularTotalXp()`)
2. ✅ Leia os JavaDocs adicionados na classe `Dev`
3. ✅ Explore cada teste para entender o que está sendo validado
4. ✅ Tente criar seus próprios testes para outras classes (Bootcamp, Curso, Mentoria)

---

## 📝 Estrutura do Projeto

```
desafio-poo-dio/
├── lib/
│   └── junit-platform-console-standalone-1.10.1.jar  ← Biblioteca JUnit
├── src/
│   ├── Main.java
│   └── br/com/dio/desafio/dominio/
│       ├── Bootcamp.java
│       ├── Conteudo.java
│       ├── Curso.java
│       ├── Dev.java                                  ← Classe melhorada
│       └── Mentoria.java
├── test/                                             ← Pasta de testes
│   └── br/com/dio/desafio/dominio/
│       └── DevTest.java                             ← Testes unitários
├── README_TESTS.md                                   ← Documentação dos testes
└── SETUP_GUIDE.md                                    ← Este arquivo
```

---

**Dúvidas?** Revise cada passo com calma. A configuração leva apenas alguns minutos! 🚀

