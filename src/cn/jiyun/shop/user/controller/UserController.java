package cn.jiyun.shop.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jiyun.shop.user.pojo.User;
import cn.jiyun.shop.user.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//去注册页面
	@RequestMapping("registPage")
	public String registPage(){
		
		return "regist";
	}
	
	//注册
	@RequestMapping("regist")
	public String regist(User user,String captcha,HttpServletRequest request){
		
		//从session域中获取自动生成的验证码的值 
		String checkcode = (String) request.getSession().getAttribute("checkcode");
		//判断输入的 和 自动生成的 是否一致
		if(checkcode.equalsIgnoreCase(captcha)){
			
			userService.addUser(user);
			
			return "msg";
		}else{
			request.setAttribute("aaa", "验证码不匹配！！！");
			return "regist";
		}
		
	}
	
	//异步效验
	 @RequestMapping("xiaoyan")
	 public void xiaoyan(User user,HttpServletResponse httpServletResponse) throws IOException{
		 
		 List<User> ulist = userService.xiaoyan(user);
		 //判断用户名是否存在
		 if(ulist.size()>0){
			 httpServletResponse.getWriter().print("false");
		 }
		  
	 }
	 
	 
	//去登录页面
		@RequestMapping("loginPage")
		public String loginPage(){
			
			return "login";
		}
	
		
	//登录
	@RequestMapping("login")
	public String login(User user,String captcha,HttpServletRequest request){
		
		//从session域中获取自动生成的验证码的值 
		String checkcode = (String) request.getSession().getAttribute("checkcode");
		//判断输入的 和 自动生成的 是否一致
		if(checkcode.equalsIgnoreCase(captcha)){
			
			//先去查询登录的用户名和密码
			List<User> ulist = userService.loginUsernameAndPassword(user);
			//判断登录的用户名和密码
			if(ulist.size()>0){
				//可以登录 登录成功把信息存入到session域
				request.getSession().setAttribute("user", ulist.get(0));
				//重定向到首页
				return "redirect:/index.action";
			}else{
				request.setAttribute("bbb", "用户名或密码错误！！！");
				return "login";
			}
			
		}else{
			request.setAttribute("aaa", "验证码不匹配！！！");
			return "login";
		}
		
	}
	
	//退出
	@RequestMapping("exit")
	public String exit(HttpServletRequest request){
		
		//直接销毁session
		request.getSession().invalidate();
		
		return "redirect:/index.action";
	}

}
