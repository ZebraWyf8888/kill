package com.debug.kill.model.entity;

;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 秒杀成功订单表
 * </p>
 *
 * @author WYF
 * @since 2020-04-28
 */
@ToString
public class ItemKillSuccess implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 秒杀成功生成的订单编号
     */
    private String code;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getKillId() {
        return killId;
    }

    public void setKillId(Integer killId) {
        this.killId = killId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**

     * 商品id
     */
    private Integer itemId;

    /**
     * 秒杀id
     */
    private Integer killId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 秒杀结果: -1无效  0成功(未付款)  1已付款  2已取消
     */
    private Byte status;

    /**
     * 创建时间
     */
    private Date createTime;




}
