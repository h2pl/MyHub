/*
 * Copyright (c) 2014, Baidu and/or its affiliates. All rights reserved.
 * Baidu PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.cat.entity;

import com.cat.vo.PageInfo;

/**
 * This class is defined the response format for console.
 *
 */
public class SimpleResponseEntity extends AbstractResponseEntity {

    private PageInfo retData;

    public SimpleResponseEntity() {
        super();
    }

    public PageInfo getRetData() {
        return retData;
    }

    public void setRetData(PageInfo retData) {
        this.retData = retData;
    }
}
