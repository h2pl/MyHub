package com.cat.vo;

import java.util.List;

/**
 * This class is used to wrap paging information.
 * 
 * @author liangmanman
 *
 */
public class PageInfo {
    /* The variable to store page number like 1,2. */
    private int pageNum;

    /* The variable to store page size. */
    private int pageSize;

    /* The variable to store the total amount of records. */
    private long totalRecords;

    /* The variable to store the real data list. */
    private List<?> rows;

    /* The variable to store the sort order field. */
    private String orderColumn;

    /* The variable to store the sort order. */
    private String order;

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

}
