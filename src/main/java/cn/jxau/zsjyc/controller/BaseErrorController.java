package cn.jxau.zsjyc.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "error")
public class BaseErrorController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "redirect:/";
    }

    @RequestMapping
    public String error() {
        return getErrorPath();
    }

}