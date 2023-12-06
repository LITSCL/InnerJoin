package cl.litscl.innerjoinejb.bean;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ProductoDAOLocal {
	public List<Object[]> findAllFK(String columnaCategoria, String columna, String valor);
}
