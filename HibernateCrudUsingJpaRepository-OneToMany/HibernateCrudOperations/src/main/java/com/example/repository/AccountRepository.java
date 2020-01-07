package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Account;
import com.example.model.Benefits;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	@Query("SELECT u FROM Account u WHERE u.accountId = ?1")
	List<Benefits> findAccountById(Integer id);

}
