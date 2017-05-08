package com.qf.farmer.neo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qf.farmer.neo.domain.User;
import com.qf.farmer.neo.service.UserService;
import com.qf.farmer.neo.util.Neo4jConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Neo4jConfig.class})
public class UserServiceTest {
    @Autowired
    private UserService userService;
    /**
     * 因为是通过http连接到Neo4j数据库的，所以要预先启动Neo4j：neo4j console
     */
    @Test
    public void testInitData(){
        userService.initData();
    }
    @Test
    public void testGetUserByName(){
        User user = userService.getUserByName("John Johnson");
        System.out.println(user);
    }
}