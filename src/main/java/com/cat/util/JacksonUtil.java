/*
 * Copyright (c) 2014, Baidu and/or its affiliates. All rights reserved.
 * Baidu PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.cat.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dom4j.DocumentHelper;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;

/**
 * 
 * This is a utility class used to convert between json string and java object
 * 
 *
 *
 */
public class JacksonUtil {

    // Initialize one ObjectMapper singleton instance which can be shared
    // globally
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Converts one object to json string
     * 
     * @param object
     * @return the json string
     */
    public static String convertObjectToJson(Object object) {
        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonData;

    }

    /**
     * 
     * @param inputStr
     *            the input json string
     * @param clazz
     *            the target class
     * @return the target object instance from json string
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static <T> T parseJsonToObject(String inputStr, Class<T> clazz) throws JsonParseException,
            JsonMappingException, IOException {
        T t1 = (T) objectMapper.readValue(inputStr, clazz);
        return t1;

    }

    /**
     * Judges if the input string is json type.
     * 
     * @param orginStr
     *            the input string
     * @return <tt>true</tt> if the input string is json type, otherwise
     *         <tt>false</tt>
     */
    public static boolean isJsonType(String orginStr) {
        // By default set the input string is not json type
        boolean isJsonType = false;
        try {
            objectMapper.readValue(orginStr, Object.class);
            // Reset the json type flag to true
            isJsonType = true;
        } catch (Exception e) {
            // it's not json type; that's fine, just continue
        }
        return isJsonType;
    }

    /**
     * Converts xml string to json string using org json library.
     * 
     * @param xmlStr
     *            the input xml string
     * @return the converted json string
     * @throws JSONException
     */
    public static String convertXmlToJson(String xmlStr) throws JSONException {
        String jsonStr = "";
        if (xmlStr != null && !xmlStr.trim().isEmpty()) {
            // Convert xml string to json string using org json library
            JSONObject jsonObject = XML.toJSONObject(xmlStr);
            jsonStr = jsonObject.toString();
        }

        return jsonStr;
    }

    /**
     * Judges the input string's type.
     * 
     * @param orginStr
     *            the input string
     * @return the input string's type
     */
    public static String judgeStrType(String orginStr) {

        // Set the default string type to html_text type
        String strType = ConstantUtil.STRING_TYPE_HTML_TEXT;

        /*
         * Set the input string type to html_text type if the input string is
         * null or null string
         */
        if (orginStr == null || orginStr.trim().isEmpty()) {
            return strType;
        }

        if (JacksonUtil.isJsonType(orginStr)) { // judge if the input string is
                                                // json type
            strType = ConstantUtil.STRING_TYPE_JSON;
        } else if (isXmlType(orginStr)) { // judge if the input string is xml
                                          // type
            strType = ConstantUtil.STRING_TYPE_XML;
        }

        return strType;

    }

    /**
     * Judges if the input string is xml type.
     * 
     * @param orginStr
     *            the input string
     * @return <tt>true</tt> if the input string is xml type, otherwise
     *         <tt>false</tt>
     */
    public static boolean isXmlType(String orginStr) {
        // By default set the input string is not xml type
        boolean isXmlType = false;
        try {
            // Use dom4j to judge if the input string is xml type
            DocumentHelper.parseText(orginStr);

            // Reset the xml type flag to true
            isXmlType = true;
        } catch (Exception e) {
            // it's not xml type; that's fine, just continue
        }
        return isXmlType;
    }

}
