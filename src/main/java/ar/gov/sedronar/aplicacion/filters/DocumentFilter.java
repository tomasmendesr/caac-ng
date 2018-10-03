package ar.gov.sedronar.aplicacion.filters;

import ar.gov.sedronar.modulo.commonsModels.dto.TipoDocumentoDTO;

/**
 * Created by TMR on 03/10/2018.
 */
public class DocumentFilter {
    private TipoDocumentoDTO tipoDocumentoDTO;
    private Integer numeroDocumento;

    public TipoDocumentoDTO getTipoDocumentoDTO() {
        return tipoDocumentoDTO;
    }

    public void setTipoDocumentoDTO(TipoDocumentoDTO tipoDocumentoDTO) {
        this.tipoDocumentoDTO = tipoDocumentoDTO;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}
