package pers.jamie.servlet.postServlet;

import pers.jamie.domain.User;
import pers.jamie.domain.post;
import pers.jamie.service.PostService;
import pers.jamie.service.UserService;
import pers.jamie.service.impl.PostServiceimpl;
import pers.jamie.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/writePostServlet")
public class WritePostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //===========================封装对象===================
        int theme_id = Integer.parseInt(request.getParameter("inlineRadioOptions"));
        String post_title = request.getParameter("post_title");
        String content = request.getParameter("content");
        User user = (User) request.getSession().getAttribute("user");
        //若session为空则通过过滤器直接阻止其访问添加帖子的页面
        post post = new post();
        UserService service = new UserServiceImpl();
        post.setAuthor(service.findUserByName(user.getName()).getId());
        post.setPost_content(content);
        post.setPost_title(post_title);
        post.setTheme_id(theme_id);
        //不封装时间 作者id 时间通过sql自动生成
        //=====================================================
        PostService postservice = new PostServiceimpl();
        postservice.addpost(post);
        response.sendRedirect(request.getContextPath() + "/list.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }
}
