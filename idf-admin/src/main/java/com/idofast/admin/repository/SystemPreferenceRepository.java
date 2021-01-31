package com.idofast.admin.repository;

import com.idofast.admin.domain.SystemPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2020/12/31 10:09 下午
 */

@Repository
public interface SystemPreferenceRepository extends JpaRepository<SystemPreference, Long>
{
}
