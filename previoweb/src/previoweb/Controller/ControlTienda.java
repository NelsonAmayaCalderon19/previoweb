package previoweb.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import previo.dao.ServicioDao;
import previo.dao.TiendaDao;
import previo.entities.Servicio;
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
response.setContentType("text/html;charset=UTF-8");
        
HttpSession session = request.getSession(true);
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
  
            switch (accion){
                case "ver":
                Integer idTxt = Integer.parseInt(request.getParameter("id"));
                TiendaDao cDao = new TiendaDao();
                Tienda c = cDao.find(idTxt);
                request.setAttribute("carrera", c);
                session.setAttribute("idTienda", idTxt); 
                request.getRequestDispatcher("/servicios.jsp").forward(request, response);
                	break;              
                default:
                    throw new AssertionError();
            } 
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
            RequestDispatcher rd3=request.getRequestDispatcher("/index.jsp");
            rd3.include(request, response);
        	break;
        case "Registro":
        	Integer tienda = (int) session.getAttribute("idTienda");
        	String usuario = request.getParameter("nombre");
            String desc = request.getParameter("descripcion");
            TiendaDao uDao = new TiendaDao();
            Tienda tiendaBean = uDao.find(tienda);
            Servicio m = new Servicio();
            m.setTiendaBean(tiendaBean);
        	m.setNombre(usuario);
        	m.setDescripcion(desc);
            ServicioDao mDao = new ServicioDao();
            mDao.insertar(m);
            RequestDispatcher rd4=request.getRequestDispatcher("/servicios.jsp");
            rd4.include(request, response);
        	break;
        default:
    		throw new AssertionError();
    }
	}

}
