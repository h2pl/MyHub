package com.cat.dao.common;

public class AbstractResultTransformer implements IResultTransformerBean {
    private long totalCount;

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}
