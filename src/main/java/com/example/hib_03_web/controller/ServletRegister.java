package com.example.hib_03_web.controller;

import com.example.hib_03_web.bean.User;
import com.example.hib_03_web.dao.UserDao;
import com.example.hib_03_web.exception.HbException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletRegister", value = "/registered")
public class ServletRegister extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        this.getServletContext().getRequestDispatcher("/registered.jsp").forward(request, response);
        response.setContentType("text/html");
        UserDao userDao = new UserDao();

        try {
            User user1 = null;
            try {
                user1 = userDao.save(new User(name,password,email));
                request.setAttribute("user", user1.getName());
            } catch (HbException e) {
                e.printStackTrace();
            }
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            validator.validate(user1);
        } catch (ConstraintViolationException e) {
            request.setAttribute("errors", e.getConstraintViolations());
        }




//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h3>Your record is registered</h3>");
//        out.println("<p>Your name is: " + name + "</p>");
//        out.println("<p>Your password is: " + password + "</p>");
//        out.println("<p>Your email is: " + email + "</p>");
//        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);

    }
}
