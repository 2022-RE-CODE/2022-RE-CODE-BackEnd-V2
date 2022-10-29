package com.java.recode.domain.user.domain.repository;

import com.java.recode.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
