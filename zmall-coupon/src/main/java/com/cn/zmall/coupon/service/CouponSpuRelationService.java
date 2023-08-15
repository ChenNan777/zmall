package com.cn.zmall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.zmall.common.utils.PageUtils;
import com.cn.zmall.coupon.entity.CouponSpuRelationEntity;

import java.util.Map;

/**
 * 优惠券与产品关联
 *
 * @author chennan
 * @email 905394587@qq.com
 * @date 2023-08-14 14:52:07
 */
public interface CouponSpuRelationService extends IService<CouponSpuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

