package com.girl.video.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统页面视图
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月9日 下午3:33:00
 */
@Controller
public class PageController extends AbstractController {

	/**
	 * 页面跳转
	 * @param module
	 * @param url
	 * @return
	 */
	@GetMapping("{module}/{url}.html")
	public String page(@PathVariable("module") String module,  @PathVariable("url") String url) {
		return module+"/" +url;
	}

}
