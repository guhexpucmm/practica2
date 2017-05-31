package edu.pucmm.programacionweb2017.main;

import edu.pucmm.programacionweb2017.encapsulacion.Estudiante;
import edu.pucmm.programacionweb2017.service.EstudianteService;
import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

/**
 * Created by gusta on 29-May-17.
 */
public class Main {
    public static void main(String[] args) {
        EstudianteService estudianteService = new EstudianteService();
        estudianteService.insertar(new Estudiante(20130001, "Gustavo", "Henriquez", "8095801962"));
        estudianteService.insertar(new Estudiante(20130002, "Manuel", "Tolentino", "8099717116"));
        estudianteService.insertar(new Estudiante(20130003, "John", "Bien-Aime", "8096784560"));

        String projectDir = System.getProperty("user.dir");
        String staticDir = "/src/main/resources";
        staticFiles.externalLocation(projectDir + staticDir);

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
            parametros.put("agregarEstudiante", "Agregar nuevo estudiante");
            parametros.put("listaEstudiantes", estudianteService.encontrarTodos());

            return renderThymeleaf(parametros, "/inicio");
        });

        get("/insertar", (request, response) -> {
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("metodo", "insertar");
            parametros.put("titulo", "Agregar estudiante.");
            parametros.put("header", "Agregar nuevo estudiante.");
            parametros.put("submit", "Insertar");
            parametros.put("cancel", "Cancelar");

            return renderThymeleaf(parametros, "/form");
        });

        get("/editar", (request, response) -> {
            int matricula = Integer.parseInt(request.queryParams("matricula"));
            Estudiante estudiante = estudianteService.encontrarPorMatricula(matricula);

            Map<String, Object> parametros = new HashMap<>();
            parametros.put("metodo", "editar");
            parametros.put("titulo", "Editar estudiante.");
            parametros.put("header", "Editar estudiante registrado.");
            parametros.put("submit", "Actualizar");
            parametros.put("cancel", "Cancelar");
            parametros.put("mat", estudiante.getMatricula());
            parametros.put("nom", estudiante.getNombre());
            parametros.put("ape", estudiante.getApellido());
            parametros.put("tel", estudiante.getTelefono());

            return renderThymeleaf(parametros, "/form");
        });

        post("/editar", (request, response) -> {
            int matricula = Integer.parseInt(request.queryParams("matricula"));
            Estudiante estudiante = estudianteService.encontrarPorMatricula(matricula);

            estudiante.setMatricula(Integer.parseInt(request.queryMap().get("matricula").value()));
            estudiante.setNombre(request.queryMap().get("nombre").value());
            estudiante.setApellido(request.queryMap().get("apellido").value());
            estudiante.setTelefono(request.queryMap().get("telefono").value());

            estudianteService.actualizar(estudiante);

            response.redirect("/inicio");
            return null;
        });

        post("/insertar", ((request, response) -> {
            Estudiante estudiante = new Estudiante();
            estudiante.setMatricula(Integer.parseInt(request.queryMap().get("matricula").value()));
            estudiante.setNombre(request.queryMap().get("nombre").value());
            estudiante.setApellido(request.queryMap().get("apellido").value());
            estudiante.setTelefono(request.queryMap().get("telefono").value());

            estudianteService.insertar(estudiante);

            response.redirect("/inicio");
            return null;
        }));

        get("/ver", (request, response) -> {
            int matricula = Integer.parseInt(request.queryParams("matricula"));
            Estudiante estudiante = estudianteService.encontrarPorMatricula(matricula);

            if (estudiante != null) {
                return estudiante.toString();
            } else {
                return "Estudiante no existe.";
            }
        });

        get("/borrar", (request, response) -> {
            int matricula = Integer.parseInt(request.queryParams("matricula"));
            Estudiante estudiante = estudianteService.encontrarPorMatricula(matricula);
            estudianteService.borrar(estudiante);

            response.redirect("/inicio");
            return null;
        });
    }

    public static String renderThymeleaf(Map<String, Object> parametros, String path) {
        return new ThymeleafTemplateEngine().render(new ModelAndView(parametros, path));
    }
}
