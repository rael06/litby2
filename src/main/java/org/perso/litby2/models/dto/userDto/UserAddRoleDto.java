package org.perso.litby2.models.dto.userDto;

import org.perso.litby2.core.RoleEnum;

public class UserAddRoleDto {
    private Long userId;
    private RoleEnum role;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}
