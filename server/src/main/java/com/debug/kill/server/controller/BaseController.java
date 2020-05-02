package com.debug.kill.server.controller;

import com.debug.kill.api.enums.StatusCode;
import com.debug.kill.api.response.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: WYF
 * @Description: 基础，页面跳转
 * @Create: 2020/4/25 23:23
 * @Version: 1.0
 */
@Controller
@RequestMapping("base")
public class BaseController {
    /**
     * @Description: model封装数据，在model返回
     * @Param: [name, modelMap]
     * @Return: java.lang.String
     * @Author: WYF
     * @Date: 2020/4/27 15:07
    */
    @GetMapping("/welcome")
    public String welcome(String name, ModelMap modelMap) {
        if (StringUtils.isEmpty(name)) {
            name = "这是welcome";
        }
        modelMap.put("name", name);
        return "welcome";
    }

    /**
     * @Description: 前端发起请求获取数据
     * @Param: [name]
     * @Return: java.lang.String
     * @Author: WYF
     * @Date: 2020/4/27 15:07
    */
    @RequestMapping(value = "/data",method = RequestMethod.GET)
    @ResponseBody
    public String data(String name){
        if (StringUtils.isEmpty(name)) {
            name = "这是welcome页面，我进行了修改,我又改了,我改改改";
            name+="这是welcome页面，我进行了修改,我又改了,我改改改";
            name+= "这我又改了";
            name+="你好你好啊啊啊";

        }
        return name;
    }

    /**
     * @Description: 标准的json返回
     * @Param: [name]
     * @Return: com.debug.kill.api.response.BaseResponse
     * @Author: WYF
     * @Date: 2020/4/27 15:11
    */
    @GetMapping("/response")
    @ResponseBody
    public BaseResponse response(String name){
        BaseResponse baseResponse = new BaseResponse<>(StatusCode.Success);
        if (StringUtils.isEmpty(name)) {
            name = "这是欢迎页面,欢迎你,欢迎你";
        }
        baseResponse.setData(name);
        return baseResponse;
    }
    /**
     * @Description: 错误页面跳转
     * @Param: []
     * @Return: java.lang.String
     * @Author: WYF
     * @Date: 2020/4/27 15:14
    */
    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String error(){
        return "error";
    }
}
