CREATE TABLE reviews (
                         review_id SERIAL PRIMARY KEY,
                         user_id INT,
                         stay_duration VARCHAR(50) NOT NULL,
                         advantages TEXT,
                         disadvantages TEXT,
                         rating SMALLINT CHECK (rating >= 1 AND rating <= 10),
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (user_id) REFERENCES users(user_id)
);