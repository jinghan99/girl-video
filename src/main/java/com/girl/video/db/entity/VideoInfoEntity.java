package com.girl.video.db.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * @author ZhouChenglin<yczclcn@163.com>
 */
public class VideoInfoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * id
	 */
	private Integer videoId;
	
	/**
	 * 影片名称
	 */
	private String videoName;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 影片类型
	 */
	private String videoType;
	
	/**
	 * 本地储存地址
	 */
	private String videoUrl;
	

	public VideoInfoEntity() {
		super();
	}

    /**
     * setter for videoId
     * @param videoId
     */
	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

    /**
     * getter for videoId
     */
	public Integer getVideoId() {
		return videoId;
	}
	
    /**
     * setter for videoName
     * @param videoName
     */
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

    /**
     * getter for videoName
     */
	public String getVideoName() {
		return videoName;
	}
	
    /**
     * setter for createTime
     * @param createTime
     */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

    /**
     * getter for createTime
     */
	public Date getCreateTime() {
		return createTime;
	}
	
    /**
     * setter for videoType
     * @param videoType
     */
	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}

    /**
     * getter for videoType
     */
	public String getVideoType() {
		return videoType;
	}
	
    /**
     * setter for videoUrl
     * @param videoUrl
     */
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

    /**
     * getter for videoUrl
     */
	public String getVideoUrl() {
		return videoUrl;
	}
	
}
