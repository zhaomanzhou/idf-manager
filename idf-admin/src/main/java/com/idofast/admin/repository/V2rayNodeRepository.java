package com.idofast.admin.repository;

import com.idofast.admin.domain.V2rayNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/11 10:42 上午
 */
@Repository
public interface V2rayNodeRepository extends JpaRepository<V2rayNode, Long>
{
    /**
     * 获取该节点的所有字节点
     */
    List<V2rayNode> getAllByParentNodeIdEquals(Long parentId);

    List<V2rayNode> findAllByLevelIsLessThanEqualAndEnableEquals(Integer level,Boolean enable);

    List<V2rayNode> findAllByEnableEquals(Boolean enable);

    List<V2rayNode> findAllByHostEquals(String host);


}

