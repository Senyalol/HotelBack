CREATE TABLE room_images(
    room_image_id SERIAL PRIMARY KEY ,
    room_id INT,
    image VARCHAR(1000),
    FOREIGN KEY (room_id) REFERENCES rooms(room_id)
    ON DELETE CASCADE
);