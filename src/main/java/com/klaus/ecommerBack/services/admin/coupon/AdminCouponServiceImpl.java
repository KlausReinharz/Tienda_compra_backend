package com.klaus.ecommerBack.services.admin.coupon;

import com.klaus.ecommerBack.entity.Coupon;
import com.klaus.ecommerBack.exceptions.ValidationException;
import com.klaus.ecommerBack.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminCouponServiceImpl implements AdminCouponService{
    private final CouponRepository couponRepository;

    public Coupon createCoupon(Coupon coupon){
        if(couponRepository.existsByCode(coupon.getCode())){
            throw new ValidationException("Coupon code already exists.");
        }
        return couponRepository.save(coupon);
    }

    public List<Coupon>getAllCoupon(){
        return couponRepository.findAll();
    }


}
