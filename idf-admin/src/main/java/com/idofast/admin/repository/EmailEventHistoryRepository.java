package com.idofast.admin.repository;

import com.idofast.admin.domain.EmailEventHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailEventHistoryRepository extends  JpaRepository<EmailEventHistory,Integer> {
}
