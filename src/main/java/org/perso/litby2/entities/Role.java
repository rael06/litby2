package org.perso.litby2.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "roles")
public class Role {

    @EmbeddedId
    private RoleId id;
    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

    public RoleId getId() {
        return id;
    }

    public void setId(RoleId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
