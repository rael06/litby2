package org.perso.litby2.models.dto.roleDto;

import org.perso.litby2.entities.Role;
import org.perso.litby2.models.dto.IDtoConverter;

public class RoleReadDto implements IDtoConverter<Role> {
    private Long userId;
    private String name;

    public RoleReadDto(Role role) {
        fromEntity(role);
    }

    @Override
    public void fromEntity(Role role) {
        userId = role.getId().getUserId();
        name = role.getId().getRoleName();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
