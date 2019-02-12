package com.girl.video.task;

import com.girl.video.utils.FileUtils;
import com.girl.video.utils.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Package com.girl.video.task
 * @Description: 更新
 * @author: jingh
 * @date 2019/1/25 10:09
 */
@Component
public class VideoTask {

    private final static Logger logger  = LoggerFactory.getLogger(VideoTask.class);




    /**
     * 获取信息
     * 每小时执行
     */
    @Scheduled(cron = "0 0 0/1 * * ? ")
    public void getUpdateInfo() {
        logger.info("每小时执行一次！");
        FileUtils.getFileList(PropertiesUtils.getInstance().get("download_video_dir"));
    }




}


