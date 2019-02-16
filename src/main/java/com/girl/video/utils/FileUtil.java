package com.girl.video.utils;

import com.girl.video.db.entity.VideoInfoEntity;
import com.girl.video.task.VideoTask;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Package com.girl.video.utils
 * @Description: 文件操作类
 * @author: jingh
 * @date 2019/2/11 15:33
 */
public class FileUtil {

    private final static Logger logger = LoggerFactory.getLogger(VideoTask.class);
    /**
     * 获取文件夹下所有 视频文件 （递归）
     * @param
     * @return
     */
    public static List<File> getFileList(String path) {
        List<File> fileList = new ArrayList<>();
        File dir = new File(path);
        logger.info("path:"+path);
        System.out.println("{/home/cloud/downloads} dir.exists() : " +dir.exists());
        if(dir.exists()){
            File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
            logger.info("dir.listFiles() length:"+dir.listFiles().length);
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) { // 判断是文件还是文件夹
                        getFileList(files[i].getAbsolutePath()); // 获取文件绝对路径
                    } else if (isVideo(files[i])) { // 是否视频文件
                        fileList.add(files[i]);
                    } else {
                        continue;
                    }
                }
            }
        }
        return fileList;
    }

    /**
     * 判断文件是否视频文件
     * @param file
     * @return
     */
    public static boolean isVideo(File file)  {
//        .mp4 结尾 或 .flv 结尾 等等
        String reg = "(.mp4$|.flv$|.avi$|.rm$|.mkv$|.rmvb$|.wmv$|.avi$)";
        Pattern p = Pattern.compile(reg);
        if(p.matcher(file.getName()).find()){
            logger.info("判断文件是否视频文件 true--- 文件名：《{}》  ",file.getName());
            return true;
        }
        logger.info("判断文件是否视频文件 false--- 文件名：《{}》  ",file.getName());
        return false;
    }
    /**
     * 大批量移动文件至 目标文件夹
     * @param downloadVideoDir
     */
    public static void moveListFile(List<File> downloadVideoDir,String dirPath ) {
        for(File file : downloadVideoDir){
            String startPath = file.getAbsolutePath();
            String endPath = generateFilename( dirPath,file.getName());
            moveToFolders(startPath,file.getName(),endPath);
        }
    }


    /**
     * 文件移动
     * @param startPath 待移动的文件
     * @param fileName 文件名称
     * @param endPath 移动后的文件 路径
     */
    public static Boolean moveToFolders(String startPath, String fileName, String endPath){
        try {
            File startFile = new File(startPath);
            File fileEnd = new File(endPath);
            if(fileEnd.exists()){
                    logger.error("文件已经存在!");

                    delFile(startPath);
            }else{
                logger.info("文件移动中--- 文件名：《{}》 目标路径：{}",fileName,endPath);
                FileUtils.copyFile(startFile, new File(endPath));
                logger.info("文件移动完成--- 文件名：《{}》 目标路径：{}",fileName,endPath);
            }
            return true;
        } catch (Exception e) {
            logger.error("文件移动异常！文件名：《{}》 起始路径：{}",fileName,startPath);
            logger.error(e.toString(),e);
            return false;
        }
    }



    /**
     * 删除文件
     * @param path
     */
    public  static void delFile(String path){
        File dest = new File(path);
        if (dest.exists()) {
            if(dest.delete()){
                logger.info("文件删除成功！目标文件：{}",path);
            }else{
                logger.error("文件删除失败! 目标文件：{}",path);
            }
        }
    }

    /**
     * 绝对路径 文件保存 规范命名 封装
     * @return fileName 文件名
     */
    public static String generateFilename(String formatDirPath,String fileName) {
        String fileDir  = PropertiesUtils.getInstance().get("save_video_dir")+ formatDirPath;
        if(createDir(fileDir)){
            try {
                // 为文件夹赋权限
                Runtime.getRuntime().exec("chmod 777 "+fileDir);
            } catch (IOException e) {
                logger.error("为文件夹赋权限失败 chmod 777 "+fileDir,e.toString());
            }
        }
        return  fileDir +fileName;
    }



    /**
     * 创建目录
     *
     * @param destDirName
     *            目标目录名
     * @return 目录创建成功返回true，否则返回false
     */
    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            return true;
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        // 创建单个目录
        if (dir.mkdirs()) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        List<File> downloadVideoDirList = FileUtil.getFileList(PropertiesUtils.getInstance().get("download_video_dir"));
        for(File file : downloadVideoDirList){
            String startPath = file.getAbsolutePath();

            String  formatDirPath = DateUtils.MONTH_FORMAT.format(new Date()) ;
            String endPath = FileUtil.generateFilename(formatDirPath,file.getName());
            Boolean moveBoolean = FileUtil.moveToFolders(startPath, file.getName(), endPath);

            if(moveBoolean){
                VideoInfoEntity videoInfoEntity = new VideoInfoEntity();
                videoInfoEntity.setCreateTime(new Date());
                videoInfoEntity.setVideoName(file.getName());
                videoInfoEntity.setVideoType("");
                videoInfoEntity.setVideoUrl(formatDirPath+file.getName());
            }
        }
    }


}
