package com.linyangkai.mallmember.dao;

import com.linyangkai.mallmember.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author linyangkai
 * @email 819450837@qq.com
 * @date 2023-04-23 16:37:37
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
