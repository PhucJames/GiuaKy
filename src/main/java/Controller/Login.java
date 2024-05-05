package Controller;

import DAO.IUser;
import DAO.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    IUser userDao = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String url ="/success.jsp";
        String error = "";
        if(!userDao.checkLogin(email, password)){
            url= "login.jsp";
            error = "Sai email hoặc password";
            request.setAttribute("error", error);
        }
        request.getRequestDispatcher(url).forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
