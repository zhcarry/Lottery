package cn.itedus.lottery.domain.strategy.repository;

import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.infrastructure.pojo.Award;

public interface IStrategyRepository {
    /**
     * 根据策略Id查询抽奖策略
     * @param strategyId
     * @return
     */
    StrategyRich queryStrategyRich(Long strategyId);

    /**
     * 根据奖品Id查询奖品信息
     * @param awardId
     * @return
     */
    Award queryAwardInfo(String awardId);

}
