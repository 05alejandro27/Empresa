package laboral.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import laboral.dao.EmpleadoDAO;
import laboral.modelo.entidades.Empleado;
import laboral.modelo.excepciones.DatosNoCorrectosException;

/**
 * Servlet implementation class NominaController
 */
@WebServlet(description = "administra peticiones para la tabla productos", urlPatterns = { "/empresa" })
public class NominaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NominaController() {
        super();
        // TODO Auto-generated constructor stub
    }

    //METODO GET VERDADERO
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        String opcion = request.getParameter("opcion");

        switch (opcion) {

            case "mostrarEmpleado": {
                System.out.println("Usted a presionado la opcion mostrarEmpleado");

                EmpleadoDAO empleadoDAO = new EmpleadoDAO();
                List<Empleado> lista = new ArrayList<>();

                try {
                    lista = empleadoDAO.informacionTodosEmpleados();
                    for (Empleado empleado : lista) {
                        System.out.println(empleado);
                    }

                    request.setAttribute("lista", lista);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/mostrarTodosEmpleados.jsp");
                    requestDispatcher.forward(request, response);

                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                break;
            }
            case "mostrarSalarioEmpleado": {
                System.out.println("Usted a presionado la opcion mostrarSalarioEmpleado");

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/mostrarSalarioEmpleado.jsp");
                requestDispatcher.forward(request, response);

                break;
            }
            case "modificarUnEmpleados": {
                System.out.println("Usted a presionado la opcion modificarUnEmpleados");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/modificarUnEmpleados.jsp");
                requestDispatcher.forward(request, response);

                break;
            }

        }

    }

    //METODO POST VERDADERO
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String opcion = request.getParameter("opcionFormulario");

        switch (opcion) {

            case "buscarSalario": {
                System.out.println("Usted a presionado la opcion buscar empleado para modificar empleado");

                String dni =  request.getParameter("dni");

                EmpleadoDAO empleadoDAO = new EmpleadoDAO();
                double salario = empleadoDAO.salarioPersona(dni);

                request.setAttribute("salario", salario);
                request.setAttribute("dni", dni);

                System.out.println("Registro guardado satisfactoriamente...");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/mostrarSalarioEmpleado.jsp");
                requestDispatcher.forward(request, response);

                break;
            }
            case "buscarEmpleado": {
                System.out.println("Usted a presionado la opcion buscar empleado");

                String dni =  request.getParameter("dni");
                EmpleadoDAO empleadoDAO = new EmpleadoDAO();
                Empleado empleado = empleadoDAO.empleadoPorDni(dni);

                request.setAttribute("empleado", empleado);
                request.setAttribute("dni", dni);


                System.out.println("Registro guardado satisfactoriamente...");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/modificarUnEmpleados.jsp");
                requestDispatcher.forward(request, response);

                break;
            }
            case "modificarEmpleado": {
                System.out.println("Usted a presionado la opcion para modificar empleado");

                String dni =  request.getParameter("dni");
                EmpleadoDAO empleadoDAO = new EmpleadoDAO();
                Empleado emp = empleadoDAO.empleadoPorDni(dni);

                String nombre = request.getParameter("nombre");
                String sexoString = request.getParameter("sexo");
                String categoriaString = request.getParameter("categoria");
                String anyosTrabajadosString = request.getParameter("anyosTrabajados");

                if(nombre == null || nombre.isEmpty()) {
                    nombre = emp.getNombre();
                }

                char sexo;
                if(sexoString == null || sexoString.isEmpty()) {
                    sexo = emp.getSexo();
                } else {
                    sexo = sexoString.charAt(0);
                }

                int categoria = 0;
                if(categoriaString == null || categoriaString.isEmpty()) {
                    categoria = emp.getCategoria();
                } else {
                    categoria = Integer.parseInt(categoriaString);
                }

                int anyosTrabajados = 0;
                if(anyosTrabajadosString == null || anyosTrabajadosString.isEmpty()) {
                    anyosTrabajados = emp.getAnyos();
                } else {
                    anyosTrabajados = Integer.parseInt(anyosTrabajadosString);
                }

                Empleado empleadoEnviar = null;
                try {

                    empleadoEnviar = new Empleado(nombre, dni, sexo, categoria, anyosTrabajados);
                    empleadoDAO.actualizarEmpleado(empleadoEnviar);
                    request.setAttribute("empleadoEnviar", empleadoEnviar);

                } catch (DatosNoCorrectosException e) {

                    throw new RuntimeException(e);

                }

                System.out.println("Registro guardado satisfactoriamente...");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/modificarUnEmpleados.jsp");
                requestDispatcher.forward(request, response);

                break;
            }
        }
    }

}