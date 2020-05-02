package com.debug.kill.server.service;

import com.debug.kill.model.entity.ItemKill;

import java.util.List;

/**
 * @Author: WYF
 * @Description: 接口
 * @Create: 2020-04-28 13:41
 * @Version: 1.0
 */
public interface IItemService {
    List<ItemKill> getKillItem() throws Exception;
    ItemKill getKillItemDetail(Integer id) throws Exception;
}
