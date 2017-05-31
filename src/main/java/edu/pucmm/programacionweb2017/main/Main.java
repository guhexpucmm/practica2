package edu.pucmm.programacionweb2017.main;

import edu.pucmm.programacionweb2017.encapsulacion.Estudiante;
import edu.pucmm.programacionweb2017.service.EstudianteService;
import spark.ModelAndView;
import spark.TemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

/**
 * Created by gusta on 29-May-17.
 */
public class Main {
    TemplateEngine templateEngine;

    public static void main(String[] args) {
        EstudianteService estudianteService = new EstudianteService();
        estudianteService.insertar(new Estudiante(20130001, "Gustavo","Henriquez", "8095801962"));

        //Para redireccionar al inicio de la pagina
        get("/", (request, response) -> {
            response.redirect("/inicio");
            return null;
        });

        //Inicio que muestra todos los estudiantes registrados. Si hay
        get("/inicio", (request, response) -> {
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("titulo", "CRUD sencillo de estudiantes registrados.");
            parametros.put("header", "Listado de estudiantes registrados.");
            parametros.put("listaEstudiantes", estudianteService.encontrarTodos());

            return renderThymeleaf(parametros, "/inicio");
        });

        get("/estudiante/insertar", (request, response) -> {
            return null;
        });

        post("/estudiante/agregar", (request, response) -> {
            return null;
        });

        put("/estudiante/actualizar", (request, response) -> {
            return null;
        });

        delete("/estudiante/borrar", (request, response) -> {
            return null;
        });
    }

    public static String renderThymeleaf(Map<String, Object> parametros, String path) {
        return new ThymeleafTemplateEngine().render(new ModelAndView(parametros, path));
    }
}
