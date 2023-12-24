package CalculatorController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.CalculatorService;

@RestController
public class controller {

    private final CalculatorService service;

    public controller(CalculatorService service) {
        this.service = service;
    }
    @GetMapping("/calculator")
    public String hello () {
        return "Добро пожаловать в калькулятор";
    }
    @GetMapping("/calculator/plus")
    public String plus ( @RequestParam("num1") int param1, @RequestParam("num2") int param2){
        return param1 + " + " + param2 + "=" + service.plus(param1, param2);

    }
    @GetMapping("/calculator/minus")
    public String minus (@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2){
        if (num1 == null || num2 == null) {
            return "Один из аргументов не передан ! ";
        }
        return num1 + " - " + num2 + "=" + service.minus(num1, num2);

    }
    @GetMapping("/calculator/multiply")
    public String multiply ( @RequestParam int num1, @RequestParam int num2){
        return num1 + " * " + num2 + "=" + service.multiply(num1, num2);

    }
    @GetMapping("/calculator/divide")
    public String division ( @RequestParam int num1, @RequestParam int num2){
        if (num2 == 0) {
            return "На ноль делить нельзя";
        }
        return num1 + " / " + num2 + "=" + service.plus(num1, num2);

    }
}
