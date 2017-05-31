package edu.pucmm.programacionweb2017.dao;

import edu.pucmm.programacionweb2017.encapsulacion.Estudiante;

import java.util.List;

/**
 * Created by gusta on 31-May-17.
 */
public interface EstudianteDAO {
    void insertar(Estudiante estudiante);

    void actualizar(Estudiante estudiante);

    void borrar(Estudiante estudiante);

    List<Estudiante> encontrarTodos();

    Estudiante encontrarPorMatricula(int matricula);
}
