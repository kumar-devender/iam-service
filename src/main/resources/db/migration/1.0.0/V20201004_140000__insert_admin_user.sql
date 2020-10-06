INSERT INTO iam_store.member(id, first_name, last_name, email, user_type, created_by, created_on, updated_on) VALUES
(uuid_generate_v4(), 'devender', 'kumar', 'devender.kumar@gmail.com', 'ADMINISTRATOR', null , now(), now());

INSERT INTO iam_store.credential(id, password, user_id, enabled, created_by, created_on, updated_on) VALUES
(uuid_generate_v4(), '$2y$10$eLmz/6cohzveHv90kZiLyupGd2oKtLc4vgVGn4m10vUvejfZqXNke',
 (SELECT id FROM iam_store.member where email = 'devender.kumar@gmail.com'), -- admin user id
 true, null , now(), now());

