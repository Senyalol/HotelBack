ALTER TABLE user_roles
DROP CONSTRAINT IF EXISTS user_roles_user_id_fkey,
ADD CONSTRAINT user_roles_user_id_fkey,
FOREIGN KEY (user_id),
REFERENCES users(user_id),
ON DELETE CASCADE;