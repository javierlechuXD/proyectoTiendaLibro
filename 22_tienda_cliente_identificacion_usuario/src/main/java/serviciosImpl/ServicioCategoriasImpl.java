package serviciosImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import constantesSQL.ConstantesSQL;
import servicios.ServicioCategorias;

@Service
@Transactional
public class ServicioCategoriasImpl implements ServicioCategorias{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Map<String, String> obtenerCategoriasParaDesplegable() {
		//para lanzar sql a traves de hibernate:
		SQLQuery query = sessionFactory.getCurrentSession().
				createSQLQuery(ConstantesSQL.SQL_OBTENER_CATEGORIAS_PARA_DESPLEGABLE);
		//para indicar que la consulta me devuelva elementos de tipo Map
		//debo indicar la siguiente
		query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List<Map<String, Object>> resultado = query.list();
		
		//debemos transformar de nuevo lo que nos da hibernate:
		Map<String, String> valoresDesplegable = new HashMap<>();
		for (Map<String,Object> map : resultado) {
			System.out.println(" obtenido: " + map.get("id") + " nombre: " + 
								map.get("nombre"));
			valoresDesplegable.put(map.get("id").toString(), 
					map.get("nombre").toString());
		}
		return valoresDesplegable;
	}

}



