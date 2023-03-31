package com.yicang_app.backend.controller;


import com.yicang_app.backend.constant.R;
import com.yicang_app.backend.service.MallService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商城控制器
 * @author linorman
 * @date 2023/03/30
 */
@Slf4j
@RestController
@RequestMapping("/mall")
public class MallController {
    @Autowired
    private MallService mallService;

    /**
     * 获取所有的小说信息
     * @param
     * @return R
     */
    @GetMapping("/novelList")
    public R novelList(){
        return mallService.novelList();
    }
}
