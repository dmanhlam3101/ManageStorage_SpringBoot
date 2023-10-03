

INSERT INTO `unit` (unit_name, status)
VALUES ('Piece', 1),
       ('Box', 1),
       ('Set', 1),
       ('Pair', 1),
       ('Piece', 1);

INSERT INTO `customer` (display_name, address, phone, email, more_info, contract_date, status)
VALUES ('John Doe', '123 Main St', '0123456789', 'johndoe@gmail.com', 'Preferred Customer', '2024-01-15', 1),
       ('Jane Smith', '456 Elm Ave', '0123456790', 'janesmith@gmail.com', 'Regular Customer', '2024-03-20', 1),
       ('Michael Johnson', '789 Oak Rd', '0123456791', 'michaeljohnson@gmail.com', 'Wholesale Customer', '2024-05-10',
        1),
       ('Emily Williams', '987 Maple Blvd', '0123456792', 'emilywilliams@gmail.com', 'VIP Customer', '2024-07-05', 1),
       ('David Brown', '543 Pine Ln', '0123456793', 'davidbrown@gmail.com', 'New Customer', '2024-09-30', 1),
       ('Sarah Davis', '321 Cedar Dr', '0123456794', 'sarahdavis@gmail.com', 'Returning Customer', '2025-02-18', 1),
       ('Robert Taylor', '654 Birch St', '0123456795', 'roberttaylor@gmail.com', 'Loyal Customer', '2025-04-25', 1),
       ('Jennifer Anderson', '876 Walnut Ct', '0123456796', 'jenniferanderson@gmail.com', 'Frequent Shopper',
        '2025-06-12', 1),
       ('William Wilson', '234 Spruce Rd', '0123456797', 'williamwilson@gmail.com', 'Casual Customer', '2025-08-08', 1),
       ('Linda Martinez', '567 Cedar Dr', '0123456798', 'lindamartinez@gmail.com', 'Regular Customer', '2025-10-03', 1);


INSERT INTO `supplier` (display_name, address, phone, email, more_info, contract_date, status)
VALUES ('Sports World Supplier', '123 Main St', '01234567890', 'sportsworld@gmail.com', 'Sports equipment supplier',
        '2024-05-10', 1),
       ('FitTech Supplies', '456 Elm Ave', '09876543210', 'fittech@gmail.com', 'Fitness technology supplier',
        '2024-03-15', 1),
       ('Active Sports Gear', '789 Oak Rd', '05551234567', 'activegear@gmail.com', 'Active sports gear supplier',
        '2024-07-20', 1),
       ('Athletic Essentials', '321 Maple Blvd', '07778889999', 'athleticessentials@gmail.com',
        'Athletic equipment essentials supplier', '2025-06-25', 1),
       ('ProSport Equipments', '567 Pine Ln', '02223334444', 'prosport@gmail.com',
        'Professional sports equipment supplier', '2025-08-05', 1),
       ('GameTime Gear', '890 Cedar St', '01112223333', 'gametimegear@gmail.com', 'Gaming and sports gear supplier',
        '2024-04-12', 1),
       ('Sportive Outdoors', '234 Birch Ave', '04445556666', 'sportiveoutdoors@gmail.com',
        'Outdoor sports equipment supplier', '2025-09-18', 1),
       ('Active Lifestyles', '678 Walnut Rd', '06667778888', 'activelifestyles@gmail.com',
        'Supplier for active lifestyle products', '2024-01-30', 1),
       ('Peak Performance', '901 Cherry Blvd', '08889990000', 'peakperformance@gmail.com',
        'Peak performance sports gear supplier', '2025-02-28', 1),
       ('FitFusion Pro', '345 Oak Rd', '09990001111', 'fitfusionpro@gmail.com', 'Fitness and wellness product supplier',
        '2024-10-15', 1);
INSERT INTO `product` (product_name, unit, supplier, status)
VALUES ('Basketball', 1, 1, 1),
       ('Yoga Mat', 1, 2, 1),
       ('Dumbbell Set', 3, 1, 1),
       ('Running Shoes', 1, 3, 1),
       ('Jump Rope', 1, 2, 1),
       ('Tennis Racket', 1, 1, 1),
       ('Resistance Bands Set', 3, 4, 1),
       ('Gymnastic Rings', 1, 3, 1),
       ('Soccer Ball', 1, 5, 1),
       ('Cycling Helmet', 1, 4, 1),
       ('Swimming Goggles', 1, 5, 1),
       ('Boxing Gloves', 1, 2, 0);



