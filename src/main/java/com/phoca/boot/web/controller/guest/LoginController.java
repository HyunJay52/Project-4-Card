package com.phoca.boot.web.controller.guest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    @GetMapping("/member/login")
    public String login() { return "/guest/member/login"; }

    @GetMapping("/member/login2")
    public String loginApis() { return "/guest/member/login2"; }

}
