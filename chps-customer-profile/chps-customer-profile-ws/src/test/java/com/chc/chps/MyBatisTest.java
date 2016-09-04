package com.chc.chps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.chc.chps.application.Application;
import com.chc.chps.mapper.RockUserMapper;
import com.chc.chps.model.RockUser;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringApplicationConfiguration(Application.class)
public class MyBatisTest {

	@Autowired
	private RockUserMapper rockUserMapper;

	@Test
	@Rollback
	public void testInsertList() {
		List<RockUser> rockUsers = new ArrayList<RockUser>();
		rockUsers.add(new RockUser(1, "kerrigan1", "12345"));
		rockUsers.add(new RockUser(2, "kerrigan2", "12345"));
		Assert.assertEquals(2, rockUserMapper.insertUser(rockUsers));
		for (RockUser user : rockUsers) {
			Assert.assertNotNull(user.getId());
		}
	}

	@Test
	public void testSelectById() {
		List<RockUser> rockUsers = new ArrayList<RockUser>();
		rockUsers.add(new RockUser(1, "kerrigan1", "12345"));
		rockUserMapper.insertUser(rockUsers);
		RockUser user = rockUserMapper.selectUserById(1);
		Assert.assertNotNull(user);
		Assert.assertNotNull(user.getUsername());
		Assert.assertNotNull(user.getPassword());
	}

}
