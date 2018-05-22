package com.health.dao;

import com.health.dataobject.MilkDO;
import com.health.init.persistence.EntityManagerConfig;
import com.health.init.spring.RootConfig;
import com.health.init.spring.WebAppInitializer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import java.sql.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, EntityManagerConfig.class})
public class MilkDaoTest {

    @Inject
    private MilkDAO milkDao;

    @Test
    public void testSave() {
        Assert.assertNotNull("milkdao is null", milkDao);

        MilkDO milkDO = new MilkDO();
        milkDO.setVolume(8);
        Date date = new Date(System.currentTimeMillis());
        milkDO.setGmtCreate(date);
        milkDO.setGmtModified(date);

        milkDao.save(milkDO);
    }

    @Test
    public void testFindbyId(){
        MilkDO milk = milkDao.findById(1L);
        Assert.assertNotNull(milk);
        Assert.assertEquals(2, milk.getVolume().intValue());
    }

    @Test
    public void testUpdate(){
        MilkDO milk = milkDao.findById(1L);
        milk.setVolume(3);
        milk.setGmtModified(new Date(System.currentTimeMillis()));

        milkDao.save(milk);

        MilkDO milk1= milkDao.findById(1L);
        Assert.assertEquals(milk1.getVolume().intValue(), 3);
    }
}
