package laboral.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import laboral.conexion.Conexion;
import laboral.modelo.entidades.Empleado;
import laboral.modelo.entidades.Nomina;
import laboral.modelo.excepciones.DatosNoCorrectosException;

public class EmpleadoDAO {

    //Listar empleados
    public List<Empleado> informacionTodosEmpleados() throws SQLException {

        List<Empleado> listaEmpleado = new ArrayList<Empleado>();
        String sql = "Select * From empleados";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {

                String nombre = rs.getString("nombre");
                String dni = rs.getString("dni");
                char sexo = rs.getString("sexo").charAt(0);
                Integer categoria = rs.getInt("categoria");
                Integer anyos = rs.getInt("anyos_trabajados");

                listaEmpleado.add(new Empleado(nombre, dni, sexo, categoria, anyos));
            }

        } catch (DatosNoCorrectosException e) {
            throw new RuntimeException(e);
        }

        return listaEmpleado;
    }

    //Enseñar el salario
    public double salarioPersona(String dni) {

        double salario = 0;
        String sql = "SELECT sueldo FROM nominas WHERE dni = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, dni);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                salario = rs.getDouble("sueldo");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return salario;
    }

    //Encontrar empleado por el dni
    public Empleado empleadoPorDni(String dni) {

        Empleado emp = null;

        String sql = "SELECT * FROM empleados WHERE dni = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, dni);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {

                String nombre = rs.getString("nombre");
                char sexo = rs.getString("sexo").charAt(0);
                Integer categoria = rs.getInt("categoria");
                Integer anyos = rs.getInt("anyos_trabajados");

                emp = new Empleado(nombre, dni, sexo, categoria, anyos);
            }


        } catch (SQLException | DatosNoCorrectosException e) {
            throw new RuntimeException(e);
        }

        return emp;
    }

    //Actualizar un empleado
    public int actualizarEmpleado(Empleado empleado) {

        int numActualizaciones = 0;
        String sql = "UPDATE empleados SET nombre = ?, sexo = ?, categoria = ?, anyos_trabajados = ? WHERE dni = ?";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, String.valueOf(empleado.getSexo()));
            pstmt.setInt(3, empleado.getCategoria());
            pstmt.setInt(4, empleado.getAnyos());
            pstmt.setString(5, empleado.getDni());

            numActualizaciones = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        empleadoDAO.actualizarSueldoEmpleado(empleado.getDni());
        return numActualizaciones;
    }

    //Actualizar sueldo de un empleado
    public int actualizarSueldoEmpleado(String dni) {

        int numActualizaciones = 0;

        try (Connection conn = Conexion.getConnection()) {

            String sqlSelect = "SELECT * FROM empleados WHERE dni = ?";
            Empleado emp = null;

            try (PreparedStatement pstmtSelect = conn.prepareStatement(sqlSelect)) {
                pstmtSelect.setString(1, dni);
                ResultSet rs = pstmtSelect.executeQuery();

                if(rs.next()) {
                    String nombre = rs.getString("nombre");
                    String dniEmp = rs.getString("dni");
                    char sexo = rs.getString("sexo").charAt(0);
                    int categoria = rs.getInt("categoria");
                    int anyos = rs.getInt("anyos_trabajados");

                    emp = new Empleado(nombre, dniEmp, sexo, categoria, anyos);
                }
            }

            if(emp != null) {
                Nomina nomina = new Nomina();
                int sueldo = nomina.Sueldo(emp);

                String sqlUpdate = "UPDATE nominas SET sueldo = ? WHERE dni = ?";
                try (PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdate)) {
                    pstmtUpdate.setInt(1, sueldo);
                    pstmtUpdate.setString(2, dni);

                    numActualizaciones = pstmtUpdate.executeUpdate();
                }
            }

        } catch (SQLException | DatosNoCorrectosException e) {
            throw new RuntimeException(e);
        }

        return numActualizaciones;
    }
}

