package cn.edu.imut.validate;

import cn.edu.imut.bean.dto.UserRequest;
import cn.edu.imut.utils.MD5Utils;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by di_dong on 2017/5/17.
 */
public class UserValidate {
    public static String checkNullAndValidity(UserRequest user){
        if(StringUtils.isBlank(user.getUserName())){
            return "用户名不能为空!";
        }
        if(StringUtils.isBlank(user.getPassWord())){
            return "密码不能为空!";
        }
        if(StringUtils.isBlank(user.getConfirmPassWord())){
            return "确认密码不能为空!";
        }
        if(StringUtils.isBlank(user.getNickName())){
            return "昵称不能为空!";
        }
        if(StringUtils.isBlank(user.getEmail())){
            return "邮箱不能为空!";
        }
        if(StringUtils.isBlank(user.getPhoneNumber())){
            return "电话号码不能为空!";
        }
        if(StringUtils.isBlank(user.getVerificationCode())){
            return "验证码不能为空!";
        }
        if(StringUtils.isBlank(user.getMd5VerificationCode())){
            return "md5验证码不能为空!";
        }
        if(!checkEmail(user.getEmail())){
            return "邮箱格式不正确!";
        }
        if(!checkMobileNumber(user.getPhoneNumber())){
            return "电话号码不正确!";
        }
        if(!user.getMd5VerificationCode().equals(MD5Utils.md5(user.getVerificationCode()))){
            return "验证码不正确!";
        }
        if(!user.getPassWord().equals(user.getConfirmPassWord())){
            return "确认密码与密码不一致!";
        }
        return "";
    }
    /**
     * 验证邮箱
     */
    private static boolean checkEmail(String email){
        boolean flag = false;
        try{
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     * 验证手机号码
     */
    private static boolean checkMobileNumber(String mobileNumber){
        boolean flag = false;
        try{
            Pattern regex = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
            Matcher matcher = regex.matcher(mobileNumber);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }
}
