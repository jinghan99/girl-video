package com.girl.video.dao;

import com.girl.video.db.entity.VideoInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
@Repository
@Mapper
public interface VideoInfoMapper extends BaseMapper<VideoInfoEntity> {
	
}
