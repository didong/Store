package cn.edu.imut.Contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by d i_dong on 2017/5/10.
 */
@Controller
public class BackContorller {
    @RequestMapping("/back")
    public String index(){
        return "back";
    }

}
