package com.girl.video.config;

import com.girl.video.utils.PropertiesUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Package com.girl.video.config
 * @Description: Java代码中覆盖默认静态资源配置
 * @author: jingh
 * @date 2019/2/14 17:45
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if(!registry.hasMappingForPattern("/static/**")){
            registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
        }
        //注意前面要加file,不然是访问不了的
        registry.addResourceHandler("/upload/**").addResourceLocations( ResourceUtils.FILE_URL_PREFIX+ PropertiesUtils.getInstance().get("save_video_dir"));

    }
}
