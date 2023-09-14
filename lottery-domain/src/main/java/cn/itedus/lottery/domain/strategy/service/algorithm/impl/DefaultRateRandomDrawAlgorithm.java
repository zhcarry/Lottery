package cn.itedus.lottery.domain.strategy.service.algorithm.impl;

import cn.itedus.lottery.domain.strategy.model.vo.AwardRateInfo;
import cn.itedus.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * 必中奖策略抽奖，排掉已经中奖的概率，重新计算中奖范围
 */
@Component("defaultRateRandomDrawAlgorithm")
public class DefaultRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        BigDecimal differenceDenominator = BigDecimal.ZERO;

        // 排除已中奖的奖品id
        List<AwardRateInfo> differenceAwardRateList = new ArrayList<>();
        List<AwardRateInfo> awardRateInfoList = awardRateInfoMap.get(strategyId);
        for (AwardRateInfo awardRateInfo : awardRateInfoList) {
            if (excludeAwardIds.contains(awardRateInfo.getAwardId())) {
                continue;
            }
            differenceDenominator = differenceDenominator.add(awardRateInfo.getAwardRate());
            differenceAwardRateList.add(awardRateInfo);
        }

        if (differenceAwardRateList.size() == 0) {
            return "";
        } else if (differenceAwardRateList.size() == 1) {
            return differenceAwardRateList.get(0).getAwardId();
        }

        // 计算概率
        SecureRandom secureRandom = new SecureRandom();
        int randomVal = secureRandom.nextInt(100) + 1;

        int cursorVal = 0;
        String awardId = "";

        for (AwardRateInfo awardRateInfo : differenceAwardRateList) {
            int rateVal = awardRateInfo.getAwardRate()
                    .divide(differenceDenominator, 2, RoundingMode.UP)
                    .multiply(new BigDecimal(100)).intValue();
            if (rateVal + cursorVal >= randomVal) {
                awardId = awardRateInfo.getAwardId();
                break;
            }
            cursorVal += rateVal;
        }
        return awardId;
    }
}
