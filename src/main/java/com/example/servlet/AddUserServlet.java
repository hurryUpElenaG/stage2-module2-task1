package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {

    //write your code here!

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect("jsp/add.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("came to doPost method");
        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("lastName");
        User user = new User(firstName, secondName);
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.addUser(user);
        req.setAttribute("user", user);


        req.getRequestDispatcher("jsp/add.jsp").forward(req, resp);
    }

}
