package com.yeonggi.example.springboot.web;

import com.yeonggi.example.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){ //1.
        model.addAttribute("posts", postsService.findAllDesc());
        return "index"; //index.mustache
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
/*
1.Model
- 서버 템블릿 엔진에서 사용할 수 있는 객체를 저장할 수 있습니다.
- 여기서는 postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달합니다.*/