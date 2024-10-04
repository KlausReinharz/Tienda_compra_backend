package com.klaus.ecommerBack.services.admin.coupon;

import com.klaus.ecommerBack.entity.Coupon;

import java.util.List;

public interface AdminCouponService {
    Coupon createCoupon(Coupon coupon);
    List<Coupon> getAllCoupon();
}
