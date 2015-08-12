package by.guru13.servlets;

import by.guru13.models.clinic.Client;
import by.guru13.models.clinic.Clinic;
import by.guru13.models.clinic.animals.Cat;
import by.guru13.models.clinic.animals.Dog;
import by.guru13.models.clinic.animals.Parrot;
import by.guru13.models.clinic.animals.Pet;

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
@WebServlet(name = "EditClientServlet", urlPatterns = "/edit")
public class EditClientServlet extends HttpServlet {
    private Clinic clinic = Clinic.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pet pet = null;
        if (request.getParameter("pets") != null) {
            if (request.getParameter("pets").equals("dog")) {
                pet = new Dog(request.getParameter("petName"));
            } else if (request.getParameter("pets").equals("cat")) {
                pet = new Cat(request.getParameter("petName"));
            } else if (request.getParameter("pets").equals("parrot")) {
                pet = new Parrot(request.getParameter("petName"));
            }

            if (!request.getParameter("clientName").isEmpty() && !request.getParameter("petName").isEmpty()) {
//                this.clinic.removeClientById(Integer.valueOf(request.getParameter("id")));
                this.clinic.addClient(new Client(Integer.valueOf(request.getParameter("id")), request.getParameter("clientName"), pet));
            }

            request.setAttribute("clinic", clinic);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/clinic/ClinicView.jsp");
            dispatcher.forward(request, response);
            response.sendRedirect(String.format("%s%s", request.getContextPath(), "/view"));
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("client", clinic.getClient(Integer.valueOf(req.getParameter("id"))));
        clinic.removeClientById(Integer.valueOf(req.getParameter("id"))-1);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/clinic/EditClient.jsp");
        dispatcher.forward(req, resp);
    }
}
