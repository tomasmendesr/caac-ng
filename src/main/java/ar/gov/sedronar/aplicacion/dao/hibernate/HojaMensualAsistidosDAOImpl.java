package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.HojaMensualAsistidosDAO;
import ar.gov.sedronar.aplicacion.model.HojaMensualAsistidos;

import javax.ejb.Stateless;

/**
 * Created by TMR on 17/09/2018.
 */
@Stateless
@HibernateDAO
public class HojaMensualAsistidosDAOImpl  extends AbstractDAOImpl<HojaMensualAsistidos> implements HojaMensualAsistidosDAO {
}
