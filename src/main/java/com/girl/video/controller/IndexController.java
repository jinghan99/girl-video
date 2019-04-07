package com.girl.video.controller;

import com.girl.video.book.entity.BookInfo;
import com.girl.video.book.entity.UpdateBook;
import com.girl.video.entity.R;
import com.girl.video.task.VideoTask;
import com.girl.video.utils.HttpRequest;
import com.girl.video.utils.JSONUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @Package com.girl.video.controller
 * @Description: TODO
 * @author: jingh
 * @date 2019/2/12 10:59
 */
@Controller
public class IndexController extends AbstractController {

    private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
    @GetMapping("/")
    public String index() {
        return "video/video_list.html";
    }

    @CrossOrigin
    @GetMapping("/update_book")
    @ResponseBody
    public R updateBook(@Param("url") String url,@Param("dataType")String dataType) {
        List<BookInfo> bookInfos = new ArrayList<>();
        String json =HttpRequest.ToJsonGet(url);

        List<UpdateBook> list = JSONUtils.jsonToList(json, UpdateBook.class);
        for(UpdateBook updateBook:list){


        }
        return R.ok().put("data", json);
    }


}
