package com.shop.gabia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shop.gabia.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    
    Optional<Member> findByUsername(String username);
    
    Optional<Member> findByEmail(String email);
    
    boolean existsByUsername(String username);
    
    boolean existsByEmail(String email);
    
    @Query("SELECT m FROM Member m WHERE m.username = :username OR m.email = :email")
    Optional<Member> findByUsernameOrEmail(@Param("username") String username, @Param("email") String email);
} 
