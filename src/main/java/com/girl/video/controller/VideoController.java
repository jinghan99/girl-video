package com.girl.video.controller;

import com.girl.video.entity.R;
import com.girl.video.service.VideoInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.girl.video.controller
 * @Description: TODO
 * @author: jingh
 * @date 2019/2/11 15:09
 */
@RestController
public class VideoController {

    @Autowired
    private VideoInfoService videoInfoService;

    @GetMapping("/")
    public String index() {
        return "this is / ";
    }

    /**
     * 根据id查询详情
     * @param id
     * @return
     */
    @RequestMapping("/info")
    public R getById(@Param("id") long id) {

        return videoInfoService.getVideoInfoById(id);
    }

}
