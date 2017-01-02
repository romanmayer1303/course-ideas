package com.romanmayer.courses.model;

import java.util.List;

/**
 * Created by romanmayer on 02/01/17.
 */
public interface CourseIdeaDAO {

    boolean add(CourseIdea idea);

    List<CourseIdea> findAll();

}
