package HUFS.LungnahaSpring.controller;

import HUFS.LungnahaSpring.clientinfo.Member;
import HUFS.LungnahaSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class ServiceController {
    private final MemberService memberService;

    @Autowired
    public ServiceController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members/new")
    public String CreatedMember(){
        return "create";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model){
        List<Member> members = memberService.findAllMember();
        model.addAttribute("members",members);
        return "memberList";
    }
}
