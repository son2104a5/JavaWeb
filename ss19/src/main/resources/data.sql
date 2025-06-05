create database ss19_db;
use ss19_db;

INSERT INTO user (username, password, email, phoneNumber, isActive) VALUES
                                                                          ('admin', '123456', 'admin@example.com', '0900000001', TRUE),
                                                                          ('john_doe', '123456', 'john@example.com', '0900000002', TRUE),
                                                                          ('jane_smith', '123456', 'jane@example.com', '0900000003', TRUE),
                                                                          ('alice', '123456', 'alice@example.com', '0900000004', FALSE),
                                                                          ('bob', '123456', 'bob@example.com', '0900000005', TRUE),
                                                                          ('charlie', '123456', 'charlie@example.com', '0900000006', FALSE),
                                                                          ('david', '123456', 'david@example.com', '0900000007', TRUE),
                                                                          ('eva', '123456', 'eva@example.com', '0900000008', TRUE),
                                                                          ('frank', '123456', 'frank@example.com', '0900000009', TRUE),
                                                                          ('grace', '123456', 'grace@example.com', '0900000010', TRUE);
