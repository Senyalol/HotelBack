CREATE TABLE rooms (
                       room_id SERIAL PRIMARY KEY,
                       room_name VARCHAR(100) NOT NULL,
                       price DECIMAL(10, 2) NOT NULL,
                       bed_type VARCHAR(50),
                       area DECIMAL(5, 2),
                       capacity INT,
                       view VARCHAR(100),
                       description TEXT,
                       status VARCHAR(20) DEFAULT 'свободен' CHECK (status IN ('свободен', 'занят', 'забронирован'))
);