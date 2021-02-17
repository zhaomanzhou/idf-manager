package com.idofast.admin.repository;

import com.idofast.admin.domain.Order;
import com.idofast.common.enums.OrderStatusEnum;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.convert.QueryByExamplePredicateBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/2/4 4:00 下午
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order>
{
    List<Order> findAllByUserId(Long userId);
    List<Order> findAllByOrderStatusBefore(OrderStatusEnum orderStatus);
    List<Order> findAllByCreateTimeAfterAndOrderStatusBefore(LocalDateTime startTime,OrderStatusEnum orderStatus);


    default Specification<Order> exampleSpecification(Example<Order> example){
        return new Specification<Order>()
        {
            @Override
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder)
            {
                if(example == null){
                    return null;
                }
                return QueryByExamplePredicateBuilder.getPredicate(root, criteriaBuilder, example);
            }
        };
    }

    /**
     * 指定订单时间在starttime和endtime之间，订单状态在orderStatusList之间
     * @param startTime
     * @param endTime
     * @param orderStatusList
     * @return
     */
    default Specification<Order> orderListSpec(LocalDateTime startTime, LocalDateTime endTime, List<OrderStatusEnum> orderStatusList)
    {
        return new Specification<Order>()
        {
            @Override
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder)
            {
                List<Predicate> list = new ArrayList<>();
                if(startTime != null )
                {
                    list.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createTime"), startTime));
                }
                if(endTime != null)
                {
                   list.add(criteriaBuilder.lessThanOrEqualTo(root.get("createTime"), endTime));
                }
                if(orderStatusList != null && orderStatusList.size() != 0)
                {
                    list.add(root.get("orderStatus").in(orderStatusList));
                }
                if (list.size() != 0) {
                    Predicate[] p = new Predicate[list.size()];
                    return criteriaBuilder.and(list.toArray(p));
                } else {
                    return null;
                }
            }
        };
    }

}
