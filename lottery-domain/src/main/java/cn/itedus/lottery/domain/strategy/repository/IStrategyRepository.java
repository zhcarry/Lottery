package cn.itedus.lottery.domain.strategy.repository;

import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.vo.AwardBriefVO;

import java.util.List;

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
    AwardBriefVO queryAwardInfo(String awardId);

    /**
     * 根据策略ID查询该策略下库存不足的奖品列表
     * @param strategyId 策略ID
     * @return
     */
    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * 扣减库存 根据mysql 行级锁暂扣库存
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     * @return           扣减结果
     */
    boolean deductStock(Long strategyId, String awardId);

}
