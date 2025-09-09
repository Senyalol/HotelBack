ALTER TABLE reviews
DROP CONSTRAINT IF EXISTS reviews_user_id_fkey;

ALTER TABLE reviews
ADD CONSTRAINT reviews_user_id_fkey
FOREIGN KEY (user_id)
REFERENCES users(user_id)
ON DELETE CASCADE;