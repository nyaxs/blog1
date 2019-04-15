package nyaxs.blog.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/*
 * 遇到异常的时
 * 处理器适配器来调用此异常解析器
 */
public class BlogExceptionResolver implements HandlerExceptionResolver{
/*
    判断异常的信息: 如果是我们自定义的异常就直接获取异常信息
    然后跳转到错误页面:
    如果不是自定义异常, 那么给出一个未知错误的提示
*/
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception ex) {
		ModelAndView mav = new ModelAndView();
		BlogException be = null;
		//判断捕获异常是否为自定义异常
		if(ex instanceof BlogException) {
			be = (BlogException) ex;
			String exMesage = be.getExMessage();
			mav.addObject("errMessage", exMesage);
		}else {
			mav.addObject("errMessage", "未知错误，请联系管理员");
		}
		mav.setViewName("error");
		return mav;
	}

}
