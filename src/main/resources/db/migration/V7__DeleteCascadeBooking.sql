ALTER TABLE bookings
DROP CONSTRAINT IF EXISTS bookings_user_id_fkey;

ALTER TABLE bookings
ADD CONSTRAINT bookings_user_id_fkey
FOREIGN KEY (user_id)
REFERENCES users(user_id)
ON DELETE CASCADE;

ALTER TABLE bookings
DROP CONSTRAINT IF EXISTS bookings_room_id_fkey;

ALTER TABLE bookings
ADD CONSTRAINT bookings_room_id_fkey
FOREIGN KEY (room_id)
REFERENCES rooms(room_id)
ON DELETE CASCADE;