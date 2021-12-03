package sit.int202.classicmodelweb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodelweb.repositories.CustomerRepository;

import java.io.IOException;

@WebServlet(name = "CustomerListServlet", value = "/075/customers")
public class CustomerListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CustomerRepository customerRepository = new CustomerRepository();
        request.setAttribute("customers",customerRepository.findAll());

        getServletContext().getRequestDispatcher("/Customer.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}