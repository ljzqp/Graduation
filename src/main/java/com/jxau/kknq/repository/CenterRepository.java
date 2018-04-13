package com.jxau.kknq.repository;

import com.jxau.kknq.entity.Users;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/4/13 9:45
 */
@Repository
public interface CenterRepository extends PagingAndSortingRepository<Users,Integer>,
        JpaSpecificationExecutor<Users> {
    @Modifying
    @Query("update Users us set us=?1 where us.username=?2")
    void updateUsers(Users users,String username);

    @Query(value = "select password from users where user_name=?1",nativeQuery = true)
    String checkPassword(String username);


    @Modifying
    @Query(value = "update users as u set u.password = ?1 where u.user_name=?2",nativeQuery = true)
    void setNewPassword(String newPassword,String username);
}
