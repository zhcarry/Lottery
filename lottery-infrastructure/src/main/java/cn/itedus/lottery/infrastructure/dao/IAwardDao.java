package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.pojo.Award;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IAwardDao {

    Award queryAwardInfo(String awardId);

}
