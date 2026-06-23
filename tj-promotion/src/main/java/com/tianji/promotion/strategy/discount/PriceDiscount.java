package com.tianji.promotion.strategy.discount;

import com.tianji.common.utils.NumberUtils;
import com.tianji.promotion.domain.po.Coupon;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@RequiredArgsConstructor
public class PriceDiscount implements Discount {

    private static final String RULE_TEMPLATE = "满%s减%s";

    @Override
    public boolean canUse(int totalAmount, Coupon coupon) {
        return totalAmount >= coupon.getThresholdAmount();
    }

    @Override
    public int calculateDiscount(int totalAmount, Coupon coupon) {
        return coupon.getDiscountValue();
    }

    @Override
    public String getRule(Coupon coupon) {
        return String.format(
                RULE_TEMPLATE,
                NumberUtils.scaleToStr(coupon.getThresholdAmount(), 2),
                NumberUtils.scaleToStr(coupon.getDiscountValue(), 2));
    }
}
