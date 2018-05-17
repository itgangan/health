package com.health.controller;

import com.health.bo.MilkBO;
import com.health.service.MilkService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

@Named
public class MilkController {

    @Inject
    private static Logger logger;

    @Inject
    private MilkService milkService;

    @RequestMapping("/milk")
    public void saveMilk(@RequestParam int volume){

        MilkBO milk = new MilkBO();
        milk.setVolume(volume);
        milk.setGmtCreate(new Date());
        milkService.saveMilk(milk);

        logger.info("test logger inject");
    }
}
