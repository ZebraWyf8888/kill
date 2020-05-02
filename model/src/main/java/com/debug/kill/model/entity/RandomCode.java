package com.debug.kill.model.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author WYF
 * @since 2020-04-28
 */
public class RandomCode implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String code;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "RandomCode{" +
        "id=" + id +
        ", code=" + code +
        "}";
    }
}
