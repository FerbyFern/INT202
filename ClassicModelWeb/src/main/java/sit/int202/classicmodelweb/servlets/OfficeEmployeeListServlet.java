package sit.int202.classicmodelweb.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.classicmodelweb.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeEmployeeListServlet", value = "/office-list")
public class OfficeEmployeeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        request.setAttribute("offices", officeRepository.findAll());
        String officeCode = request.getParameter("officeCode");
        if (officeCode != null) {
            request.setAttribute("selectedOffice", officeRepository.find(officeCode));
        }

        Cookie ck = new Cookie("lastpage", "office-list");
        ck.setMaxAge(7*24*60*60);
        response.addCookie(ck);

        getServletContext().getRequestDispatcher("/OfficeEmployeeList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
