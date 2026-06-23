package com.tianji.pay.sdk.constants;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum PayChannel {
    wxPay("微信支付"),
    aliPay("支付宝支付"),
    ;

    private final String desc;

    PayChannel(String desc) {
        this.desc = desc;
    }

    public static String desc(String value) {
        if (StringUtils.isBlank(value)) {
            return "";
        }
        return PayChannel.valueOf(value).getDesc();
    }
}
