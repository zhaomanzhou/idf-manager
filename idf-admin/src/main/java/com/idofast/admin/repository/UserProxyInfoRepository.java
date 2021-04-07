package com.idofast.admin.repository;

import com.idofast.admin.domain.UserProxyInfo;
import com.idofast.admin.domain.dto.UserInfoLite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/2/20 10:19 下午
 */
@Repository
public interface UserProxyInfoRepository extends JpaRepository<UserProxyInfo, Long>
{
    /**
     * 查询分页列表
     *
     * @return
     */

    @Query("select new com.idofast.admin.domain.dto.UserInfoLite (u , d) " +
            "from User u INNER JOIN  UserProxyInfo d " +
            "on u.id = d.id ")
    public Page<UserInfoLite> queryUserInfo( Pageable pageable);


    @Modifying
    @Query(value = "insert into user_proxy_info (bundle_id, bundle_name, deleted,  level, max_connection, namespace, next_settle_date, expire_date,speed, total_active_day, total_data, used_data, id) " +
            "values (:#{#info.bundleId}, :#{#info.bundleName}, :#{#info.deleted.code},  :#{#info.level}, :#{#info.maxConnection}, :#{#info.namespace}, :#{#info.nextSettleDate},  :#{#info.expireDate}," +
            ":#{#info.speed}, :#{#info.totalActiveDay}, :#{#info.totalData}, :#{#info.usedData}, :#{#info.id})", nativeQuery = true)

    @Transactional
    public void insertWithGivenId(@Param("info") UserProxyInfo userProxyInfo);
}
