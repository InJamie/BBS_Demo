package pers.jamie.listenser;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

/**
 * 监听在线人数，监听session的创建和销毁
 */
@WebListener()
public class OnlineNumberHttpSessionListener implements HttpSessionListener {

    public OnlineNumberHttpSessionListener() {
    }

    public void sessionCreated(HttpSessionEvent se) {
        //1.获取session
        HttpSession session = se.getSession();
        ServletContext servletContext = session.getServletContext();
        //2.获取counnt值，加1
        int count = (int) servletContext.getAttribute("count");
        count++;
        //3.把servlet存储到servletContext对象中
        servletContext.setAttribute("count", count);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        //1.获取session
        HttpSession session = se.getSession();
        ServletContext servletContext = session.getServletContext();
        //2.获取counnt值，减1
        int count = (int) servletContext.getAttribute("count");
        count--;
        //3.把servlet存储到servletContext对象中
        servletContext.setAttribute("count", count);
    }
}
