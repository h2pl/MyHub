/*
 * Copyright (c) 2014, Baidu and/or its affiliates. All rights reserved.
 * Baidu PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.cat.util;

import java.util.Locale;

/**
 *
 * This ConstantUtil class is used to define constant variables.
 *
 * @author liangmanman@baidu.com
 *
 */
public class ConstantUtil {

    // Define the return codes
    public static final int RETCODE_ERROR = 1;
    public static final int RETCODE_CORRECT = 0;
    public static final int QUERY_MSG_ERROR = 601;
    public static final int QUERY_MSG_NULL = 603;
    public static final int UPDATE_MSG_ERROR = 605;
    public static final int DELETE_MSG_ERROR = 607;
    public static final int NODE_ILLEGAL = 701;

    // Define pageSize and page
    public static final int PAGING_SIZE_MINIMAL_VALUE = 1;
    public static final int PAGING_SIZE_MAXIMUM_VALUE = 20;
    public static final int ONEPAGE_SIZE_MAXIMUM_VALUE = 1200;
    public static final int PAGING_NUM_MINIMAL_VALUE = 1;
    public static final String RETMSG_PAGING_SIZE_NOVALID = "pageSize必须大于等于" + PAGING_SIZE_MINIMAL_VALUE + ",小于等于"
            + PAGING_SIZE_MAXIMUM_VALUE;
    public static final String RETMSG_PAGING_NUM_NOVALID = "pageNum必须大于等于" + PAGING_NUM_MINIMAL_VALUE;

    // Define rest request prefix
    public static final String REST_PREFIX = "/action";
}
