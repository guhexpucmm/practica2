package edu.pucmm.programacionweb2017.dao;

import edu.pucmm.programacionweb2017.db.DBEstudiante;
import edu.pucmm.programacionweb2017.encapsulacion.Estudiante;

import java.util.List;

/**
 * Created by gusta on 31-May-17.
 */
public class EstudianteDAOImpl implements EstudianteDAO {
    @Override
    public void insertar(Estudiante estudiante) {
        DBEstudiante.listaEstudiantes.add(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {

    }

    @Override
    public void borrar(Estudiante estudiante) {
        DBEstudiante.listaEstudiantes.remove(estudiante);
    }

    @Override
    public List<Estudiante> encontrarTodos() {
        return DBEstudiante.listaEstudiantes;
    }
}
