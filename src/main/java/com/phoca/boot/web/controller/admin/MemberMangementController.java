package com.phoca.boot.web.controller.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MemberMangementController {

        @GetMapping("/admin/member")
        public String memberMng() { return "/admin/member/member-mng"; }

        @GetMapping("/admin/member-detail")
        public String memberDetailMng() { return "/admin/member/member-detail-mng"; }
}
