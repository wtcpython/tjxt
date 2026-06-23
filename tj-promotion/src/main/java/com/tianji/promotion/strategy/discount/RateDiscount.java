package com.tianji.promotion.strategy.discount;

import com.tianji.common.utils.NumberUtils;
import com.tianji.promotion.domain.po.Coupon;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@RequiredArgsConstructor
public class RateDiscount implements Discount {

    private static final String RULE_TEMPLATE = "满%s打%s折，上限%s元";

    @Override
    public boolean canUse(int totalAmount, Coupon coupon) {
        return totalAmount >= coupon.getThresholdAmount();
    }

    @Override
    public int calculateDiscount(int totalAmount, Coupon coupon) {
        // 计算折扣，扩大100倍计算，向下取整，单位是分
        return Math.min(coupon.getMaxDiscountAmount(), totalAmount * (100 - coupon.getDiscountValue()) / 100);
    }

    @Override
    public String getRule(Coupon coupon) {
        return String.format(
                RULE_TEMPLATE,
                NumberUtils.scaleToStr(coupon.getThresholdAmount(), 2),
                NumberUtils.scaleToStr(coupon.getDiscountValue(), 1),
                NumberUtils.scaleToStr(coupon.getMaxDiscountAmount(), 2));
    }
}
