package info.pragmaticdeveloper.iam.domain;

import com.google.common.collect.Sets;

import java.util.Set;

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

    /*    TEAM_LEAD,
    SR_TEAM_LEAD,
    EXPERT_ENGINEER,
    PRINCIPAL_ENGINEER,
    DIRECTOR*/
}
