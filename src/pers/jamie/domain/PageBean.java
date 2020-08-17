package pers.jamie.domain;

import java.util.List;

public class PageBean {
    private int totalCount;    //总条数
    private int tatalPage;      //总页数
    private int currentPage;    //当前页数
    private int pageSize;       //每页显示的条数
    private List<post> list;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTatalPage() {
        return tatalPage;
    }

    public void setTatalPage(int tatalPage) {
        this.tatalPage = tatalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<post> getList() {
        return list;
    }

    public void setList(List<post> list) {
        this.list = list;
    }
}
