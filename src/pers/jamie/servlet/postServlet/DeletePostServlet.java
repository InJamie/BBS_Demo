package pers.jamie.servlet.postServlet;

import pers.jamie.service.PostService;
import pers.jamie.service.impl.PostServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletePostServlet")
public class DeletePostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("开始删除");
        int post_id = Integer.parseInt(request.getParameter("post_id"));
        System.out.println("获取的post_id\t\t" + post_id);
        PostService service = new PostServiceimpl();

        service.deletepost(post_id);

        response.sendRedirect(request.getContextPath() + "/getPagPostServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
