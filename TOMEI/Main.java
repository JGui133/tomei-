public class Main {
    public static void main(String[] args) {
        ListaMedicamentos listaMedicamentos = new ListaMedicamentos();
        FilaNotificacoes filaAlertas = new FilaNotificacoes();
        PilhaHistorico pilhaHistorico = new PilhaHistorico();

        System.out.println("=========================================");
        System.out.println("      INICIANDO SISTEMA 'TOMEI?'         ");
        System.out.println("=========================================\n");

        listaMedicamentos.cadastrarMedicamento("Dipirona", "1g", 6);
        listaMedicamentos.cadastrarMedicamento("Vitamina C", "500mg", 24);
        listaMedicamentos.cadastrarMedicamento("Omeprazol", "20mg", 24);
        listaMedicamentos.exibirNavegacaoDetalhada();

        filaAlertas.agendarLembrete("Dipirona", "08:00");
        filaAlertas.agendarLembrete("Vitamina C", "08:05");

        Notificacao alerta1 = filaAlertas.dispararNotificacao();
        if (alerta1 != null) {
            System.out.println("🔔 Alerta tocando: " + alerta1.medicamento + " às " + alerta1.horario);
            filaAlertas.adiarNotificacaoSoneca(alerta1);
        }

        Notificacao alerta2 = filaAlertas.dispararNotificacao();
        if (alerta2 != null) {
            System.out.println("\n🔔 Alerta tocando: " + alerta2.medicamento + " às " + alerta2.horario);
            pilhaHistorico.registrarDose(alerta2.medicamento, "galeria/foto_vit_c.png");
        }

        Notificacao alertaAdiado = filaAlertas.dispararNotificacao();
        if (alertaAdiado != null) {
            System.out.println("\n🔔 Alerta tocando: " + alertaAdiado.medicamento + " às " + alertaAdiado.horario);
            pilhaHistorico.registrarDose(alertaAdiado.medicamento, "galeria/foto_dipirona.png");
        }

        pilhaHistorico.exibirHistorico();

        System.out.println("\n--- 👆 USUÁRIO CLICOU EM 'DESFAZER' ---");
        pilhaHistorico.desfazerUltimoRegistro();
        pilhaHistorico.exibirHistorico();
    }
}
