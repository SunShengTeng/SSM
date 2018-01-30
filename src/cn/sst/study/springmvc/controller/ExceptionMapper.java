package cn.sst.study.springmvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sst.study.springmvc.exception.MyException;

/**
 * Error页面
 * @author sunshengteng
 *
 */
@Controller
@RequestMapping("/error")
public class ExceptionMapper {

	@RequestMapping("/pageNotFind.action")
	public void stepTo404(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/jsp/404.jsp").forward(request, response);
	}
	@RequestMapping("/test.action")
	public void testException() throws MyException{

//	    throw new MyException("电信全体员工一夜之间全死了～～～～");

		int i = 1/0;
	}
}

