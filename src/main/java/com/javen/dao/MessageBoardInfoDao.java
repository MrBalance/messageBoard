package com.javen.dao;

import com.javen.model.MessageBoardInfo;
import com.javen.model.MessageBoardInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageBoardInfoDao {
    long countByExample(MessageBoardInfoExample example);

    int deleteByExample(MessageBoardInfoExample example);

    int deleteByPrimaryKey(Integer messageInfoId);

    int insert(MessageBoardInfo record);

    int insertSelective(MessageBoardInfo record);

    List<MessageBoardInfo> selectByExample(MessageBoardInfoExample example);

    MessageBoardInfo selectByPrimaryKey(Integer messageInfoId);

    int updateByExampleSelective(@Param("record") MessageBoardInfo record, @Param("example") MessageBoardInfoExample example);

    int updateByExample(@Param("record") MessageBoardInfo record, @Param("example") MessageBoardInfoExample example);

    int updateByPrimaryKeySelective(MessageBoardInfo record);

    int updateByPrimaryKey(MessageBoardInfo record);
}