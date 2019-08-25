package com.example.springbootconfig;

import com.example.springbootconfig.config.CatConfig;
import com.example.springbootconfig.config.MyConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootConfigApplicationTests {

    @Autowired
    CatConfig catConfig;

    @Autowired
    MyConfig myConfig;

    @Test
    public void contextLoads() {
        System.out.println(catConfig.toString());
    }

    @Test
    public void myConfigLoads(){
        System.out.println(myConfig.toString());
    }

}
