package by.guru13.servlets;

import by.guru13.models.clinic.Client;
import by.guru13.models.clinic.Clinic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ASUS on 12.08.2015.
 */
@WebServlet(name = "DeleteClientServlet", urlPatterns = "/del")
public class DeleteClientServlet extends HttpServlet {
    private Clinic clinic = Clinic.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        clinic.removeClientByName(request.getParameter("clientNameDel"));
        request.setAttribute("clinic", clinic);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/clinic/ClinicView.jsp");
        dispatcher.forward(request, response);
//        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/add"));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
