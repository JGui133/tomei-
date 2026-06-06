import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class RegistroDose {
    String medicamento;
    String horario;
    String foto;

    RegistroDose(String medicamento, String caminhoFoto) {
        this.medicamento = medicamento;
        this.foto = caminhoFoto != null ? caminhoFoto : "Nenhuma foto tirada";

        LocalTime agora = LocalTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.horario = agora.format(formatador);
    }
}
