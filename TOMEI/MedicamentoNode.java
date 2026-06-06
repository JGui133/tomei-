class MedicamentoNode {
    String nome;
    String dosagem;
    int intervaloHoras;
    MedicamentoNode proximo;
    MedicamentoNode anterior;

    MedicamentoNode(String nome, String dosagem, int intervaloHoras) {
        this.nome = nome;
        this.dosagem = dosagem;
        this.intervaloHoras = intervaloHoras;
        this.proximo = null;
        this.anterior = null;
    }
}
