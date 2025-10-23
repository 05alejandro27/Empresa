package laboral.modelo.entidades;

/**
 * Clase de la nomina de un empleado
 *
 * Tiene los métodos necesarios para calcular el sueldo un empleado.
 */
public class Nomina {

    private static final int[] SUELDO_BASE = {50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000, 230000};

    /**
     * Calcula el sueldo neto de un empleado.
     *
     * @param emp el parámetro emp es el empleado del que vamos a calcular su sueldo.
     * @return el importe total del sueldo en euros.
     */
    public int Sueldo(Empleado emp) {

        /**
         * @param sueldo el parámetro sueldo nos da el sueldo del empleado una vez calculado su sueldo base según la categoría
         * y se le aplica un plus de 5000 euros por cada año en la empresa.
         * @author aleja
         */
        int sueldo = SUELDO_BASE[emp.getCategoria()-1] + 5000*emp.anyos;

        return sueldo;
    }
}

