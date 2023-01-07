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
public class MailClientTest {

    @Autowired
    private MailClient mailClient;


    @Autowired
    private TemplateEngine  templateEngine;


    @Test
    public void testTextMail() {
        mailClient.sendMail("2964921097@qq.com", "发送邮件测试", "Welcome.");
    }

    @Test
    public void testHtmlMail() {
        Context context=new Context();
        String content=templateEngine.process("/mail/activation",context);
        mailClient.sendMail("3431356162@qq.com", "发送邮件测试",
                content);
    }


}