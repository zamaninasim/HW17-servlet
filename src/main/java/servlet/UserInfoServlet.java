package servlet;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserInfoServlet extends HttpServlet {
    UserService userService= new UserService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("fname");
        String lastname = req.getParameter("lname");
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        userService.save(user);

        req.setAttribute("firstname",firstname);
        req.setAttribute("lastname",lastname);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("welcome");
        requestDispatcher.forward(req,resp);
    }
}
