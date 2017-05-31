package edu.pucmm.programacionweb2017.service;

import edu.pucmm.programacionweb2017.dao.EstudianteDAO;
import edu.pucmm.programacionweb2017.dao.EstudianteDAOImpl;
import edu.pucmm.programacionweb2017.encapsulacion.Estudiante;

import java.util.List;

/**
 * Created by gusta on 31-May-17.
 */
public class EstudianteService implements EstudianteDAO{
    private EstudianteDAOImpl estudianteDAO;

    public EstudianteService() {
        estudianteDAO = new EstudianteDAOImpl();
    }

    @Override
    public void insertar(Estudiante estudiante) {
        estudianteDAO.insertar(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        estudianteDAO.actualizar(estudiante);
    }

    @Override
    public void borrar(Estudiante estudiante) {
        estudianteDAO.borrar(estudiante);
    }

    @Override
    public List<Estudiante> encontrarTodos() {
        return estudianteDAO.encontrarTodos();
    }

    @Override
    public Estudiante encontrarPorMatricula(int matricula) {
        return estudianteDAO.encontrarPorMatricula(matricula);
    }
}
