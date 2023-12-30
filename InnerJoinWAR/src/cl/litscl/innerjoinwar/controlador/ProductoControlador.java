package cl.litscl.innerjoinwar.controlador;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.litscl.innerjoinejb.bean.ProductoDAOLocal;



/**
 * Servlet implementation class ProductoController
 */
@WebServlet("/ProductoControlador")
public class ProductoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private ProductoDAOLocal daoProducto;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//NOTA: El método "doGet" se debe utilizar para renderizar vistas y controlar datos que llegan desde la URL.
		
		//1. Crear una sesión.
		HttpSession sesion = request.getSession(false);
		
		//2. recibir los parámetros.
		String vista = request.getParameter("vista");
		String opcion = request.getParameter("opcion");
		
		//3. Verificar si llegan los parámetros (Switch no puede recibir datos "null").
		if (vista == null) {
			vista = "";
		}
		if (opcion == null) {
			opcion = "";
		}	
		
		//4. Revisar que vista se desea renderizar.
		switch (vista) { //NOTA: Este Switch es para renderiza vistas.
			case "index":	
				sesion.setAttribute("productos", daoProducto.findAllFK("nombre", "categoriaFK", "2"));
				
				sesion.setAttribute("renderizarVista", "index");
				response.sendRedirect(request.getContextPath());
				break;
			default:
				break;
		}
		
		switch (opcion) { //NOTA: Este Switch es para controlar datos que llegan desde la URL.
			case "1": //Renderizar tabla.
				String columnaCategoria = request.getParameter("columnaCategoria");
				String columna = request.getParameter("columna");
				String valor = request.getParameter("valor");
				
				if (columnaCategoria.isEmpty()) {
					columnaCategoria = null;
				}
				
				sesion.setAttribute("productos", daoProducto.findAllFK(columnaCategoria, columna, valor));
				
				sesion.setAttribute("renderizarVista", "index");
				response.sendRedirect(request.getContextPath());
				break;
			default:
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
