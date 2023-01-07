package com.nowcoder.community.service;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.util.SensitiveFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.nio.charset.IllegalCharsetNameException;
import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private SensitiveFilter sensitiveFilter;

    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }

    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }

    public int addDiscussPost(DiscussPost discussPost){
        if (discussPost == null) {
            throw  new IllegalArgumentException("参数不能为空");
        }
        //安全 转义
        // 转义HTML标记
        if (discussPost.getTitle()!=null){
            discussPost.setTitle(HtmlUtils.htmlEscape(discussPost.getTitle()));
        }
        if (discussPost.getContent()!=null){
            discussPost.setContent(HtmlUtils.htmlEscape(discussPost.getContent()));
        }
        //敏感词过滤
        discussPost.setTitle(sensitiveFilter.filter(discussPost.getTitle()));
        discussPost.setContent(sensitiveFilter.filter(discussPost.getContent()));
        return discussPostMapper.insertDiscussPost(discussPost);
    }

    public DiscussPost findDiscussPostById(int id){
        return discussPostMapper.selectDiscussPostsById(id);
    }
}
