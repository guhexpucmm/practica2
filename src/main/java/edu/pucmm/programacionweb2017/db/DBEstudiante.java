package edu.pucmm.programacionweb2017.db;

import edu.pucmm.programacionweb2017.encapsulacion.Estudiante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by gusta on 31-May-17.
 */
public class DBEstudiante {
    //Lista que funciona como una base de datos falsa
    public static ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();
}
