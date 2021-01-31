package com.idofast.admin.repository;

import com.idofast.admin.domain.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2020/12/30 11:32 下午
 */
@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Long>
{
}
