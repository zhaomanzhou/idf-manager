package com.idofast.admin.repository;

import com.idofast.admin.domain.UserProxyInfo;
import com.idofast.admin.domain.dto.UserInfoLite;
import com.idofast.admin.domain.dto.V2rayAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    @Query("select new com.idofast.admin.domain.dto.UserInfoLite " +
            "(u.id, u.createTime, u.email, u.avatarUrl, u.role, u.status, u.remark, u.osDevice, u.ext, " +
            "d.level, d.speed, d.totalData, d.usedData, d.nextSettleDate, d.expireDate, d.maxConnection, d.bundleId, d.bundleName, d.totalActiveDay, d.namespace) \n" +
            " from User u INNER JOIN  UserProxyInfo d on u.id = d.id ")
    public Page<UserInfoLite> queryUserInfo( Pageable pageable);

    @Query("select new com.idofast.admin.domain.dto.V2rayAccount(u.id, u.email, p.speed, p.usedData, p.totalData, p.expireDate, p.maxConnection, p.uuid, u.status)  \n" +
            "from User u \n" +
            "INNER JOIN UserProxyInfo p\n" +
            "ON u.id = p.id\n" +
            "where u.id = :id")
    Optional<V2rayAccount> queryAccount(@Param("id") Long id);

    @Modifying
    @Query(value = "insert into user_proxy_info (bundle_id, bundle_name, deleted,  level, max_connection, namespace, next_settle_date, expire_date,speed, total_active_day, total_data, used_data, id, subscribe_code, uuid) " +
            "values (:#{#info.bundleId}, :#{#info.bundleName}, :#{#info.deleted.code},  :#{#info.level}, :#{#info.maxConnection}, :#{#info.namespace}, :#{#info.nextSettleDate},  :#{#info.expireDate}," +
            ":#{#info.speed}, :#{#info.totalActiveDay}, :#{#info.totalData}, :#{#info.usedData}, :#{#info.id},\n" +
            "#{#info.subscribeCode}, #{#info.uuid})", nativeQuery = true)

    @Transactional
    public void insertWithGivenId(@Param("info") UserProxyInfo userProxyInfo);

    List<UserProxyInfo> findAllByNextSettleDateBeforeAndAndExpireDateAfter(LocalDateTime currentDatTime, LocalDateTime currentDateTime);



    Optional<UserProxyInfo> findBySubscribeCodeEquals(String subscribeCode);



}
