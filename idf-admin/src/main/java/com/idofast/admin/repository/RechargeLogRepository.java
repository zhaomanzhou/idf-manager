package com.idofast.admin.repository;

import com.idofast.admin.domain.RechargeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/7 4:27 下午
 */

@Repository
public interface RechargeLogRepository extends JpaRepository<RechargeLog, Long>
{
    Optional<RechargeLog> findByOrderId(Long orderId);

    List<RechargeLog> findAllByUserId(Long userId);
}
