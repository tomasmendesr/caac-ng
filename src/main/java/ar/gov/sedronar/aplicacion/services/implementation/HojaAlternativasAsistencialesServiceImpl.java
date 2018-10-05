package ar.gov.sedronar.aplicacion.services.implementation;

import ar.gov.sedronar.aplicacion.dao.hibernate.HibernateDAO;
import ar.gov.sedronar.aplicacion.dao.interfaces.HojaAlternativasAsistencialesDAO;
import ar.gov.sedronar.aplicacion.dto.HojaAlternativasAsistencialesDTO;
import ar.gov.sedronar.aplicacion.model.HojaAlternativasAsistenciales;
import ar.gov.sedronar.aplicacion.model.HojaAlternativasAsistencialesId;
import ar.gov.sedronar.aplicacion.services.interfaces.AlternativaAsistencialService;
import ar.gov.sedronar.aplicacion.services.interfaces.HojaAlternativasAsistencialesService;
import ar.gov.sedronar.aplicacion.services.interfaces.UsuarioService;
import ar.gov.sedronar.util.dozer.DozerHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;

/**
 * Created by TMR on 04/10/2018.
 */
@Stateless
@DefaultServiceImpl
@Transactional
public class HojaAlternativasAsistencialesServiceImpl implements HojaAlternativasAsistencialesService{

    @Inject
    @DefaultServiceImpl
    private AlternativaAsistencialService alternativaAsistencialService;

    @Inject
    @HibernateDAO
    private HojaAlternativasAsistencialesDAO hojaAlternativasAsistencialesDAO;

    @Inject
    @UserServiceProvider
    private UsuarioService usuarioService;

    @Override
    public List<HojaAlternativasAsistencialesDTO> findListByHojaId(Long idhoja) {
        List<HojaAlternativasAsistencialesDTO> list = new ArrayList<>();
        List<Integer> idsAlternativas = alternativaAsistencialService.findAll().stream().map(a -> a.getId()).collect(Collectors.toList());
        idsAlternativas.forEach(id -> findAndAddIfExists(idhoja, id,list));
        return list;
    }

    @Override
    public HojaAlternativasAsistenciales findByIdHojaIdAndAltAsisId(Long idHoja, Integer idAltAsist) {
        return hojaAlternativasAsistencialesDAO.findByIdHojaAndIdAlternativaAsistencial(idHoja,idAltAsist);
    }

    @Override
    public void deleteModel(HojaAlternativasAsistenciales hojaAltAsisABorrar) {
        hojaAlternativasAsistencialesDAO.delete(hojaAltAsisABorrar);
    }

    @Override
    public void saveOrUpdate(HojaAlternativasAsistencialesDTO dto) throws Exception {
        if (dto == null) throw new Exception("Error creando la consulta");
        HojaAlternativasAsistenciales model;
        if(dto.getHoja() != null && dto.getAlternativaAsistencial() != null) model = hojaAlternativasAsistencialesDAO.findByIdHojaAndIdAlternativaAsistencial(dto.getHoja().getId(), dto.getAlternativaAsistencial().getId());
        dto.setFum(new Date());
        dto.setUum(usuarioService.getCurrentUsername());
        model = DozerHelper.map(dto, HojaAlternativasAsistenciales.class);
        model.setId(new HojaAlternativasAsistencialesId(dto.getHoja().getId(), dto.getAlternativaAsistencial().getId()));
        hojaAlternativasAsistencialesDAO.merge(model);
    }

    private void findAndAddIfExists(Long idhoja, Integer id, List<HojaAlternativasAsistencialesDTO> list) {
        HojaAlternativasAsistenciales hoja = findByIdHojaIdAndAltAsisId(idhoja,id);
        if(hoja != null) list.add(DozerHelper.map(hoja, HojaAlternativasAsistencialesDTO.class));
    }
}
