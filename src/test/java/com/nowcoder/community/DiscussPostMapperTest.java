package com.nowcoder.community;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.service.DiscussPostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class DiscussPostMapperTest {

    @Autowired
    private DiscussPostService discussPostService;

    @Test
    public void test(){
        DiscussPost discussPost=new DiscussPost();
        discussPost.setUserId(101);
        discussPost.setTitle("123");
        discussPost.setContent("12345");
        discussPost.setCreateTime(new Date());
        discussPostService.addDiscussPost(discussPost);
    }

    @Test
    public void selectById(){
        DiscussPost discussPostById = discussPostService.findDiscussPostById(109);

        System.out.println(discussPostById);
    }

}
