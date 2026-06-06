import java.util.LinkedList;

public class FilaNotificacoes {
    private final LinkedList<Notificacao> fila;

    public FilaNotificacoes() {
        this.fila = new LinkedList<>();
    }

    public void agendarLembrete(String nomeMedicamento, String horario) {
        fila.addLast(new Notificacao(nomeMedicamento, horario));
    }

    public Notificacao dispararNotificacao() {
        if (fila.isEmpty()) {
            System.out.println("⚠️ Fila de notificações vazia.");
            return null;
        }
        return fila.removeFirst();
    }

    public void adiarNotificacaoSoneca(Notificacao notificacao) {
        notificacao.horario = "(Adiado +10min)";
        fila.addLast(notificacao);
        System.out.println("⏰ [Soneca] Alerta de '" + notificacao.medicamento
                + "' foi para o FIM da fila (FIFO).");
    }
}
