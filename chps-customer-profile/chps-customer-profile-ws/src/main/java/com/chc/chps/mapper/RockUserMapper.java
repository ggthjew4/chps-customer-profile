package com.chc.chps.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.chc.chps.model.RockUser;

public interface RockUserMapper {

	@Select("select * from rock_user where id = #{id}")
	public RockUser selectUserById(@Param("id") int id);

	public int insertUser(List<RockUser> users);

}
