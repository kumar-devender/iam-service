INSERT INTO iam_store.permission(id, name, description, created_by, created_on, updated_on)
VALUES (uuid_generate_v4(), 'admin_access', 'full admin access to everything in the system(God mode)', null, now(),
        now()),
       (uuid_generate_v4(), 'customer', 'customer has access to customer dashboard only', null, now(), now()),
       (uuid_generate_v4(), 'merchant', 'merchant has access to merchant dashboard only', null, now(), now());

INSERT INTO iam_store.role(id, name, description, created_by, created_on, updated_on)
VALUES (uuid_generate_v4(), 'ADMINISTRATOR', 'admin role', null, now(), now()),
       (uuid_generate_v4(), 'CUSTOMER', 'customer role', null, now(), now()),
       (uuid_generate_v4(), 'MERCHANT', 'merchant role', null, now(), now());

INSERT INTO iam_store.role_permission(id, role_id, permission_id, created_by, created_on, updated_on)
VALUES (uuid_generate_v4(),
        (SELECT id FROM iam_store.role where name = 'ADMINISTRATOR'), -- admin role id
        (SELECT id FROM iam_store.permission where name = 'admin_access'), -- admin permission id
        null, now(), now()),
       (uuid_generate_v4(),
        (SELECT id FROM iam_store.role where name = 'CUSTOMER'), -- customer role id
        (SELECT id FROM iam_store.permission where name = 'customer'), -- customer permission id
        null, now(), now()),
       (uuid_generate_v4(),
        (SELECT id FROM iam_store.role where name = 'MERCHANT'), -- merchant role id
        (SELECT id FROM iam_store.permission where name = 'merchant'), -- merchant permission id
        null, now(), now());
