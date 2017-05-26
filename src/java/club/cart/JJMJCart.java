/*
 * Matthew Janes
 * Janki Joshi
 * Assignment 3 - Java Web
 */
package club.cart;

import club.business.Book;
import club.business.ECart;
import club.business.ELoan;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mjanes5520
 */
public class JJMJCart extends HttpServlet {

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

        String url = "/JJMJECart.jsp";

        ServletContext context = getServletContext();

        ArrayList<Book> loanItems;
        loanItems = (ArrayList<Book>) context.getAttribute("loanItems");

        String action = request.getParameter("action");
        String code = request.getParameter("code");

        HttpSession session = request.getSession();
        ECart loanCart = (ECart) session.getAttribute("loanCart");

        if (loanCart == null) {
            loanCart = new ECart();
        }

        if (action == null || action.isEmpty() || action.equals("")) {
            url = "/JJMJECart.jsp";
        } else if (action.equals("reserve")) {
            Book foundItem = ELoan.findItem(loanItems, code);
            if (foundItem.getQuantity() > 0) {
                loanCart.addItem(foundItem);
                ELoan.subtractFromQOH(loanItems, code, 1);
            }
            session.setAttribute("loanCart", loanCart);
        }

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
    // </editor-fold>

}
