package cn.jiyun.shop.user.service;

import java.util.List;

import cn.jiyun.shop.user.pojo.User;

public interface UserService {

	//注册
	void addUser(User user);

	//异步效验
	List<User> xiaoyan(User user);

	//登录
	List<User> loginUsernameAndPassword(User user);


}
