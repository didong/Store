package cn.edu.imut.service;

import cn.edu.imut.bean.dto.UserRequest;
import cn.edu.imut.entity.UserEO;
import cn.edu.imut.interfaces.UserService;
import cn.edu.imut.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by di_dong on 2017/5/22.
 */
@Service("UserService")
public class UserServiceImpl implements UserService{
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    public boolean checkUserName(String userName){
        try {
            //如果存在返回contorller true表示存在
            if(userRepository.findByUserName(userName) != null){
                return true;
            }
            return false;
        }catch (Exception e){
            logger.info("查询用户失败！"+e.getMessage());
            return false;
        }
    }

    @Override
    public boolean saveUser(UserRequest userRequest) {
        try {
            UserEO user = new UserEO();
            user.setUserName(userRequest.getUserName());
            user.setPassWord(userRequest.getPassWord());
            user.setNickName(userRequest.getNickName());
            user.setEmail(userRequest.getEmail());
            user.setPhoneNumber(userRequest.getPhoneNumber());
            user.setRoleId(3L);
            userRepository.save(user);
            return true;
        }catch (Exception e){
            logger.info("保存失败!"+e.getMessage());
            return false;
        }
    }

    @Override
    public UserEO logIn(String userName, String passWord) {
        try{
            return userRepository.findByUserNameAndPassWord(userName,passWord);
        }catch (Exception e){
            logger.info("登录失败!"+e.getMessage());
            return null;
        }
    }

    public void justTest(){
        List<UserEO> userEOList  =  userRepository.findByRoleId(3L);

        for (UserEO usetEO:userEOList){
            usetEO.setRoleId(2L);
        }
            userRepository.save(userEOList);
        List<UserEO> userEOList1  =  userRepository.findByRoleId(2L);
        logger.info("userEOList.size：{}",userEOList.size());
        logger.info("userEOList1.size：{}",userEOList1.size());
    }


}
