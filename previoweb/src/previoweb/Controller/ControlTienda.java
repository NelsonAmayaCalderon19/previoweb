package previoweb.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import previo.dao.TiendaDao;
import previo.entities.Tienda;

/**
 * Servlet implementation class ControlTienda
 */
@WebServlet("/ControlTienda")
public class ControlTienda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlTienda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");        
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(true);
        String accion = request.getParameter("accion");
        PrintWriter out;
        out = response.getWriter();
        switch (accion){
        case "Registrar":
        	String nombre = request.getParameter("nombre");
            String lema = request.getParameter("lema");
            String descripcion = request.getParameter("descripcion");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String propietario = request.getParameter("propietario");
            String facebook = request.getParameter("facebook");
            String web = request.getParameter("web");
            String imagen = request.getParameter("imagen");
            TiendaDao tDao = new TiendaDao();
            Tienda t = new Tienda();
            t.setNombre(nombre);
        	t.setLema(lema);
        	t.setDescripcion(descripcion);
        	t.setEmail(email);
        	t.setClave(password);
        	t.setPropietario(propietario);
        	t.setFacebook(facebook);
        	t.setWeb(web);
        	t.setImagen(imagen);
        	tDao.insertar(t);
        	request.getRequestDispatcher("/index.jsp").forward(request, response);
        	break;
        default:
    		throw new AssertionError();
    }
	}

}
