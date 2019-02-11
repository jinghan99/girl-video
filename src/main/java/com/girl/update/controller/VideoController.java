package com.girl.update.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.girl.update.controller
 * @Description: TODO
 * @author: jingh
 * @date 2019/2/11 15:09
 */
@RestController
public class VideoController {
    @GetMapping("/")
    public String index() {
        return "this is / ";
    }
}
