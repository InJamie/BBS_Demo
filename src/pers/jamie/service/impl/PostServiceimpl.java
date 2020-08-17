package pers.jamie.service.impl;

import pers.jamie.dao.PostDao;
import pers.jamie.dao.impl.PostDaoimpl;
import pers.jamie.domain.PageBean;
import pers.jamie.domain.post;
import pers.jamie.service.PostService;

import java.util.List;

public class PostServiceimpl implements PostService {
    private PostDao dao = new PostDaoimpl();

    @Override
    public void deletepost(int post_id) {
        dao.deletepost(post_id);
    }

    @Override
    public PageBean getpostByPage(PageBean pageBean) {
        List<post> posts = dao.getpostByPage(pageBean);
        int allCount = dao.findAllCount();
        int totalPage;
        if (allCount % pageBean.getPageSize() == 0) {
            totalPage = allCount / pageBean.getPageSize();
        } else {
            totalPage = allCount / pageBean.getPageSize() + 1;
        }

        pageBean.setList(posts);
        pageBean.setTotalCount(allCount);
        pageBean.setTatalPage(totalPage);
        return pageBean;

    }

    @Override
    public List<post> getpost() {
        return dao.getpost();
    }

    @Override
    public void addpost(post post) {
        dao.addpost(post);
    }

    @Override
    public post findbyid(String id) {
        return dao.findbyid(id);
    }


}
