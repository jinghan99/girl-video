package com.girl.video.controller;

import com.girl.video.db.entity.VideoInfoEntity;
import com.girl.video.entity.Page;
import com.girl.video.entity.R;
import com.girl.video.service.VideoInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Package com.girl.video.controller
 * @Description: TODO
 * @author: jingh
 * @date 2019/2/11 15:09
 */
@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoInfoService videoInfoService;


    /**
     * 列表
     * @param params
     * @return
     */
    @RequestMapping("/list")
    public Page<VideoInfoEntity> list(@RequestBody Map<String, Object> params) {
        return videoInfoService.listVideoInfo(params);
    }
    /**
     * 新增
     * @param videoInfo
     * @return
     */
    @RequestMapping("/save")
    public R save(@RequestBody VideoInfoEntity videoInfo) {
        return videoInfoService.saveVideoInfo(videoInfo);
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
    /**
     * 修改
     * @param videoInfo
     * @return
     */
    @RequestMapping("/update")
    public R update(@RequestBody VideoInfoEntity videoInfo) {
        return videoInfoService.updateVideoInfo(videoInfo);
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/remove")
    public R batchRemove(@RequestBody Long[] id) {
        return videoInfoService.batchRemove(id);
    }

}
