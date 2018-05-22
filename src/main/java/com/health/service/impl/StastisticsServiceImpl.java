package com.health.service.impl;

import com.health.bo.StatisticsBO;
import com.health.dao.StatisticsDAO;
import com.health.dataobject.StatisticsDO;
import com.health.service.StastisticsService;
import com.health.util.POJOConvertUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@Transactional
public class StastisticsServiceImpl implements StastisticsService {

    @Inject
    private Logger logger;

    @Inject
    private StatisticsDAO statisticsDao;

    @Override
    public List<StatisticsBO> listLatestWeek() {
        Date sevendayAgo = DateUtils.addDays(new Date(), -7);

        String sevendayAgoStr = DateFormatUtils.format(sevendayAgo, "yyyyMMdd");

        List<StatisticsDO> list = statisticsDao.findByDateGreaterThanEqual(NumberUtils.toInt(sevendayAgoStr));

        POJOConvertUtils<StatisticsDO, StatisticsBO> convert = new POJOConvertUtils<>();

        return convert.convert(list);
    }
}
