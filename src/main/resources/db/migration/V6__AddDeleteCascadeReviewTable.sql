ALTER TABLE reviews
DROP CONSTRAINT IF EXISTS reviews_user_id_fkey,
ADD CONSTRAINT reviews_user_id_fkey,
FOREIGN (user_id),
REFERENCES users(user_id),
ON DELETE CASCADE;