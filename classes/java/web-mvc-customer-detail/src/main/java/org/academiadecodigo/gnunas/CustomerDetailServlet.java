package org.academiadecodigo.gnunas;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setName("Eduardo Pedro");
        user.setEmail("edupedro1996@gmail.com");

        getServletContext().setAttribute("user", user);
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}
