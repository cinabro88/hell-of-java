package com.example.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

/**
 * Created by mingook on 2016년7월 17일 (일).
 */
public class BeerSelect extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ColorModel color = new ColorModel();
        color.setColor(request.getParameter("color"));
        request.setAttribute("color", color);
        request.setAttribute("message", request.getParameter("message"));

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);


//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("Beer Selection Advice<br>");
//        String color = request.getParameter("color");
//        out.println("<br>Got beer color " + color);
//        out.println("되네?");
//
//        String adminName = request.getServletContext().getInitParameter("admin_name");
//        out.println("Admin : " + adminName);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destory");
    }
}
