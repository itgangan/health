package com.health.bo;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class StatisticsBO {

    private Long id;
    private Integer date; // 日期（20180927）
    private Integer volume; // 量（毫升）
    private Boolean delete; // 是否删除

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
