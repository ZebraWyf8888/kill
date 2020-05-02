package com.debug.kill.model.mapper;


import com.debug.kill.model.entity.ItemKill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 待秒杀商品表 Mapper 接口
 * </p>
 *
 * @author WYF
 * @since 2020-04-28
 */
public interface ItemKillMapper {
    /**
     * @Description:获取所有商品以及秒杀信息
     * @Param: []
     * @Return: java.util.List<com.debug.kill.model.entity.ItemKill>
     * @Author: WYF
     * @Date: 2020/5/1 1:12
    */
    List<ItemKill> selectAll();



    int updateKillItem(@Param("killId") Integer killId);



    ItemKill selectByIdV2(@Param("id") Integer id);

    int updateKillItemV2(@Param("killId") Integer killId);

    /**
     * @Description:获取某个秒杀商品的细节
     * @Param: [id]
     * @Return: com.debug.kill.model.entity.ItemKill
     * @Author: WYF
     * @Date: 2020/5/1 1:13
    */
    ItemKill getDetail(@Param("id") Integer id);
}
