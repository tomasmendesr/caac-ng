package ar.gov.sedronar.aplicacion.dao.interfaces;

import ar.gov.sedronar.aplicacion.model.Acompaniamiento;

import java.util.List;

/**
 * Created by TMR on 21/09/2018.
 */
public interface AcompaniamientoDAO extends AbstractDAO<Acompaniamiento> {

    List<Acompaniamiento> findByEstablecimiento(String establecimiento);
    List<Acompaniamiento> findByEstablecimientoAndTipo(String establecimiento, String tipo);
}
