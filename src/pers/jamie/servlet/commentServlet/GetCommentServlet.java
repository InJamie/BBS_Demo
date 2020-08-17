package pers.jamie.servlet.commentServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import pers.jamie.dao.CommentDao;
import pers.jamie.dao.impl.CommentDaoimpl;
import pers.jamie.domain.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getCommentServlet")
public class GetCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("获取全部评论");
        int post_id = Integer.parseInt(request.getParameter("post_id"));
        CommentDao dao = new CommentDaoimpl();
        List<Comment> comments = dao.getcomments(post_id);
        //序列化到前端展示
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), comments);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
