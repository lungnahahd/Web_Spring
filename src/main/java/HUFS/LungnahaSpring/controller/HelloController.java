package HUFS.LungnahaSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// 스프링은 컨트롤러 인폴트 시키기
@Controller
public class HelloController {
    // /hello가 주소로 넘어오면 아래 코드가 실행되도록 맵핑
    @GetMapping("hello")
    public String hello(Model model){
        // hello.html 파일에 정의된 data를 해당 내용을 치환
        model.addAttribute("data","Lungnaha");
        //스프링에서 생성한 model에 data부분에 해당 값을 넘겨주고 hello.html 파일로 이동하라는 의미로 return 사용
        return "hello";
    }

    @GetMapping("search")
    public String SearchMVC(@RequestParam("search") String search, Model model){
        model.addAttribute("search", search);
        return "mvcresult";
    }

    @GetMapping("getapi")
    @ResponseBody
    public Small GetApi(@RequestParam("api") String api){
        Small small = new Small();
        small.setApidata(api);
        return small;
    }

    static class Small{
        private String apidata;

        public String getApidata() {
            return apidata;
        }


        public void setApidata(String apidata) {
            this.apidata = apidata;
        }
    }
}

