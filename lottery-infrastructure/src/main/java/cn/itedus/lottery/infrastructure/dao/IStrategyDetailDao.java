package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.pojo.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IStrategyDetailDao {

    List<StrategyDetail> queryStrategyDetailList(Long strategyId);

}
