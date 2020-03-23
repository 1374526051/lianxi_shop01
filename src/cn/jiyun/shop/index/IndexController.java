package cn.jiyun.shop.index;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jiyun.shop.category.pojo.Category;
import cn.jiyun.shop.category.service.CategoryService;
import cn.jiyun.shop.product.pojo.Product;
import cn.jiyun.shop.product.service.ProductService;

@Controller
public class IndexController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("index")
	public String index(Model model,HttpServletRequest request){
		
		//查询一级分类的名称及关联的二级分类
		List<Category> clist = categoryService.findAllCategoryAndSecond();
		//存入model域
		//model.addAttribute("clist", clist);
		//存入session域
		request.getSession().setAttribute("clist", clist);
		
		//查询热门商品   is_hot=1  pdate 降序desc (默认asc)   只要10条 limit : 0-10
		List<Product> plist = productService.findAllProduct();
		model.addAttribute("plist", plist);
		
		//查询最新商品   pdate 降序desc (默认asc)   只要10条 limit : 0-10
		List<Product> nlist = productService.findNewProduct();
		model.addAttribute("nlist", nlist);
		
		return "index";
	}

}
