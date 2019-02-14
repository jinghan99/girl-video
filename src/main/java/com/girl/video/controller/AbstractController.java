package com.girl.video.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * Controller公共组件
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月8日 下午2:43:23
 */
public abstract class AbstractController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 生成随机的32位uuid
     *
     * @return
     */
    protected final static String getUUId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
	

	/**
	 * 重定向
	 * @param page
	 * @return 重定向全路径
	 */
	protected String redirect(String page) {
		return "redirect:".concat(page);
	}

	/**
	 * 返回文件流
	 * @param file
	 * @return
	 */
	protected ResponseEntity<FileSystemResource> export(File file,String fileName) {
		if (file == null) {
			return null;
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		try {
//			在页面内打开代码： inline  弹出保存框代码：attachment
			headers.add("Content-Disposition", "inline; filename=" +  new String(fileName.getBytes("gbk"),"iso8859-1"));
		} catch (UnsupportedEncodingException e) {
			headers.add("Content-Disposition", "inline; filename=" +fileName);
		}
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		return ResponseEntity
				.ok()
				.headers(headers)
				.contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				.body(new FileSystemResource(file));
	}
}
