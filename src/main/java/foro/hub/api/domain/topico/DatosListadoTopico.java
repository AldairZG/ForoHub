package foro.hub.api.domain.topico;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DatosListadoTopico(String titulo,
                                 String mensaje,
                                 LocalDateTime fecha,
                                 Integer status,
                                 String autor,
                                 String curso) {

    public DatosListadoTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFecha(), topico.getStatus(),
                topico.getAutor(), topico.getCurso());
    }

}
