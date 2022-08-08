package com.ll.exam.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class MainController {
    private int increaseNo = -1;
    @RequestMapping("/sbb")
    @ResponseBody
    public String index() {
        System.out.println("index");
        return "빠지는 팔이 아펑 ㅜㅜㅜ";
    }

    @GetMapping("/page1")
    @ResponseBody
    public String showGet() {
        return """
                <form method = "POST" action = "/page2">
                    <input type = "text" name="age" placeholder="나이"/>
                    <input type = "submit" value="page2로 POST 방식으로 이동">
                </form>
                """;
    }

    @PostMapping("/page2")
    @ResponseBody
    public String showPage2Post(@RequestParam(defaultValue = "10") int age) {
        return """
                <h1>입력된 나이 : %d 살</h1>
                <h1>안녕하세요!,POST 방식으로</h1>
                """.formatted(age);
    }

    @GetMapping("/page2")
    @ResponseBody
    public String showPage2Get(@RequestParam(defaultValue = "10") int age) {
        return """
                <h1>입력된 나이 : %d 살</h1>
                <h1>안녕하세요!,GET 방식으로</h1>
                """.formatted(age);
    }

    @GetMapping("/plus")
    @ResponseBody
    public int showPlus(int a, int b) {
        return a + b;
    }

    @GetMapping("/minus")
    @ResponseBody
    public int showMinus(int a, int b) {
        return a - b;
    }

    @GetMapping("/increase")
    @ResponseBody
    public int showIncrease() {
        increaseNo++;

        return increaseNo;
    }

    @GetMapping("/gugudan")
    @ResponseBody
    public String showGugudan(Integer dan, Integer limit) {
        if (limit == null) {
            limit = 9;
        }

        if (dan == null) {
            dan = 9;
        }

        Integer finalDan = dan;
        return IntStream.rangeClosed(1, limit)
                .mapToObj(i -> "%d * %d = %d".formatted(finalDan, i, finalDan * i))
                .collect(Collectors.joining("<br>\n"));
    }
}