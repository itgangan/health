package com.health.dao;

import com.health.dataobject.MilkDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * 喂奶记录DAO接口
 */
public interface MilkDAO extends JpaRepository<MilkDO, Long> {

    /**
     * 通过id查找喂奶记录
     *
     * @param id 要查找的id
     * @return
     */
    MilkDO findById(long id);

    /**
     * 更新Milk
     *
     * @param milkDO 要更新喂奶记录
     * @return
     */
    MilkDO update(MilkDO milkDO);

    /**
     * 插入一条喂奶记录
     *
     * @param maikDO 喂奶记录
     * @return
     */
    MilkDO save(MilkDO maikDO);

    /**
     * 查找某个时段的所有的喂奶记录
     *
     * @param start
     * @param end
     * @return
     */
    List<MilkDO> findByGmtCreateBetween(Date start, Date end);

}
