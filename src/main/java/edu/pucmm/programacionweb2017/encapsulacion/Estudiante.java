package edu.pucmm.programacionweb2017.encapsulacion;

import org.json.simple.JSONObject;

import java.io.Serializable;

/**
 * Created by gusta on 29-May-17.
 */
public class Estudiante implements Serializable {
    private int matricula;
    private String nombre;
    private String apellido;
    private String telefono;

    public Estudiante() {
    }

    public Estudiante(int matricula, String nombre, String apellido, String telefono) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "[Matricula: " + matricula + "] [Nombre: " + nombre + "] [Apellido: " + apellido + "] [Telefono: " + telefono + "]";
    }

    public String toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("matricula", matricula);
        jsonObject.put("nombre", nombre);
        jsonObject.put("apellido", apellido);
        jsonObject.put("telefono", telefono);

        return jsonObject.toJSONString();
    }
}
