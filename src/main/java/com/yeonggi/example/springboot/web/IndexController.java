package com.yeonggi.example.springboot.web;

import com.yeonggi.example.springboot.config.auth.dto.SessionUser;
import com.yeonggi.example.springboot.service.posts.PostsService;
import com.yeonggi.example.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model){ //1.
        model.addAttribute("posts", postsService.findAllDesc());

        SessionUser user = (SessionUser) httpSession.getAttribute("user"); //2.
        if(user != null){ //3.
            model.addAttribute("userName", user.getName());
        }

        return "index"; //index.mustache
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
/*
1.Model
- 서버 템블릿 엔진에서 사용할 수 있는 객체를 저장할 수 있습니다.
- 여기서는 postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달합니다.
2.(SessionUser) httpSession.getAttribute("user")
- 앞서 작성된 CustomOAuth2UserService에서 로그인 성공 시 세션에 SessionUser를 저장하도록 구성했습니다.
- 즉, 로그인 성공 시 httpSession.getAttribute("user")에서 값을 가져올 수 있습니다.
3.if(user != null)
- 세션에 저장된 값이 있을 때만 model에 userName으로 등록합니다.
- 세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태이니 로그인 버튼이 보이게 됩니다.*/