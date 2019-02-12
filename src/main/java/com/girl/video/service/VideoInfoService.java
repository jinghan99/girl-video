package com.girl.video.service;

import com.girl.video.db.entity.VideoInfoEntity;
import com.girl.video.entity.Page;
import com.girl.video.entity.R;

import java.util.Map;

/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public interface VideoInfoService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<VideoInfoEntity> listVideoInfo(Map<String, Object> params);

    /**
     * 新增
     * @param videoInfo
     * @return
     */
	R saveVideoInfo(VideoInfoEntity videoInfo);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	R getVideoInfoById(Long id);

    /**
     * 修改
     * @param videoInfo
     * @return
     */
	R updateVideoInfo(VideoInfoEntity videoInfo);

    /**
     * 删除
     * @param id
     * @return
     */
	R batchRemove(Long[] id);
	
}
