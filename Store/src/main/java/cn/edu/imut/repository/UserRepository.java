package cn.edu.imut.repository;

import cn.edu.imut.entity.UserEO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by di_dong on 2017/5/22.
 */
public interface UserRepository extends JpaRepository<UserEO,Long> {
    /**
     *通过用户名查找用户
     */
    UserEO findByUserName(String userName);

    /**
     * 通过用户角色来查找用户集合
     * @param roleId
     * @return
     */
    List<UserEO> findByRoleId(Long roleId);

    /**
     * 通过用户名和密码查找用户
     */
    UserEO findByUserNameAndPassWord(String userName,String passWord);
}
