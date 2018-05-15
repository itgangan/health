package com.health.dao;

import com.health.dataobject.StatisticsDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatisticsDAO extends JpaRepository {

    /**
     * 过去某段时间的统计
     * @param date 例20180523
     * @return
     */
    List<StatisticsDO> findByDateGreaterThanEqual(int date);
}
