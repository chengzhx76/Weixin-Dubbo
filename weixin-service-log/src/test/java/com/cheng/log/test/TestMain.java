package com.cheng.log.test;

import com.cheng.weixin.rpc.log.service.RpcLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Desc:
 * Author: hp
 * Date: 2016/10/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-context.xml"})
public class TestMain {
    @Autowired
    private RpcLogService logService;

    /**
     * <dependency>
     *   <groupId>com.baomidou</groupId>
     *   <artifactId>mybatis-plus</artifactId>
     *   <version>1.4.9</version>
     * </dependency>
     *
     * DAO
     * List<Log> selectLogList(Pagination page, Log log);
     *
     * Service
     * Page<Log> selectLogPage(Page<Log> page, Log log);
     *
     * @Override
     * public Page<Log> selectLogPage(Page<Log> page, Log log) {
     *     List<Log> logs = logDao.selectLogList(page, log);
     *     page.setRecords(logs);
     *     return page;
     * }
     *
     * <select id="selectLogList" parameterType="log" resultType="log">
     *   <include refid="logSelector"/>
     *   <include refid="logWhere"/>
     * </select>
     */

    @Test
    public void test01() {

        //Log log = new Log();
        //log.setStatus(Status.LOCKED);
        //Page<Log> logs = logService.selectLogPage(new Page<Log>(0, 5), log);
        //System.out.println(JSON.toJSONString(logs));

    }

}
