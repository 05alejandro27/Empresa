package laboral.modelo.entidades;

import laboral.modelo.excepciones.DatosNoCorrectosException;

/**
 * Clase de un empleado.
 *
 * Tiene los métodos para usar y crear un empleado.
 */
public class Empleado extends Persona {
    private int categoria;
    public int anyos;

    public Empleado(String nombre, String dni, char sexo, int categoria, int anyos) throws DatosNoCorrectosException {
        super(nombre, dni, sexo);
        if (categoria >= 1 && categoria <= 10){
            this.categoria = categoria;
        } else {
            this.categoria = 1;
        }

        if (anyos >= 0) {
            this.anyos = anyos;
        } else {
            this.anyos = 0;
        }

    }

    public Empleado(String nombre, String dni, char sexo) throws DatosNoCorrectosException{
        super(nombre, dni, sexo);
        categoria = 1;
        anyos = 0;
    }

    @Override
    public String getDni() {
        return this.dni;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public char getSexo() {
        return this.sexo;
    }

    public int getAnyos() {
        return anyos;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void incrAnyo() {
        this.anyos = this.anyos + 1;
    }

    public void Imprime() {
        System.out.println("El nombre es: " + nombre + " su dni es: " + dni + " su sexo es: " + sexo + " su categoria es: " + categoria + " y su edad es: " + anyos);
    }
}
