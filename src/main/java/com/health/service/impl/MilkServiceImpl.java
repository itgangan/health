package com.health.service.impl;

import com.health.bo.MilkBO;
import com.health.dao.MilkDAO;
import com.health.dataobject.MilkDO;
import com.health.service.MilkService;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.Date;

@Named
@Transactional
public class MilkServiceImpl implements MilkService {

    @Inject
    private MilkDAO milkDao;

    @Override
    public void saveMilk(MilkBO milkBO) {
        MilkDO milkDO = new MilkDO();
        milkDO.setGmtModified(new Date());
        BeanUtils.copyProperties(milkBO, milkDO);
        milkDao.save(milkDO);
    }
}
