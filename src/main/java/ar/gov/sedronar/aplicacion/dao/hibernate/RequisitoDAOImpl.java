package ar.gov.sedronar.aplicacion.dao.hibernate;


import ar.gov.sedronar.aplicacion.dao.interfaces.RequisitoDAO;
import ar.gov.sedronar.aplicacion.model.Requisito;

import javax.ejb.Stateless;


@Stateless
@HibernateDAO
public class RequisitoDAOImpl extends AbstractDAOImpl<Requisito> implements RequisitoDAO {


}