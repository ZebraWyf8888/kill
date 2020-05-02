package com.debug.kill.server.dto;/**
 * Created by Administrator on 2019/6/17.
 */

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author:debug (SteadyJack)
 * @Date: 2019/6/17 22:18
 **/
@Data
@ToString
public class KillDto implements Serializable{
    public Integer getKillId() {
        return killId;
    }

    public void setKillId(Integer killId) {
        this.killId = killId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @NotNull
    private Integer killId;

    private Integer userId;
}