package com.idofast.admin.repository;

import com.idofast.admin.domain.DataResetLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/7 7:29 下午
 */
@Repository
public interface DataResetLogRepository extends JpaRepository<DataResetLog, Long>
{
    List<DataResetLog> findAllByUserId(Long userId);
}
