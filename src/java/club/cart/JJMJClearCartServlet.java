/*
 * Matthew Janes
 * Janki Joshi
 * Assignment 4 - Java Web
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

public class JJMJClearCartServlet extends HttpServlet {

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
        HttpSession session = request.getSession();

        ECart cart;        
        cart = (ECart) session.getAttribute("loanCart");

        if (cart != null) {
            ArrayList<Book> books = cart.getItems();

            ArrayList<Book> loanItems;
            loanItems = (ArrayList<Book>) context.getAttribute("loanItems");

            for (Book cartBook : books) {
                String code = cartBook.getCode();
                int quantity = cartBook.getQuantity();
                ELoan.addToQOH(loanItems, code, quantity);
            }
            session.setAttribute("cart", cart);
        }
        session.invalidate();

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
