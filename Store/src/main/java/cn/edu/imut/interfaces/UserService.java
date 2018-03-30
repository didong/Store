package cn.edu.imut.interfaces;

import cn.edu.imut.bean.dto.UserRequest;
import cn.edu.imut.entity.UserEO;

/**
 * Created by di_dong on 2017/5/27.
 */
public interface UserService {
    /**
     * 检查用户名是否已存在 存在 true 不存在false
     */
    boolean checkUserName(String userName);
    /**
     * 保存用户 true保存成功 false为保存失败
     */
    boolean saveUser(UserRequest userRequest);
    /**
     * 用户登陆 返回user登陆成功 返回null 登陆失败
     */
    UserEO logIn(String userName, String passWord);

    /**
     * 用户登陆 返回user登陆成功 返回null 登陆失败
     */
    void justTest();
}
