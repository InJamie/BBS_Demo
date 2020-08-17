package pers.jamie.servlet.userServlet;

import pers.jamie.domain.User;
import pers.jamie.service.UserService;
import pers.jamie.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session中验证码并且移除验证码session
        HttpSession session = request.getSession();
        Object checkcode_server = session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        //获取网页传来的登录信息并验证
        String checkcode = request.getParameter("checkcode");
        if (!checkcode.equalsIgnoreCase((String) checkcode_server)) {
            request.setAttribute("img", "验证码有误");
            request.getRequestDispatcher("/homepage.jsp").forward(request, response);
        }
//        验证码通过后验证账号跟密码
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        //去写service   &&   dao
        //        封装对象
        User use = new User();
        use.setUsername(user);
        use.setPassword(password);
        UserService userService = new UserServiceImpl();
        User login = userService.login(use);
        if (login != null) {
            request.getSession().setAttribute("user", login);
            response.sendRedirect(request.getContextPath() + "/list.jsp");
        } else {
            request.setAttribute("img", "账号或密码有误");
            request.getRequestDispatcher("/homepage.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
