package com.nhnent.edu.springboot.test.practice.account;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author myeongju.jung
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}
