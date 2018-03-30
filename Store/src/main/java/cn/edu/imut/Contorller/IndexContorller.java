package cn.edu.imut.Contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by d i_dong on 2017/5/10.
 */
@Controller
public class IndexContorller {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
