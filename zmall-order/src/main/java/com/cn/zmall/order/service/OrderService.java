package com.cn.zmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.zmall.common.utils.PageUtils;
import com.cn.zmall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author chennan
 * @email 905394587@qq.com
 * @date 2023-08-14 14:39:48
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

