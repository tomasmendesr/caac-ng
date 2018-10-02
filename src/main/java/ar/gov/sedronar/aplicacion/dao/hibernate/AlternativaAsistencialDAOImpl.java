package ar.gov.sedronar.aplicacion.dao.hibernate;

import ar.gov.sedronar.aplicacion.dao.interfaces.AlternativaAsistencialDAO;
import ar.gov.sedronar.aplicacion.model.AlternativaAsistencial;

import javax.ejb.Stateless;

/**
 * Created by TMR on 01/10/2018.
 */
@Stateless
@HibernateDAO
public class AlternativaAsistencialDAOImpl extends AbstractDAOImpl<AlternativaAsistencial> implements AlternativaAsistencialDAO {
}
