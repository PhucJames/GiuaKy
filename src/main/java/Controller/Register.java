package Controller;

import DAO.IUser;
import DAO.User;
import DAO.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
    IUser userDao = new UserDAO();
    String fullName;
    String email;
    String password;
    User user;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        fullName = request.getParameter("fullName");
        email = request.getParameter("email");
        password = request.getParameter("password");
        user = new User();
        user.setPassword(password);
        user.setfullName(fullName);
        user.setEmail(email);

        if (Objects.equals(action, "add")) add(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/register.jsp";
        String status = "Thêm người dùng thành công";
        boolean isExist = userDao.findByEmail(email).getId() != 0;
        if (isExist) {
            status = "Người dùng đã tồn tại";
        } else {
            status = userDao.add(user) == 1 ? status
                    : "Thêm người dùng thất bại";
        }
        request.setAttribute("status", status);
        request.getRequestDispatcher(url).forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
