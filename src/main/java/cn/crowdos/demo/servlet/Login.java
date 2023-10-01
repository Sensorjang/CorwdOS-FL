package cn.crowdos.demo.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import cn.crowdos.demo.entity.User;
import cn.crowdos.demo.service.db.*;
import cn.crowdos.demo.service.exceptions.LoginException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String targetJSP = "/pages/jsp/login.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(targetJSP);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            UserService.login(username, password);
            User myUser = UserService.findUserByUsername(username);
            if(myUser != null && myUser.getAdmin()) {
                HttpSession session = request.getSession();
                session.setAttribute("isAdmin", true);
                session.setAttribute("user", myUser.getId());
                response.sendRedirect(request.getContextPath() + "/AdminPage");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", myUser.getId());
                response.sendRedirect(request.getContextPath() + "/Home");
            }
        } catch (LoginException e) {
            request.setAttribute("error", e.getMessage());
            String targetJSP = "/pages/jsp/login.jsp";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(targetJSP);
            requestDispatcher.forward(request, response);
        }
    }
}
