package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

@Controller
public class Mcontroller {

    @Autowired
    MemberService memberService;

    @RequestMapping("/member/memberView")
    public String memberView(String id, Model model) {
        System.out.println("Mcontroller id : " + id);
        // 회원 1명 가져오기
        MemberDto member = memberService.memberSelectAll("id");
        model.addAttribute("member", member);

        return "member/memberView";
    }

    @RequestMapping("/member/memberList")
    public String memberList(Model model) {
        ArrayList<MemberDto> list = memberService.memberSelectAll();
        model.addAttribute("list", list);
        System.out.println("MController list : " + list);
        return "member/memberList";

    }
}