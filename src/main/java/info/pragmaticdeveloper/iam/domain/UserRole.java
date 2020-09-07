package info.pragmaticdeveloper.iam.domain;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static info.pragmaticdeveloper.iam.domain.UserPermission.VIEW_GRAFANA_MATRIX;
import static info.pragmaticdeveloper.iam.domain.UserPermission.VIEW_KIBANA_LOGS;

public enum UserRole {
    SOFTWARE_ENGINEER(Sets.newHashSet()),
    SR_SOFTWARE_ENGINEER(Sets.newHashSet(VIEW_KIBANA_LOGS, VIEW_GRAFANA_MATRIX));

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    private Set<UserPermission> permissions;

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = this.permissions
                .stream().map(userPermission -> new SimpleGrantedAuthority(userPermission.name()))
                .collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority(this.name()));
        return authorities;
    }

    /*    TEAM_LEAD,
    SR_TEAM_LEAD,
    EXPERT_ENGINEER,
    PRINCIPAL_ENGINEER,
    DIRECTOR*/
}
