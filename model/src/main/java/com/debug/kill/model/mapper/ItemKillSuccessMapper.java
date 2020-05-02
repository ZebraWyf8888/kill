package com.debug.kill.model.mapper;


import com.debug.kill.model.entity.ItemKillSuccess;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 秒杀成功订单表 Mapper 接口
 * </p>
 *
 * @author WYF
 * @since 2020-04-28
 */
public interface ItemKillSuccessMapper {
//    int deleteByPrimaryKey(String code);
//
//    int insert(ItemKillSuccess record);
//
    int insertSelective(ItemKillSuccess record);
//
//    ItemKillSuccess selectByPrimaryKey(String code);
//
//    int updateByPrimaryKeySelective(ItemKillSuccess record);
//
//    int updateByPrimaryKey(ItemKillSuccess record);
//
    int countByKillUserId(@Param("killId") Integer killId, @Param("userId") Integer userId);


//
//   // KillSuccessUserInfo selectByCode(@Param("code") String code);
//
//    int expireOrder(@Param("code") String code);
//
//    List<ItemKillSuccess> selectExpireOrders();
}
