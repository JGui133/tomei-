# Esboço — TOMEI no Android (mantendo as 3 estruturas)

## Camadas

```
┌─────────────────────────────────────┐
│  UI (Activities / Compose)          │
│  TelaMedicamentos, TelaAlerta, etc. │
└─────────────────┬───────────────────┘
                  │
┌─────────────────▼───────────────────┐
│  Services                           │
│  MedicamentoService, AlertaService, │
│  HistoricoService                   │
└─────────────────┬───────────────────┘
                  │
┌─────────────────▼───────────────────┐
│  Estruturas (port do Java atual)    │
│  ListaMedicamentos, FilaNotificacoes│
│  PilhaHistorico                     │
└─────────────────┬───────────────────┘
                  │
┌─────────────────▼───────────────────┐
│  Room (SQLite) — persistência       │
│  medicamento, lembrete, dose        │
└─────────────────────────────────────┘
```

## Mapeamento estrutura → tela

| Estrutura | Tela Android | Ação do usuário |
|-----------|--------------|-----------------|
| Lista dupla | Carrossel / ViewPager2 de medicamentos | Swipe = `proximo` / `anterior` |
| Fila FIFO | `NotificationManager` + fila em memória | Alerta → Tomei / Soneca / Pular |
| Pilha LIFO | Histórico do dia | Snackbar “Desfazer” remove topo |

## Room (tabelas sugeridas)

- `medicamento(id, nome, dosagem, intervalo_horas)`
- `lembrete(id, medicamento_id, horario, status)` — PENDENTE, ADIADO, DISPARADO
- `dose(id, medicamento_id, instante, caminho_foto)`

Ao abrir o app: carregar medicamentos na **lista**; lembretes do dia na **fila**; doses recentes na **pilha** (ou só pilha em RAM para undo de 5 min).

## Notificações

- `AlarmManager` ou `WorkManager` para horários reais.
- Soneca: `+10 min` com `ZonedDateTime`, reenfileirar na fila (como `adiarNotificacaoSoneca`).
- Substituir `String horario` por `LocalTime` / epoch millis.

## Pacote Kotlin sugerido

```
br.com.tomei
  model/
  structures/   // port direto do Java
  data/         // Room DAO + entities
  ui/
  notifications/
```

## Ordem de implementação

1. Portar as 3 classes para Kotlin (ou manter Java em `structures/`).
2. CRUD de medicamentos + lista na UI.
3. Agendar lembrete e notificação nativa.
4. Registrar dose + foto (câmera) + pilha com undo.
5. Sincronizar fila/pilha com Room ao fechar o app.

O código console atual continua válido como **teste de mesa** das estruturas antes da UI.
