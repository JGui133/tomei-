import java.util.ArrayList;

public class PilhaHistorico {
    private final ArrayList<RegistroDose> pilha;

    public PilhaHistorico() {
        this.pilha = new ArrayList<>();
    }

    public void registrarDose(String nomeMedicamento, String caminhoFoto) {
        RegistroDose novoRegistro = new RegistroDose(nomeMedicamento, caminhoFoto);
        pilha.add(novoRegistro);
        System.out.println("📸 [Pilha] Registro com foto de '" + nomeMedicamento + "' empilhado com sucesso.");
    }

    public void desfazerUltimoRegistro() {
        if (pilha.isEmpty()) {
            System.out.println("⚠️ Nada para desfazer, a pilha está vazia.");
            return;
        }

        int indiceTopo = pilha.size() - 1;
        RegistroDose removido = pilha.remove(indiceTopo);
        System.out.println("↩️ [Desfazer/Undo] Registro de '" + removido.medicamento + "' removido do topo da Pilha!");
    }

    public void exibirHistorico() {
        if (pilha.isEmpty()) {
            System.out.println("\n📋 Histórico na Pilha: Vazio.");
            return;
        }

        System.out.println("\n--- 📚 EXIBINDO A PILHA DE HISTÓRICO (LIFO - Topo Primeiro) ---");
        for (int i = pilha.size() - 1; i >= 0; i--) {
            RegistroDose registro = pilha.get(i);
            System.out.println("[TOPO] " + registro.horario + " | " + registro.medicamento
                    + " | Foto: " + registro.foto);
        }
    }
}
