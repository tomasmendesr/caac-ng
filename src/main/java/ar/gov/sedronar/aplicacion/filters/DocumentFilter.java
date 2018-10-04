package ar.gov.sedronar.aplicacion.filters;

import ar.gov.sedronar.modulo.commonsModels.dto.TipoDocumentoDTO;

/**
 * Created by TMR on 03/10/2018.
 */
public class DocumentFilter {
    private TipoDocumentoDTO tipoDocumento;
    private Integer numeroDocumento;

    public TipoDocumentoDTO getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}
