package org.oldcode.javaweb.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {
    void Do(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
