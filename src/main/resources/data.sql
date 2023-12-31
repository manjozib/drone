INSERT INTO Drone (battery_Capacity, weight_Limit, model, serial_Number, state) VALUES (45, 200, 'Lightweight', 'L1', 'DELIVERING');
INSERT INTO Drone (battery_Capacity, weight_Limit, model, serial_Number, state) VALUES (20, 300, 'Middleweight', 'HD1', 'IDLE');
INSERT INTO Drone (battery_Capacity, weight_Limit, model, serial_Number, state) VALUES (99, 499, 'Heavyweight', 'H34', 'LOADING');
INSERT INTO Drone (battery_Capacity, weight_Limit, model, serial_Number, state) VALUES (24, 400, 'Cruiserweight', 'BM123', 'RETURNING');
INSERT INTO Drone (battery_Capacity, weight_Limit, model, serial_Number, state) VALUES (70, 250, 'Middleweight', 'BM3', 'IDLE');


INSERT INTO Medication (weight, code, name, image) VALUES (100, 'C8H9NO2', 'acetaminophen',
(SELECT FILE_READ('classpath:static/acetaminophen.png') FROM DUAL));
INSERT INTO Medication (weight, code, name, image) VALUES (45, 'M01AE01', 'Ibuprofen',
(SELECT FILE_READ('classpath:static/Ibuprofen.png') FROM DUAL));
INSERT INTO Medication (weight, code, name, image) VALUES (45, 'C9H8O4', 'Aspirin',
(SELECT FILE_READ('classpath:static/Aspirin.png') FROM DUAL));
INSERT INTO Medication (weight, code, name, image) VALUES (60, 'J01MA02', 'Ciprofloxacin',
(SELECT FILE_READ('classpath:static/Ciprofloxacin.png') FROM DUAL));
INSERT INTO Medication (weight, code, name, image) VALUES (45, 'A10BA02', 'Metformin',
(SELECT FILE_READ('classpath:static/Metformin.png') FROM DUAL));
INSERT INTO Medication (weight, code, name, image) VALUES (49, '50268-0620', 'Omeprazole',
(SELECT FILE_READ('classpath:static/Omeprazole.png') FROM DUAL));
