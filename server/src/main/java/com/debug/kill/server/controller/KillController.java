package com.debug.kill.server.controller;

import com.debug.kill.api.enums.StatusCode;
import com.debug.kill.api.response.BaseResponse;
import com.debug.kill.server.dto.KillDto;
import com.debug.kill.server.service.IKillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;


/**
 * @Author: WYF
 * @Description: 秒杀的controller
 * @Create: 2020/5/1 15:01
 * @Version: 1.0
 */
@Controller
public class KillController {
    private static final Logger log = LoggerFactory.getLogger(KillController.class);

    private static final String prefix = "kill";

    @Autowired
    private IKillService killService;
    /**
     * @Description: 创建秒杀订单
     * @Param: [dto, result]
     * @Return: com.debug.kill.api.response.BaseResponse
     * @Author: WYF
     * @Date: 2020/5/1 15:22
     */
    @RequestMapping(value = prefix+"/execute",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public BaseResponse execute(@RequestBody @Validated KillDto dto, BindingResult result) {
        /**
         * @Description: 判断传入参数是否问题
         * 上面使用注解@Validated和BindingResult对入参进行非空校验
         * 结合KillDto中的@NotNull一起使用
        */
        if (result.hasErrors()|| dto.getKillId()<=0) {
            return new BaseResponse(StatusCode.InvalidParams);
        }
        /**
         * @Description: 判断userId
        */

//        if (result.hasErrors()|| dto.getKillId()<=0) {
//            return new BaseResponse(StatusCode.InvalidParams);
//        }
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try{
            Boolean res = killService.killItemService(dto.getKillId(), dto.getUserId());
            if (!res) {
                return new BaseResponse(StatusCode.Fail.getCode(),"商品已抢购完毕或者不在抢购时间段哦!");
            }
        }catch(Exception e){
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }
}
