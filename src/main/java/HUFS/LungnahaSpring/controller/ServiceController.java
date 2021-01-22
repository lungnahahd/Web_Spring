package HUFS.LungnahaSpring.controller;

import HUFS.LungnahaSpring.clientinfo.Member;
import HUFS.LungnahaSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class ServiceController {
    private final MemberService memberService;

    @Autowired
    public ServiceController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String CreatedMember(){
        return "createmember";
    }

    @PostMapping("/members/new")
    public String Create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }
}
