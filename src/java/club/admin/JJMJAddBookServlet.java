/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.admin;

import club.business.Book;
import club.data.BookIO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jjoshi6191
 */
public class JJMJAddBookServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Book book;

        String url = "/JJMJDisplayBooks";

        // get parameters from the request
        String code = request.getParameter("code");
        String description = request.getParameter("description");
        String tempquantity = request.getParameter("quantity");

        // validate the parameters
        String message = "";
        Integer quantity = 0;

        if (code == null || code.isEmpty()) {
            message += "Book Code is required <br>";
        }

        if (description.length() < 2) {
            message += "Description must have at least 2 characters <br>";
        }

        if (tempquantity == null || tempquantity.isEmpty()) {
            message += "Quantity must be a positive number";
        } else {
            quantity = Integer.parseInt(tempquantity);
            if (quantity <= 0) {
                message += "Quantity must be a positive number";
            }
        }

        ServletContext context = getServletContext();
        String path = context.getRealPath("/WEB-INF/books.txt");

        book = new Book(code, description, quantity);

        if (message == "") {
            BookIO.insert(book, path);
        } else {
            url = "/JJMJAddBook.jsp";
        }

        request.setAttribute("message", message);
        request.setAttribute("book", book);

        // store data in User object
        // book = new Book(code, description, quantity);
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
