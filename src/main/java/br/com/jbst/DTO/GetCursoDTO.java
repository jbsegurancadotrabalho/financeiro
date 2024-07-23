package br.com.jbst.DTO;

import java.time.Instant;
import java.util.UUID;

import lombok.Data;

@Data
public class GetCursoDTO {
    private UUID idcurso;
	private String curso;
	private String status;
	private String descricao;

}
