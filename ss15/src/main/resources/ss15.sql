create database ss15_db;
use ss15_db;

CREATE TABLE product (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         price DECIMAL(10,2),
                         description TEXT,
                         image VARCHAR(255)
);

CREATE TABLE review (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        product_id INT,
                        user_id INT,
                        rating INT CHECK (rating BETWEEN 1 AND 5),
                        comment TEXT
);

CREATE TABLE cart (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      user_id INT NOT NULL,
                      product_id INT NOT NULL,
                      quantity INT NOT NULL DEFAULT 1,
                      FOREIGN KEY (product_id) REFERENCES product(id)
);


CREATE TABLE orders (
                        order_id INT AUTO_INCREMENT PRIMARY KEY,
                        id_user INT,
                        recipient_name VARCHAR(255),
                        address VARCHAR(255),
                        phone_number VARCHAR(20)
);

CREATE TABLE order_details (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               order_id INT,
                               product_id INT,
                               quantity INT,
                               current_price DECIMAL(10,2)
);

