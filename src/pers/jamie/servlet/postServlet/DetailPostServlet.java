package pers.jamie.servlet.postServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import pers.jamie.domain.post;
import pers.jamie.service.PostService;
import pers.jamie.service.impl.PostServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/detailPostServlet")
public class DetailPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问详细的帖子");
        String post_id = request.getParameter("post_id");
        System.out.println(post_id);
        PostService service = new PostServiceimpl();
        post post = service.findbyid(post_id);

        System.out.println("返回的信息：" + post.toString());

        //序列化到前端

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), post);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
