package com.cn.zmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.zmall.common.utils.PageUtils;
import com.cn.zmall.member.entity.MemberLoginLogEntity;

import java.util.Map;

/**
 * 会员登录记录
 *
 * @author chennan
 * @email 905394587@qq.com
 * @date 2023-08-14 14:55:31
 */
public interface MemberLoginLogService extends IService<MemberLoginLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

