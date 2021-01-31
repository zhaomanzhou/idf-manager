package com.idofast.admin.repository;

import com.idofast.admin.domain.Bundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/1/25 9:50 下午
 */
@Repository
public interface BundleRepository extends JpaRepository<Bundle, Long>
{
}
