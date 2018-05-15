package com.health.bo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public class MilkBO {

    private Long id;
    private Integer volume; // 量（毫升）
    private Date gmtCreate; // 创建时间

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
