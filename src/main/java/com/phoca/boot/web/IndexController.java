package com.phoca.boot.web;

import com.phoca.boot.config.auth.LoginUser;
import com.phoca.boot.config.auth.dto.SessionUser;
import com.phoca.boot.service.PostsService;
import com.phoca.boot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;

    //전체적인 수정이 필요함
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) { // Model: save object
                                    //기존: httpSession.getAttribute("user")로 가져오던 세션 정보값 개선, @LoginUser만 사용하면 어느 컨트롤러에서든지 세션 정보를 가져올 수 있다
        model.addAttribute("posts", postsService.findAllDesc());

        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        /*
        - @LoginUser 생성 전 코드 -
        로그인 성공 시, httpSession.getAttribute("user") 값을 가져옴
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        session에 저장된 값이 있을 경우만 model에 userName 등록
        if(user != null) { model.addAttribute("userName", user.getName()); }
        */

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }


    @GetMapping("/market/market_list")
    public String market() { return "/guest/board/market_list"; }

}
