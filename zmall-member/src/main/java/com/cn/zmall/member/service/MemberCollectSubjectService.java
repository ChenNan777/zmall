package com.cn.zmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.zmall.common.utils.PageUtils;
import com.cn.zmall.member.entity.MemberCollectSubjectEntity;

import java.util.Map;

/**
 * 会员收藏的专题活动
 *
 * @author chennan
 * @email 905394587@qq.com
 * @date 2023-08-14 14:55:30
 */
public interface MemberCollectSubjectService extends IService<MemberCollectSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

