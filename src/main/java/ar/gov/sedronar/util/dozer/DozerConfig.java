package ar.gov.sedronar.util.dozer;

import org.dozer.DozerBeanMapper;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

//import ar.gov.modernizacion.pdoe.backend.dao.hibernate.AuditoriaInterceptor;


@Startup
@Singleton
public class DozerConfig {
//	@Inject
//	AuditoriaInterceptor interceptor;
	
	@PostConstruct
	public  void scan() {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		((DozerBeanMapper) mapper).setCustomFieldMapper(new LazyCustomFieldMapper());
		
//		System.out.println("DozerConfig scan interceptor: " + interceptor);
	}
}
