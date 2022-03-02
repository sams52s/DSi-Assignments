package com.sams.hostelmsapp.hostelmsapp.model;

import com.google.common.collect.Sets;//guava dependency import
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.sams.hostelmsapp.hostelmsapp.model.UserPermission.*;

public enum UserRole {
    BORDER(Sets.newHashSet()), //Border has no permit for now on.
    ADMIN(Sets.newHashSet(BORDER_READ,BORDER_WRITE,MEAL_READ,MEAL_WRITE)), //Giving permit reading writing to Admin.
    SUPERVISOR(Sets.newHashSet(BORDER_READ,MEAL_READ)); //Giving permit only writing to SUPERVISOR.

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }
    //THIS IS FOR PERMITS BASED AUTHENTICATION FROM HERE
    public Set<UserPermission> getPermissions() {
        return permissions;
    }
    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions= getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissions;
    }
    //TILL HERE
}
