package com.debug.kill.server.service.impl;

import com.debug.kill.model.entity.ItemKill;
import com.debug.kill.model.mapper.ItemKillMapper;
import com.debug.kill.server.service.IItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements IItemService {
    private static final Logger log = LoggerFactory.getLogger(IItemService.class);

    @Autowired
    private ItemKillMapper itemKillMapper;

    @Override
    public List<ItemKill> getKillItem() throws Exception {
        List<ItemKill> itemKills = itemKillMapper.selectAll();
        return itemKills;
    }

    @Override
    public ItemKill getKillItemDetail(Integer id) throws Exception {
        ItemKill itemKill = itemKillMapper.getDetail(id);
        if (itemKill==null){
            throw new Exception("获取秒杀详情-待秒杀商品记录不存在");
        }
        return itemKill;
    }
}
