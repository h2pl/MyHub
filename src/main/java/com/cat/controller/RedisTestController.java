package com.cat.controller;



/**
 * Created by 周杰伦 on 2018/2/8.
 */
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cat.entity.CommonResponseEntity;
import com.cat.util.ConstantUtil;
import com.cat.util.RedisTemplateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制层
 * @author xbq
 */
@Controller
@RequestMapping("redis/")
public class RedisTestController {

    @Resource(name = "redisTemplateUtil")
    private RedisTemplateUtil redisTemplateUtil;

    // 查询数据
    @ResponseBody
    @RequestMapping(value = "getValue", method = RequestMethod.GET)
    public CommonResponseEntity getValue(String key){
        CommonResponseEntity cre = new CommonResponseEntity();
        cre.setRetCode(ConstantUtil.RETCODE_CORRECT);
        redisTemplateUtil.set("a","b");
        String re = (String) redisTemplateUtil.get("a");
        cre.setRetData(re);
        return cre;
    }

    @ResponseBody
    @RequestMapping(value = "getList", method = RequestMethod.GET)
    public CommonResponseEntity getList(String key){
        CommonResponseEntity cre = new CommonResponseEntity();
        cre.setRetCode(ConstantUtil.RETCODE_CORRECT);
        ArrayList<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        redisTemplateUtil.set("a", list);
        List re = (List) redisTemplateUtil.get("a");
        cre.setRetData(re);
        return cre;
    }

}
