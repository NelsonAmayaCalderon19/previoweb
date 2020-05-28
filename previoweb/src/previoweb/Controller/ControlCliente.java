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

import previo.dao.ClienteDao;
import previo.dao.TiendaDao;
import previo.entities.Cliente;
import previo.entities.Tienda;

/**
 * Servlet implementation class ControlCliente
 */
@WebServlet("/ControlCliente")
public class ControlCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlCliente() {
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
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            ClienteDao tDao = new ClienteDao();
            Cliente t = new Cliente();
            t.setNombre(nombre);
        	t.setEmail(email);
        	t.setClave(password);
        	tDao.insertar(t);

            RequestDispatcher rd3=request.getRequestDispatcher("/index.jsp");
            rd3.include(request, response);
        	break;
        default:
    		throw new AssertionError();
    }
	}

}
