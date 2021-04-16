package org.perso.litby2.repositories;

import org.perso.litby2.entities.Role;
import org.perso.litby2.entities.RoleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, RoleId> {

}
