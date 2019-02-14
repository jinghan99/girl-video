package com.girl.video.config;

import com.girl.video.utils.PropertiesUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Package com.girl.video.config
 * @Description: 相当于 磁盘映射成了  http://localhost:8080/image/
 * @author: jingh
 * @date 2019/2/14 17:45
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //注意前面要加file,不然是访问不了的
        registry.addResourceHandler("/upload/**").addResourceLocations("file:"+ PropertiesUtils.getInstance().get("save_video_dir"));

    }
}
