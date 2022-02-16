package com.phoca.boot.web.controller.guest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {

    @GetMapping("/market/market_list/content_detail")
    public String board_detail() {
        return "/guest/board/market_detail";
    }
}
