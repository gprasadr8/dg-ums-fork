package com.pw.ums.repository;

import com.pw.ums.entity.DGUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<DGUser,Long> {
}
