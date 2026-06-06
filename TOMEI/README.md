# TOMEI — Controle de medicamentos (protótipo)

Simulação em Java de um app de adesão ao tratamento usando **lista duplamente encadeada**, **fila FIFO** e **pilha LIFO**.

## Estruturas

| Classe | Estrutura | Função |
|--------|-----------|--------|
| `ListaMedicamentos` | Lista dupla encadeada | Cadastro e navegação entre medicamentos |
| `FilaNotificacoes` | Fila (FIFO) | Lembretes e soneca (volta ao fim da fila) |
| `PilhaHistorico` | Pilha (LIFO) | Registro de doses com foto e desfazer |

## Requisitos

- JDK 17 ou superior (testado com JDK 25)

## Compilar e executar

**Forma mais fácil (Windows):** dê duplo clique em `rodar.bat` na pasta TOMEI.

No PowerShell, na pasta do projeto:

```powershell
cd "c:\Users\joaog\OneDrive\Área de Trabalho\TOMEI"
javac --release 17 *.java
java Main
```

**No Cursor / VS Code:** abra a pasta `TOMEI` como workspace (Arquivo → Abrir pasta), instale a extensão **Extension Pack for Java**, depois abra `Main.java` e use **Run Java** (ou F5 com a configuração "TOMEI - Main").

**Code Runner (▶ no canto):** se aparecer `invalid flag: Main.class`, você rodou um arquivo `.class` ou a extensão estava mal configurada. Abra `Main.java` (não `Main.class`) e rode de novo — o `.vscode/settings.json` já compila `*.java` e executa `java Main`.

## Não está rodando? Causas comuns

| Sintoma | Causa | Solução |
|---------|--------|---------|
| `UnsupportedClassVersionError` / versão 70 | `.class` antigos (Java 24+) | `javac --release 17 *.java` de novo |
| `Could not find or load main class Main` | Terminal em outra pasta | `cd` até a pasta TOMEI antes de `java Main` |
| `javac` não é reconhecido | Java não está no PATH | Use o caminho completo do JDK (abaixo) ou instale o JDK |
| Clica ▶ e nada / erro em 1 arquivo | Projeto tem vários `.java` | Compile **todos**: `javac --release 17 *.java` |
| Só aparecem `?` no terminal | Emojis no console Windows | O programa **rodou**; a saída está correta (veja linhas com Dipirona, Vitamina C, etc.) |
| Botão Run sem extensão Java | Cursor não compila Java sozinho | Instale **Extension Pack for Java** ou use `rodar.bat` |

Se `javac` não for reconhecido, use o caminho completo do JDK, por exemplo:

```powershell
& "C:\Program Files\Java\jdk-25.0.2\bin\javac.exe" --release 17 *.java
& "C:\Program Files\Java\jdk-25.0.2\bin\java.exe" Main
```

## Arquivos

- `Main.java` — demonstração do fluxo completo
- `ListaMedicamentos.java`, `MedicamentoNode.java`
- `FilaNotificacoes.java`, `Notificacao.java`
- `PilhaHistorico.java`, `RegistroDose.java`

Os `.class` antigos (Java 24+) podem ser removidos após recompilar com `--release 17`.

## Próximos passos (mobile)

Ver `CHECKLIST-ENTREGA.md` e `ARQUITETURA-MOBILE.md`.
