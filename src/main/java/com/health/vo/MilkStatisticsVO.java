package com.health.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 奶量统计vo
 */
public class MilkStatisticsVO {
    private Integer volume; // 量（毫升）
    private Integer date; // 日期（20180422）

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this  );
    }
}
