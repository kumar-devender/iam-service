package info.pragmaticdeveloper.iam.domain;

public enum UserPermission {
    VIEW_KIBANA_LOGS("view_kibana_logs"),
    VIEW_GRAFANA_MATRIX("view_grafana_matrix");
    /*    QA_DEPLOYMENT,
        PROD_DEPLOYEMNT,
        ADD_USER,
        HIRE_EMPLOYEE;*/
    private String permission;

    public String getPermission() {
        return permission;
    }

    UserPermission(String permission) {
        this.permission = permission;
    }
}
