package cl.litscl.innerjoinejb.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class ProductoDAO
 */
@Stateless
public class ProductoDAO implements ProductoDAOLocal {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("InnerJoinEJB");
	
    /**
     * Default constructor. 
     */
    public ProductoDAO() {
        // TODO Auto-generated constructor stub
    }
  
  
	@Override
	public List<Object[]> findAllFK(String columnaCategoria, String columna, String valor) {
		EntityManager em = this.emf.createEntityManager(); //1. Crear el EntityManager (Necesario para trabajar con el ORM).
		
		if (columnaCategoria == null) {
			columnaCategoria = "id";
		}
		
		TypedQuery<Object[]> query = em.createQuery("SELECT p.id, p.nombre, p.descripcion, p.precio, p.stock, p.imagen, c." + columnaCategoria + " FROM Producto p INNER JOIN Categoria c ON p.categoriaFK = c.id WHERE p." + columna + " = " + "'" + valor + "'", Object[].class); //2. Crear la consulta.
		List<Object[]> productos = query.getResultList(); //3. Ejecutar la consulta.
		
		return productos; //4. Retornar la lista.
	}

}
