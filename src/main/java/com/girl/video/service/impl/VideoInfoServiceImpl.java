package com.girl.video.service.impl;

import java.util.Map;

import com.girl.video.dao.VideoInfoMapper;
import com.girl.video.db.entity.VideoInfoEntity;
import com.girl.video.entity.Page;
import com.girl.video.entity.Query;
import com.girl.video.entity.R;
import com.girl.video.service.VideoInfoService;
import com.girl.video.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@Service("videoInfoService")
public class VideoInfoServiceImpl implements VideoInfoService {

	@Autowired
	private VideoInfoMapper videoInfoMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<VideoInfoEntity> listVideoInfo(Map<String, Object> params) {
		Query query = new Query(params);
		Page<VideoInfoEntity> page = new Page<>(query);
		videoInfoMapper.listForPage(page, query);
		return page;
	}

    /**
     * 新增
     * @param videoInfo
     * @return
     */
	@Override
	public R saveVideoInfo(VideoInfoEntity videoInfo) {
		int count = videoInfoMapper.save(videoInfo);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public R getVideoInfoById(Long id) {
		VideoInfoEntity videoInfo = videoInfoMapper.getObjectById(id);
		return CommonUtils.msg(videoInfo);
	}

    /**
     * 修改
     * @param videoInfo
     * @return
     */
	@Override
	public R updateVideoInfo(VideoInfoEntity videoInfo) {
		int count = videoInfoMapper.update(videoInfo);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public R batchRemove(Long[] id) {
		int count = videoInfoMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
