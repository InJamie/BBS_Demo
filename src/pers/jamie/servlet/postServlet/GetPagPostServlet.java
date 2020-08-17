package pers.jamie.servlet.postServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import pers.jamie.domain.PageBean;
import pers.jamie.service.PostService;
import pers.jamie.service.impl.PostServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getPagPostServlet")
public class GetPagPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前页数
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        //封装一个pagebean
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(8);
        //获取当前页显示的内容
        PostService service = new PostServiceimpl();
        PageBean bean = service.getpostByPage(pageBean);
        //序列化 传向前端
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), bean);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
