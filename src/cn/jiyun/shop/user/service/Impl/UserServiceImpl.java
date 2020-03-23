package cn.jiyun.shop.user.service.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jiyun.shop.user.mapper.UserMapper;
import cn.jiyun.shop.user.pojo.User;
import cn.jiyun.shop.user.pojo.UserExample;
import cn.jiyun.shop.user.pojo.UserExample.Criteria;
import cn.jiyun.shop.user.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	//注册
	@Override
	public void addUser(User user) {
		//激活码
		user.setCode(UUID.randomUUID().toString().replace("-","")+UUID.randomUUID().toString().replace("-",""));
		//状态码   0-未激活    1-激活
		user.setState(1);
		
		userMapper.insert(user);
		
	}

	//异步效验
	@Override
	public List<User> xiaoyan(User user) {
		//封装条件
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		List<User> ulist = userMapper.selectByExample(example);
		
		return ulist;
	}

	@Override
	public List<User> loginUsernameAndPassword(User user) {
		
		//封装条件
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		criteria.andPasswordEqualTo(user.getPassword());
		
		List<User> ulist = userMapper.selectByExample(example);
		
		return ulist;
	}

}
