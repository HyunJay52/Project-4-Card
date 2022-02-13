package com.phoca.boot.web.controller.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class SummaryController {
    @GetMapping("/admin/summary")
    public String memberMng() { return "/admin/summary"; }

}
