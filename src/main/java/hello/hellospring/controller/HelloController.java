package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // 데이터를 그대로 내려줌
    public String helloString(@RequestParam("data") String name) {
        return "Hi! " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("data") String name) {
        Hello helloo = new Hello();
        helloo.setName(name);
        return helloo;
    }

    static class Hello {
        private String name;

        // getter setter 윈도 단축키 alt + insert
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