INSERT INTO `input_storage` (quantity, date_input, input_price, output_price, status)
VALUES (1500, '2022-01-15', 10.5, 15.0, 1),
       (1200, '2022-02-20', 5.0, 8.0, 1),
       (1800, '2022-03-10', 50.0, 75.0, 1),
       (1600, '2022-04-05', 15.0, 20.0, 1),
       (2000, '2022-05-15', 3.0, 5.0, 1),
       (1700, '2022-06-20', 20.0, 30.0, 1),
       (1300, '2022-07-10', 10.0, 15.0, 1),
       (1400, '2022-08-05', 35.0, 50.0, 1),
       (1900, '2023-01-15', 12.0, 18.0, 1),
       (1500, '2023-02-20', 25.0, 40.0, 1),
       (1200, '2023-03-10', 8.0, 12.0, 1),
       (1800, '2023-04-05', 18.0, 25.0, 1),
       (1600, '2023-05-15', 6.5, 10.0, 1),
       (2000, '2023-06-20', 9.0, 14.0, 1),
       (1700, '2023-07-10', 70.0, 100.0, 1);
INSERT INTO `input_storage_product` (input_id, product_id)
VALUES (1, 3),
       (2, 6),
       (3, 8),
       (4, 2),
       (5, 9),
       (6, 2),
       (7, 7),
       (8, 4),
       (9, 10),
       (10, 5),
       (11, 1),
       (12, 1),
       (13, 5),
       (14, 4),
       (15, 3);

INSERT INTO `output_storage` (quantity, date_output, status)
VALUES (150, '2022-01-15', 1),
       (200, '2022-02-20', 1),
       (250, '2022-03-10', 1),
       (180, '2022-04-05', 1),
       (120, '2022-05-15', 1),
       (300, '2022-06-20', 1),
       (220, '2022-07-10', 1),
       (130, '2022-08-05', 1),
       (170, '2023-01-15', 1),
       (240, '2023-02-20', 1),
       (200, '2023-03-10', 1),
       (150, '2023-04-05', 1),
       (280, '2023-05-15', 1),
       (130, '2023-06-20', 1),
       (170, '2023-07-10', 1);
-- Insert data into output_storage_customer
INSERT INTO output_storage_customer (customer_id, output_id)
VALUES (4, 1),
       (8, 2),
       (2, 3),
       (6, 4),
       (10, 5),
       (1, 6),
       (5, 7),
       (9, 8),
       (3, 9),
       (7, 10),
       (4, 11),
       (2, 12),
       (1, 13),
       (6, 14),
       (3, 15);

-- Insert data into output_storage_product
INSERT INTO output_storage_product (output_id, product_id)
VALUES (1, 9),
       (2, 6),
       (3, 3),
       (4, 7),
       (5, 2),
       (6, 10),
       (7, 5),
       (8, 8),
       (9, 1),
       (10, 4),
       (11, 7),
       (12, 2),
       (13, 5),
       (14, 8),
       (15, 3);
INSERT INTO `user` (display_name, username, password, role, status)
VALUES ('Admin User', 'admin', 'admin123', 'admin', 1),
       ('John Doe', 'staff', 'john123', 'staff', 1),
       ('Jane Smith', 'jane.smith', 'jane123', 'staff', 1),
       ('Michael Johnson', 'michael.johnson', 'michael123', 'staff', 1),
       ('Emily Davis', 'emily.davis', 'emily123', 'staff', 1),
       ('David Wilson', 'david.wilson', 'david123', 'staff', 1),
       ('Sarah Brown', 'sarah.brown', 'sarah123', 'staff', 1),
       ('Alex Lee', 'alex.lee', 'alex123', 'staff', 1),
       ('Jessica Taylor', 'jessica.taylor', 'jessica123', 'staff', 1),
       ('Daniel Martinez', 'daniel.martinez', 'daniel123', 'staff', 1);
