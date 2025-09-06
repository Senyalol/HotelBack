CREATE TABLE user_roles (
                          user_roles_id SERIAL PRIMARY KEY,
                          user_id INT NOT NULL ,
                          role VARCHAR(30) NOT NULL ,
                          FOREIGN KEY (user_id) REFERENCES users(user_id)
);