package org.perso.litby2.repositories;

import org.perso.litby2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {

}
