package com.example.demo.controller;


@Controller
public class HomeController {
    // 기본페이지 요청
    @GetMapping("/")
    public String index(){
        return "index"; // => index.~
    }

}
