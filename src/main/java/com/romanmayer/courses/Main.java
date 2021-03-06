package com.romanmayer.courses;

import com.romanmayer.courses.model.CourseIdeaDAO;
import com.romanmayer.courses.model.SimpleCourseIdeaDAO;
import spark.ModelAndView;

import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

/**
 * Created by romanmayer on 01/01/17.
 */
public class Main {

//    staticFileLocation("/public");


   // staticFiles.location("/public");

    // in memory data structure based DAO
    // switch out with database
    // just for prototyping
    CourseIdeaDAO dao = new SimpleCourseIdeaDAO();

    public static void main(String[] args) {

        staticFileLocation("/public");

        get("/", (req, res) -> {
            Map<String, String> model = new HashMap<>();
            model.put("username", req.cookie("username"));
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        post("/sign-in", (req, res) -> {
            Map<String, String> model = new HashMap<>();
            String username = req.queryParams("username");
            res.cookie("username", username);
            model.put("username", username);
            return new ModelAndView(model, "sign-in.hbs");
        }, new HandlebarsTemplateEngine());
    }

}
