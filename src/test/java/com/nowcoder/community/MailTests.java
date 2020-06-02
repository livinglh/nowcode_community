package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {
    @Autowired
    private MailClient mailClient;
    @Autowired
    private TemplateEngine templateEngine;
    @Test
    public void testTextMail(){
        mailClient.sendMail("390866592@qq.com","test","welcome");
    }
    @Test
    public void testHtmlMail(){   //出错
        Context context = new Context();// thymeleaf的Context
        context.setVariable("username","sunday");
        String content = templateEngine.process("mail/demo",context);
        System.out.println(content);
        mailClient.sendMail("390866592@qq.com", "HTML",content);
    }


}