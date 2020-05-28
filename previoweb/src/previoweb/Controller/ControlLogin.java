package previoweb.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import previo.dao.ClienteDao;
import previo.entities.Cliente;

/**
 * Servlet implementation class ControlLogin
 */
@WebServlet("/ControlLogin")
public class ControlLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlLogin() {
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
        case "Ingresar":
        	String usuario = request.getParameter("email");
            String password = request.getParameter("password");
            ClienteDao uDao = new ClienteDao();
            Query q = uDao.getEm().createQuery("select u from Cliente u where u.email = ?1");
            q.setParameter(1, usuario);
            Cliente us = (Cliente) q.getSingleResult();
            if(us!=null){
            	if(us.getClave().contentEquals(password)){
            		
                    request.getRequestDispatcher("/cliente.jsp").forward(request, response);
            	}else{
            		request.getRequestDispatcher("/login.jsp").forward(request, response);
            	}
            }else{
            	request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        
        	break;
        case "REGISTRARSE":
        
            
            
        	break;
        	default:
        		throw new AssertionError();
        }
	}

}
