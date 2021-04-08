package com.idofast.admin.repository;

import com.idofast.admin.domain.User;
import com.idofast.common.enums.UserStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    @Modifying
    @Transactional
    @Query("update User n set n.remark = :remark where n.id = :id")
    int updateRemarkById(@Param("id") Long id, @Param("remark") String remark);


    @Modifying
    @Transactional
    @Query("update User n set n.osDevice = :device where n.id = :id")
    int updateOsDeviceById(@Param("id") Long id, @Param("device") Integer device);


    @Modifying
    @Transactional
    @Query("update User n set n.status = :statusEnum where n.id = :id")
    int updateUserStatusById(@Param("id") Long id, @Param("statusEnum") UserStatusEnum statusEnum);

    @Modifying
    @Transactional
    @Query("update User u set u.password = :password where u.id = :id")
    int updatePasswordById(@Param("id") Long id, @Param("password") String password);

    @Modifying
    @Transactional
    @Query("update User u set u.password = :password where u.email = :email")
    int updatePasswordByEmail(@Param("email") String email, @Param("password") String password);
}
