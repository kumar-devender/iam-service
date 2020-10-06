INSERT INTO iam_store.permission(id, name, description, created_by, created_on, updated_on) VALUES
(uuid_generate_v4(), 'admin_access', 'full admin access to everything in the system(God mode)', null , now(), now());

INSERT INTO iam_store.role(id, name, description, created_by, created_on, updated_on) VALUES
(uuid_generate_v4(), 'admin', 'admin role', null , now(), now());

INSERT INTO iam_store.role_permission(id, role_id, permission_id, created_by, created_on, updated_on) VALUES
(uuid_generate_v4(),
 (SELECT id FROM iam_store.role where name = 'admin'), -- admin role id
 (SELECT id FROM iam_store.permission where name = 'admin_access'), -- admin permission id
  null , now(), now());


