package com.health.dao;

import com.health.dataobject.MilkDO;
import com.health.init.persistence.EntityManagerConfig;
import com.health.init.spring.RootConfig;
import com.health.init.spring.WebAppInitializer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.sql.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, EntityManagerConfig.class, WebAppInitializer.class})
public class MilkDaoTest {

    @Inject
    private MilkDAO milkDao;

    @Before
    public void setUp() {

    }

    @Test
    public void testSave() {
        Assert.assertNotNull("milkdao is null", milkDao);

        MilkDO milkDO = new MilkDO();
        milkDO.setVolume(2);
        Date date = new Date(System.currentTimeMillis());
        milkDO.setGmtCreate(date);
        milkDO.setGmtModified(date);

        milkDao.save(milkDO);
    }
}
