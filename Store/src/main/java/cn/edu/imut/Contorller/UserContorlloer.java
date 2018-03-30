package cn.edu.imut.Contorller;

import cn.edu.imut.bean.dto.UserRequest;
import cn.edu.imut.bean.model.VerificationCodeModel;
import cn.edu.imut.entity.UserEO;
import cn.edu.imut.interfaces.UserService;
import cn.edu.imut.utils.MD5Utils;
import cn.edu.imut.utils.VerificationCodeUtil;
import cn.edu.imut.utils.WebReturnUtils;
import cn.edu.imut.validate.UserValidate;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


/**
 * Created by di_dong on 2017/5/16.
 */
@Controller
@RequestMapping("/api/user")
public class UserContorlloer {

    private Logger logger = LoggerFactory.getLogger(UserContorlloer.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/loadRegister")
    public String registerLoad(){
        return "register";
    }

    @RequestMapping("/loadLogIn")
    public String logInLoad(){
        return "account";
    }

    /**
     * 检查用户名
     */
    @RequestMapping(value = "/checkUserName",method = RequestMethod.POST)
    public @ResponseBody JSONObject checkUserName(@RequestBody UserRequest user){
        String userName = user.getUserName();
        if(StringUtils.isBlank(userName)){
            String msg = "用户名不能为空";
            logger.info(msg);
             return WebReturnUtils.failure(msg);
        }
        return userService.checkUserName(userName)? WebReturnUtils.failure("用户名已存在"):WebReturnUtils.success("");
    }

    /**
     *保存用户
     */
    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public @ResponseBody JSONObject registerUser(@RequestBody UserRequest user){
        logger.info("注册提交接口");
        String msg = UserValidate.checkNullAndValidity(user);
        if(StringUtils.isNotBlank(msg)){
            logger.info(msg);
            return WebReturnUtils.failure(msg);
        }
        if(userService.checkUserName(user.getUserName())){
            logger.info("用户名已存在!");
            return WebReturnUtils.failure("用户名已存在");
        }
        if(!userService.saveUser(user)){
          return WebReturnUtils.failure("注册失败!");
        }
        return WebReturnUtils.success();
    }

    /**
     *获取验证码
     */
    @RequestMapping(value = "/getVerificationCode",method = RequestMethod.POST)
    public @ResponseBody JSONObject getVerificationCode(){
        try {
            Map<String,String> map = VerificationCodeUtil.getVerificationCode();
            VerificationCodeModel verificationCodeModel = new VerificationCodeModel();
            String imgWithGBK=map.keySet().iterator().next();
            String imgWithMd5= MD5Utils.md5(imgWithGBK);
            String imgWithBase64=map.get(map.keySet().iterator().next());
            verificationCodeModel.setImgWithBase64(imgWithBase64);
            verificationCodeModel.setImgWithMd5(imgWithMd5);
            return WebReturnUtils.success(verificationCodeModel);
        }catch (Exception e){
            return WebReturnUtils.failure("获取验证码失败！");
        }
    }

    /**
     * 用户登陆
     */
    @RequestMapping(value = "/logIn",method = RequestMethod.POST)
    public @ResponseBody JSONObject logIn(@RequestBody UserRequest userRequest, HttpServletRequest request){
        String userName = userRequest.getUserName();
        String passWord = userRequest.getPassWord();
        if(StringUtils.isBlank(userName)){
            return WebReturnUtils.failure("用户名不能为空！");
        }else if(StringUtils.isBlank(passWord)){
            return WebReturnUtils.failure("登陆密码不能为空！");
        }
        UserEO user = userService.logIn(userName,passWord);
        if (user == null){
            return WebReturnUtils.failure("用户名或密码不正确！");
        }
        HttpSession session =  request.getSession();
        if(session.getAttribute("user")==null){
            session.setAttribute("user",user);
        }
        return WebReturnUtils.success();

    }
    /**
     * 获取用户名
     */
    @RequestMapping(value = "/checkIsLogin",method = RequestMethod.POST)
    public @ResponseBody JSONObject registerUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null){
            return WebReturnUtils.failure("");
        }
        UserEO user = (UserEO)session.getAttribute("user");
        return WebReturnUtils.success(user.getNickName());
    }
    /**
     * 退出登陆
     */
    @RequestMapping(value = "/logOut")
    public String logOut(HttpServletRequest request){
        logger.info("退出登陆");
        if(request.getSession(false)!=null){
            request.getSession().invalidate();
        }
        return "index";
    }


    /**
     * 退出登陆
     */
    @RequestMapping(value = "/justTest")
    public void logOut(){
        logger.info("TestController");
        userService.justTest();
    }
}
