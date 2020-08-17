package pers.jamie.listenser;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 创建servletcontent对象用于记录在线人数
 */
@WebListener()
public class InitServletContexListener implements ServletContextListener {


    public InitServletContexListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        //获取ServletContext域对象
        ServletContext servletContext = sce.getServletContext();
        //给ServletContext域对象，设置count=0
        servletContext.setAttribute("count", 0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }


}
