package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.pojo.Strategy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IStrategyDao {

    Strategy queryStrategy(Long strategyId);

}
