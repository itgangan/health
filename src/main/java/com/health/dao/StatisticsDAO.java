package com.health.dao;

import com.health.dataobject.StatisticsDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.inject.Named;
import java.util.List;

@Named
public interface StatisticsDAO extends JpaRepository<StatisticsDO, Long> {

    /**
     * 过去某段时间的统计
     * @param date 例20180523
     * @return
     */
    List<StatisticsDO> findByDateGreaterThanEqual(int date);
}
