package com.udacity.jwdnd.c1.review.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChatMessageMapper {
    @Select("SELECT * FROM MESSAGES")
    ChatMessage[] getUserMessages();

    @Select("SELECT * FROM MESSAGES WHERE messageid = #{messageid}")
    ChatMessage getMessage(int messageid);

    @Insert("INSERT INTO MESSAGES (messagetext, username) VALUES(#{messageText}, #{username})")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    int insert(ChatMessage message);

}
