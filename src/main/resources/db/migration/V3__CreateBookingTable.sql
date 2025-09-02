CREATE TABLE bookings (
                          booking_id SERIAL PRIMARY KEY,
                          user_id INT,
                          room_id INT,
                          start_date DATE,
                          end_date DATE,
                          status VARCHAR(20) DEFAULT 'активно' CHECK (status IN ('активно', 'отменено')),
                          FOREIGN KEY (user_id) REFERENCES users(user_id),
                          FOREIGN KEY (room_id) REFERENCES rooms(room_id)
);