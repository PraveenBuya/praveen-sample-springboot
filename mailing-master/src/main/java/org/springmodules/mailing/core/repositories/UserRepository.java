package org.springmodules.mailing.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springmodules.mailing.core.entity.User;



public interface UserRepository extends JpaRepository<User, Long> {
}
