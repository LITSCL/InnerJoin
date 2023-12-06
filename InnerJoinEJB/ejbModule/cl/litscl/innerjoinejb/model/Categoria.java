package cl.litscl.innerjoinejb.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Categoria
 *
 */
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Categoria() {
		super();
	}
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "nombre")
	private String nombre;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
   
}
