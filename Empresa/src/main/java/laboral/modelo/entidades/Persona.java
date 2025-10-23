package laboral.modelo.entidades;

import laboral.modelo.excepciones.DatosNoCorrectosException;

public class Persona {
    public String nombre;
    public String dni;
    public char sexo;

    public Persona(String nombre, String dni, char sexo) throws DatosNoCorrectosException {

        if(nombre == null || nombre.isEmpty() || dni == null || dni.isEmpty()) {
            throw new DatosNoCorrectosException("Datos no correctos");
        } else {
            this.nombre = nombre;
            this.dni = dni;
            this.sexo = sexo;
        }
    }

    public Persona(String nombre, char sexo) throws DatosNoCorrectosException{
        if(nombre != null && nombre.isEmpty()) {
            throw new DatosNoCorrectosException("Datos no correctos");
        } else {
            this.nombre = nombre;
            this.sexo = sexo;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public char getSexo() {
        return sexo;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void Imprime() {
        System.out.println("El nombre es: " + nombre + " y su dni es: " + dni);
    }
}
