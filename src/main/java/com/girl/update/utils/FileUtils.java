package com.girl.update.utils;

import com.girl.update.task.VideoTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Package com.girl.update.utils
 * @Description: 文件操作类
 * @author: jingh
 * @date 2019/2/11 15:33
 */
public class FileUtils {

    private final static Logger logger = LoggerFactory.getLogger(VideoTask.class);
    /**
     * 获取文件夹下所有 文件 递归
     * @param
     * @return
     */
    public static List<File> getFileList(String path) {
        List<File> fileList = new ArrayList<>();
        File dir = new File(path);
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) { // 判断是文件还是文件夹
                    getFileList(files[i].getAbsolutePath()); // 获取文件绝对路径
                } else if (fileName.endsWith("mp4")) { // 判断文件名是否以.avi结尾
                    String startPath = files[i].getAbsolutePath();
                    String endPath = generateFilename(fileName);
                    moveTotherFolders(startPath,fileName,endPath);
                    fileList.add(files[i]);
                } else {
                    continue;
                }
            }
        }
        return fileList;
    }


    /**
     * 文件移动
     * @param startPath 待移动的文件
     * @param fileName 文件名称
     * @param endPath 移动后的文件 路径
     */
    private static void moveTotherFolders(String startPath,String fileName,String endPath){
        try {
            File startFile = new File(startPath);
            logger.info("文件移动中--- 文件名：《{}》 目标路径：{}",fileName,endPath);
            if (startFile.renameTo(new File(endPath))) {
                logger.info("文件移动成功！文件名：《{}》 目标路径：{}",fileName,endPath);
            } else {
                logger.error("File is failed to move!");
                logger.info("文件移动失败！文件名：《{}》 起始路径：{}",fileName,endPath);
                delFile(startPath);
            }
        } catch (Exception e) {
            logger.info("文件移动异常！文件名：《{}》 起始路径：{}",fileName,endPath);

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
     * 文件保存 规范命名 封装
     * @return fileName 文件名
     */
    public static String generateFilename(String fileName) {
        return PropertiesUtils.getInstance().get("save_video_dir") + DateUtils.MONTH_FORMAT.format(new Date()) +fileName;
    }

    public static void main(String[] args) {

    }


}
