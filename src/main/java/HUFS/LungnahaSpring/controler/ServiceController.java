package HUFS.LungnahaSpring.controler;

import HUFS.LungnahaSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceController {
    private final MemberService memberService;

    @Autowired
    public ServiceController(MemberService memberService) {
        this.memberService = memberService;
    }
}
