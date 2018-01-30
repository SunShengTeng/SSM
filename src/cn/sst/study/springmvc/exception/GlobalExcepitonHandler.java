package cn.sst.study.springmvc.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class GlobalExcepitonHandler implements HandlerExceptionResolver {

	
	private String exceptionMsg;
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object oj,
			Exception exception) {
		ModelAndView modelAndView = new ModelAndView();
		
		// 判断异常类型
		if (exception instanceof MyException) { 
			// 处理预期异常
			; 
			exceptionMsg = exception.getMessage();
		}else {
			// 如果是运行时异常，则取错误堆栈，从堆栈中获取异常信息
			Writer out = new StringWriter();
			PrintWriter s = new PrintWriter(out);
			exception.printStackTrace(s);
			exceptionMsg = out.toString();

		}
		
		modelAndView.addObject("msg", exceptionMsg);
		modelAndView.setViewName("404");
		return modelAndView;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	

}
