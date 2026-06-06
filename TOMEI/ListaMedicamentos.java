public class ListaMedicamentos {
    private MedicamentoNode head;
    private MedicamentoNode tail;

    public ListaMedicamentos() {
        this.head = null;
        this.tail = null;
    }

    public void cadastrarMedicamento(String nome, String dosagem, int intervaloHoras) {
        MedicamentoNode novoNo = new MedicamentoNode(nome, dosagem, intervaloHoras);

        if (head == null) {
            head = novoNo;
            tail = novoNo;
        } else {
            tail.proximo = novoNo;
            novoNo.anterior = tail;
            tail = novoNo;
        }

        System.out.println("💊 [Cadastro] '" + nome + "' guardado na Lista Duplamente Encadeada.");
    }

    public void exibirNavegacaoDetalhada() {
        if (head == null) {
            System.out.println("Nenhum medicamento na lista.");
            return;
        }

        System.out.println("\n--- 🔄 NAVEGAÇÃO BIDIRECIONAL (Simulando passagem de telas) ---");
        System.out.print("Indo para frente (.proximo):");

        MedicamentoNode atual = head;
        MedicamentoNode ultimoNo = head;

        while (atual != null) {
            System.out.print(" -> [ " + atual.nome + " ]");
            if (atual.proximo == null) {
                ultimoNo = atual;
            }
            atual = atual.proximo;
        }

        System.out.print("\nVoltando para trás (.anterior):");
        atual = ultimoNo;

        while (atual != null) {
            System.out.print(" <- [ " + atual.nome + " ]");
            atual = atual.anterior;
        }

        System.out.println();
    }
}
