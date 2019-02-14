package com.girl.video.task;

import com.girl.video.db.entity.VideoInfoEntity;
import com.girl.video.service.VideoInfoService;
import com.girl.video.utils.DateUtils;
import com.girl.video.utils.FileUtils;
import com.girl.video.utils.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @Package com.girl.video.task
 * @Description: 更新
 * @author: jingh
 * @date 2019/1/25 10:09
 */
@Component
public class VideoTask {

    private final static Logger logger  = LoggerFactory.getLogger(VideoTask.class);


    @Autowired
    private VideoInfoService videoInfoService;


    /**
     * 获取信息
     * 每小时执行
     */
    @Scheduled(cron = "0 0 0/1 * * ? ")
    public void getUpdateInfo() {
        logger.info("每小时执行一次！");
        List<File> downloadVideoDirList = FileUtils.getFileList(PropertiesUtils.getInstance().get("download_video_dir"));
        for(File file : downloadVideoDirList){
            String startPath = file.getAbsolutePath();
            String  formatDirPath = DateUtils.MONTH_FORMAT.format(new Date()) ;
            String endPath = FileUtils.generateFilename(formatDirPath,file.getName());
            Boolean moveBoolean = FileUtils.moveToFolders(startPath, file.getName(), endPath);
            if(moveBoolean){
                VideoInfoEntity videoInfoEntity = new VideoInfoEntity();
                videoInfoEntity.setCreateTime(new Date());
                videoInfoEntity.setVideoName(file.getName());
                videoInfoEntity.setVideoType("");
                videoInfoEntity.setVideoUrl(formatDirPath+file.getName());
                videoInfoService.saveVideoInfo(videoInfoEntity);
            }
        }
    }




}


