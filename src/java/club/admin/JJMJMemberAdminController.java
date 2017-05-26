/*
 *Matthew Janes
 *Janki Joshi
 *Assignment4 - 4/5/2017
 */
package club.admin;

import club.business.Member;
import club.data.MemberDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class JJMJMemberAdminController extends HttpServlet {

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

        String action;
        String url = "/JJMJDisplayMembers.jsp";

        action = request.getParameter("action");

        if (action.equals("") || action.isEmpty()) {
            action = "displayMembers";
        }

        if (action.equals("displayMembers")) {
            ArrayList<Member> memberList;
            memberList = MemberDB.selectMembers();
            request.setAttribute("memberList", memberList);
            url = "/JJMJDisplayMembers.jsp";
        }

        if (action.equals("addMember")) {
            url = "/JJMJMember.jsp";
        }

        if (action.equals("displayMember")) {
            //ArrayList<Member> memberList;
            String email = request.getParameter("email");
            Member memberList = MemberDB.selectMember(email);
            request.setAttribute("memberList", memberList);
            url = "/JJMJMember.jsp";
        }

        if (action.equals("confirmDeleteMember")) {
            String email = request.getParameter("email");
            Member memberList = MemberDB.selectMember(email);
            request.setAttribute("memberList", memberList);
            url = "/JJMJConfirmMemberDelete.jsp";
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);

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

        String action;
        String url = "/JJMJDisplayMembers.jsp";
        String message = "";
        ArrayList<Member> memberList;

        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String programName = request.getParameter("program");
        String tempYearLevel = request.getParameter("year");

        Integer yearLevel = Integer.parseInt(tempYearLevel);

        action = request.getParameter("action");

        Member member = new Member(fullName, email);

        member.setPhoneNumber(phone);
        member.setProgramName(programName);
        member.setYearLevel(yearLevel);

        if (action == null || action.equals("") || action.isEmpty()) {
            if (member.isValid()) {

                if (MemberDB.emailExists(email)) {
                    MemberDB.update(member);

                    // setting the parameter for displaying Members                    
                    memberList = MemberDB.selectMembers();
                    request.setAttribute("memberList", memberList);

                } else if (fullName.equals("") || fullName.isEmpty()
                        || email.equals("") || email.isEmpty()) {
                    message = "Member information is not valid. You must "
                            + "enter a valid name and email";
                    member = MemberDB.selectMember(email);
                    request.setAttribute("memberList", member);
                    url = "/JJMJMember.jsp";
                } else {
                    MemberDB.insert(member);

                    // setting the parameter for displaying Members
                    memberList = MemberDB.selectMembers();
                    request.setAttribute("memberList", memberList);
                }

            } else {
                message = "Member information is not valid. You must "
                        + "enter a valid name and email";
                request.setAttribute("memberList", member);
                url = "/JJMJMember.jsp";
            }

        } else if (action.equals("deleteMember")) {
            //deleting the member fromdatabase
            member = MemberDB.selectMember(email);
            MemberDB.delete(member);

            // setting the parameter for displaying Members
            memberList = MemberDB.selectMembers();
            request.setAttribute("memberList", memberList);
        }

        request.setAttribute("message", message);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
