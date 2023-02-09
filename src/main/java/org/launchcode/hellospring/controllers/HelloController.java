package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name){
//        return "Hello, " + name + "!";
//    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public static String createMessage(@RequestParam String name, @RequestParam String language){
        String styleFront = "<html>" +
                "<body>" +
                "<p style='color:red;'>";

        String styleBack= "</p>" +
                "</body>" +
                "</html>";

        if(language.equals("french")){
            return styleFront + "Bonjour, " + name + "!" + styleBack;
        }
        if(language.equals("german")){
            return "Hallo, " + name + "!";
        }
        if(language.equals("spanish")){
            return "Hola, " + name + "!";
        }
        if(language.equals("japanese")){
            return "Kon'nichiwa, " + name + "!";
        }
        if(language.equals("klingon")){
            return "<html>" +
                    "<body>" +
                    "<p style='color:red;'>" + "NuqneH, " + name + "!" +
                    "</p>" +
                    "</body>" +
                    "</html>";
        }

        return "Yo, " + name + "!";

    }

    //lives /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='/hello' method='post'>" + // submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value=''>--Please select a language--</option>" +
                "<option value='french'>French</option>" +
                "<option value='german'>German</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='japanese'>Japanese</option>" +
                "<option value='klingon'>Klingon</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
