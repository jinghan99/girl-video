package com.girl.video.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



/**
 * @Package com.girl.video.controller
 * @Description: TODO
 * @author: jingh
 * @date 2019/2/12 10:59
 */
@Controller
public class IndexController extends AbstractController {

    @GetMapping("/")
    public String index() {
        return "index.html";
    }


}
