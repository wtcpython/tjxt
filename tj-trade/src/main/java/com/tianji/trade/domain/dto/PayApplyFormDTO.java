package com.tianji.trade.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "支付申请信息")
public class PayApplyFormDTO {
    @Schema(description = "订单id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "订单id不能为空")
    private Long orderId;

    @Schema(description = "支付渠道码，wxPay,aliPay", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "支付渠道码不能为空")
    private String payChannelCode;
}
