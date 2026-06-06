# Checklist — entrega acadêmica (TOMEI)

## Obrigatório no relatório

- [ ] **Objetivo**: app para controle de medicamentos, adesão e horários.
- [ ] **Diagrama** das três estruturas (lista dupla, fila, pilha) com setas `proximo` / `anterior`, `addLast` / `removeFirst`, `push` / `pop`.
- [ ] **Complexidade** (tempo médio): cadastro O(1), disparar alerta O(1), desfazer O(1), navegação O(n).
- [ ] **Justificativa** de cada estrutura no domínio (ver README).
- [ ] **Captura de tela** da saída do `java Main`.
- [ ] **Limitações**: protótipo console; horários como texto; sem persistência; mobile futuro.

## Demonstração na apresentação

1. Cadastro de 3 medicamentos e navegação bidirecional.
2. Dois alertas na fila → primeiro com soneca (volta ao fim).
3. Registro de dose com “caminho da foto”.
4. Histórico LIFO e botão **Desfazer**.

## Melhorias mínimas (se o professor pedir evolução)

- [ ] Usar `intervaloHoras` para gerar horários do dia (método `gerarLembretesDoDia()`).
- [ ] Comentário no código explicando FIFO vs fila de prioridade por horário.
- [ ] Um teste manual documentado: pilha vazia + desfazer → mensagem de erro.

## Não confundir com app final

Este projeto **prova estruturas de dados**. App mobile real exige UI, banco e notificações do SO — ver `ARQUITETURA-MOBILE.md`.
