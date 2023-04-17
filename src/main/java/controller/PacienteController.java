package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Paciente;
import services.PacienteDao;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Servlet implementation class PacienteController
 */
public class PacienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private PacienteDao pacienteDao;
    public PacienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
		switch(action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertarPaciente(request, response);
			break;
		case "/delete":
			eliminarPaciente(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			actualizarPaciente(request, response);
			break;
		case "/average":
			promedioNotas(request, response);
			break;	
		default:
			listPaciente(request, response);
			break;
		}
		}catch(SQLException e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		/*Integer id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
		UsuarioDao uDao = new UsuarioDao();
		Usuario u = uDao.find(id);
		u.setNombre(nombre);
		u.setEmail(email);
		u.setPais(pais);
		uDao.update(u);
		request.getRequestDispatcher("/usuariolist.jsp").forward(request, response);*/
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("pacienteedit.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertarPaciente(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		Paciente p = new Paciente();
		String nombre = request.getParameter("nombre");
		String documento = request.getParameter("documento");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		String fechanacimiento = request.getParameter("fechanacimiento");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		BigDecimal peso = BigDecimal.valueOf(Double.parseDouble(request.getParameter("peso")));
		BigDecimal estatura = BigDecimal.valueOf(Double.parseDouble(request.getParameter("peso")));
		p.setNombre(nombre);
		p.setApellido(apellido);
		p.setDocumento(documento);
		p.setGenero(genero);
		p.setEmail(email);
		p.setFechanacimiento(null);
		p.setTelefono(telefono);
		p.setDireccion(direccion);
		p.setPeso(peso);
		p.setEstatura(estatura);
		PacienteDao pDao = new PacienteDao();
		pDao.insert(p);
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		Integer idTxt = Integer.parseInt(request.getParameter("id"));
		PacienteDao pDao = new PacienteDao();
		Paciente p = pDao.find(idTxt);
		request.setAttribute("paciente", p);
		request.getRequestDispatcher("/pacienteedit.jsp").forward(request, response);
	}
	
	private void actualizarPaciente(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String documento = request.getParameter("documento");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		String fechanacimiento = request.getParameter("fechanacimiento");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		BigDecimal peso = BigDecimal.valueOf(Double.parseDouble(request.getParameter("peso")));
		BigDecimal estatura = BigDecimal.valueOf(Double.parseDouble(request.getParameter("peso")));

		PacienteDao pDao = new PacienteDao();
		Paciente p = pDao.find(id);
		p.setNombre(nombre);
		p.setApellido(apellido);
		p.setDocumento(documento);
		p.setGenero(genero);
		p.setEmail(email);
		p.setFechanacimiento(null);
		p.setTelefono(telefono);
		p.setDireccion(direccion);
		p.setPeso(peso);
		p.setEstatura(estatura);
		pDao.update(p);
		request.getRequestDispatcher("/list").forward(request, response);
	}
	
	private void promedioNotas(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
	}
	
	private void eliminarPaciente(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		PacienteDao pDao = new PacienteDao();
		Paciente pacienteActual = pDao.find(id);
		pDao.delete(pacienteActual);
		response.sendRedirect("list");
	}
	
	private void listPaciente(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("pacientelist.jsp");
		dispatcher.forward(request, response);
	
	
		
			
		}
}
