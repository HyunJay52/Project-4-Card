package com.phoca.boot.web.controller.guest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class JoinController {

    @GetMapping("/member/join")
    public String join() { return "/guest/member/join"; }
}
