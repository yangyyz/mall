package com.linyangkai.mallmember.feign;


import com.linyangkai.common.utils.R;
import java.util.Arrays;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "mall-coupon")
public interface CouponFeignService {
  @RequestMapping("mallcoupon/coupon/member/list")
  public R memberCoupon();
}
