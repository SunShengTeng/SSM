package cn.sst.study.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import cn.sst.study.springmvc.pojo.Items;
import cn.sst.study.springmvc.pojo.wrap.QueryVo;
import cn.sst.study.springmvc.service.ItemService;

@Controller
@RequestMapping("/item")// 在class上添加@RequestMapping(url)指定通用请求前缀， 限制此类下的所有方法请求url必须以请求前缀开头
public class ItemController {
	@Autowired
	private ItemService itemServiceImpl;
	@RequestMapping(value={"/List.action","/List2.action"})
	public ModelAndView queryItemList(){
		ModelAndView modelAndView = new ModelAndView();
		List<Items> items = itemServiceImpl.queryItemList();
		// 添加模型数据，并指定视图路径
		modelAndView.addObject("itemList", items);
		modelAndView.setViewName("itemList");
		return modelAndView;
	}
	@RequestMapping("/Edit.action")
	public String findItemById(int id,Model model){
		Items item = itemServiceImpl.findItemById(id);
		model.addAttribute("item", item);
		return "editItem";
	}
	@RequestMapping("/update.action")
	public String updateItem(Items item,Model model,MultipartFile pictureFile) throws IOException{
		// 设置图片名称
		String name = UUID.randomUUID().toString();
		String originalFilename = pictureFile.getOriginalFilename();
		String extensionName = originalFilename.substring(originalFilename.lastIndexOf("."));
		// 保存图片
		pictureFile.transferTo(new File("/Users/sunshengteng/Java_project/upload/"+name+extensionName));
		// 更新item信息
		item.setPic(name+extensionName);
		
		itemServiceImpl.updateItem(item);
		return "forward:/item/Edit.action?id="+item.getId();
	}
	/**
	 * 数组类型参数封装
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete.action")
	public String deleteItem(Integer[] ids){
		System.out.println(ids.toString());
		return "redirect:/itemList.action";
	}
	/**
	 * 测试list类型参数封装
	 * RequestMapping:method={RequestMethod.POST,RequestMethod.GET}表示只能是POST，或者GET请求，否则报如下错误
	 * HTTP Status 405 - Request method 'GET' not supported
	 * @return
	 */
	@RequestMapping(value="/batchUpdate.action",method={RequestMethod.POST,RequestMethod.GET})
	public String batchUpdate(QueryVo vo){
		
		
		return "redirect:/item/List.action";
	}
	/**返回void
	 * 在Controller方法形参上可以定义request和response，使用request或response指定响应结果
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/test.action")
	public void testReturnVoid(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		// 转发
		// request.getRequestDispatcher("/WEB-INF/jsp/itemList.jsp").forward(request, response);
		// 重定向
		// response.sendRedirect(request.getContextPath()+"/item/List.action");
		// 相应JSON数据
		response.getWriter().print("{\"abc\":123}");
	}
	@RequestMapping("json.action")
	public @ResponseBody Items jsonTest(@RequestBody Items items){
		return items;
	}
}
