package cn.itedus.lottery.domain.strategy.service.draw;

import cn.itedus.lottery.domain.strategy.model.req.DrawReq;
import cn.itedus.lottery.domain.strategy.model.res.DrawResult;

/**
 * 对外暴露的抽奖接口
 */
public interface IDrawExec {
    /**
     * 抽奖
     * @param req
     * @return
     */
    DrawResult doDrawExec(DrawReq req);

}
