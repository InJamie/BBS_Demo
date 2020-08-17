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
import java.util.List;

@WebServlet("/getPostServlet")
public class GetPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("获取帖子内容。");
        //访问service 获取帖子
        PostService service = new PostServiceimpl();
        List<post> posts = service.getpost();
        //序列化 传向前端
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), posts);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
