package com.debug.kill.server.service;

/**
 * @Author: WYF
 * @Description: 接口
 * @Create: 2020-05-01 15:41
 * @Version: 1.0
 */
public interface IKillService {
    /**
     * @Description: 创建秒杀订单
     * @Param: [kId, uId] ；秒杀订单编号，用户id
     * @Return: java.lang.Boolean
     * @Author: WYF
     * @Date: 2020/5/1 15:43
    */
    Boolean killItemService(Integer kId,Integer uId)throws Exception;
}
