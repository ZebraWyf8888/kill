package com.debug.kill.server.service.impl;

import com.debug.kill.model.entity.ItemKill;
import com.debug.kill.model.entity.ItemKillSuccess;
import com.debug.kill.model.mapper.ItemKillMapper;
import com.debug.kill.model.mapper.ItemKillSuccessMapper;
import com.debug.kill.server.enums.SysConstant;
import com.debug.kill.server.service.IKillService;
import com.debug.kill.server.service.RabbitSenderService;
import com.debug.kill.server.utils.SnowFlake;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KillService implements IKillService {
    @Autowired
    private ItemKillSuccessMapper itemKillSuccessMapper;

    private SnowFlake snowFlake=new SnowFlake(2,3);

    @Autowired
    private ItemKillMapper itemKillMapper;

    @Autowired
    private RabbitSenderService rabbitSenderService;

    @Override
    public Boolean killItemService(Integer kId, Integer uId) throws Exception{
        Boolean result = false;
        //看一下是不是已经抢购购过了
        if(itemKillSuccessMapper.countByKillUserId(kId, uId)<=0){
            //查询商品的详细信息
            ItemKill detail = itemKillMapper.getDetail(kId);
            //判断是否可以被秒杀canKill=1?
            if (detail != null && detail.getCanKill() ==1) {
                //减去库存,成功了就返回1
                int res = itemKillMapper.updateKillItem(kId);
                //减去库存成功，就建立秒杀订单
                if (res > 0) {
                    commRecordKillSuccessInfo(detail,uId);
                    return true;
                }
            }else {
                throw new Exception("当前商品不能秒杀");
            }
        }else{
            throw new Exception("您已经抢购过了");
        }
        return result;
    }

    private void commRecordKillSuccessInfo(ItemKill detail, Integer uId) {
        ItemKillSuccess itemKillSuccess = new ItemKillSuccess();
        //雪花算法生成订单id
        String s = String.valueOf(snowFlake.nextId());
        itemKillSuccess.setCode(s);

        //设置各部分的值
        itemKillSuccess.setItemId(detail.getItemId());
        itemKillSuccess.setCreateTime(DateTime.now().toDate());
        itemKillSuccess.setUserId(uId+"");
        itemKillSuccess.setKillId(detail.getId());
        itemKillSuccess.setStatus(SysConstant.OrderStatus.SuccessNotPayed.getCode().byteValue());

        int res = itemKillSuccessMapper.insertSelective(itemKillSuccess);
        //插入数据库
        if (res > 0) {
            //TODO:进行异步邮件消息的通知
            rabbitSenderService.sendKillSuccessEmailMsg(s);
        }

    }


}
