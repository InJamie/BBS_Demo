package pers.jamie.servlet.commentServlet;

import pers.jamie.dao.CommentDao;
import pers.jamie.dao.impl.CommentDaoimpl;
import pers.jamie.domain.Comment;
import pers.jamie.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/commentServlet")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String content = request.getParameter("comment");
        String postid = request.getParameter("postid");
        User user = (User) request.getSession().getAttribute("user");
        Comment comment = new Comment();
        comment.setAuthor_id(user.getId());
        comment.setAuthor(user.getName());
        comment.setCotent(content);
        comment.setPost_id(Integer.parseInt(postid));
        CommentDao dao = new CommentDaoimpl();
        dao.addcomment(comment);
        response.sendRedirect(request.getContextPath() + "/post_detail.jsp?post_id=" + postid);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
