package com.health.service;

import com.health.bo.StatisticsBO;

import java.util.List;

public interface StastisticsService {

    List<StatisticsBO> listLatestWeek();
}
