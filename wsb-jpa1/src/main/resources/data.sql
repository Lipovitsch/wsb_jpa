INSERT INTO address (id, address_line1, address_line2, city, postal_code) VALUES
        (1, 'Street 1', 'Apartment 1', 'City1', '10001'),
        (2, 'Street 2', 'Apartment 2', 'City2', '10002'),
        (3, 'Street 3', 'Apartment 3', 'City3', '10003'),
        (4, 'Street 4', 'Apartment 4', 'City4', '10004'),
        (5, 'Street 5', 'Apartment 5', 'City5', '10005'),
        (6, 'Street 6', 'Apartment 6', 'City6', '10006'),
        (7, 'Street 7', 'Apartment 7', 'City7', '10007'),
        (8, 'Street 8', 'Apartment 8', 'City8', '10008'),
        (9, 'Street 9', 'Apartment 9', 'City9', '10009'),
        (10, 'Street 10', 'Apartment 10', 'City10', '10010'),
        (11, 'Street 11', 'Apartment 11', 'City11', '10011'),
        (12, 'Street 12', 'Apartment 12', 'City12', '10012'),
        (13, 'Street 13', 'Apartment 13', 'City13', '10013'),
        (14, 'Street 14', 'Apartment 14', 'City14', '10014'),
        (15, 'Street 15', 'Apartment 15', 'City15', '10015'),
        (16, 'Street 16', 'Apartment 16', 'City16', '10016'),
        (17, 'Street 17', 'Apartment 17', 'City17', '10017'),
        (18, 'Street 18', 'Apartment 18', 'City18', '10018'),
        (19, 'Street 19', 'Apartment 19', 'City19', '10019'),
        (20, 'Street 20', 'Apartment 20', 'City20', '10020');


insert into doctor (id, doctor_number, email, first_name, last_name, specialization, telephone_number, address_id) values
        (1, '123', 'john.doe@mail.com', 'John', 'Doe', 'SURGEON', '123123123', 1),
        (2, '124', 'jane.smith@mail.com', 'Jane', 'Smith', 'GP', '123123124', 2),
        (3, '125', 'michael.johnson@mail.com', 'Michael', 'Johnson', 'DERMATOLOGIST', '123123125', 3),
        (4, '126', 'sarah.williams@mail.com', 'Sarah', 'Williams', 'OCULIST', '123123126', 4),
        (5, '127', 'david.brown@mail.com', 'David', 'Brown', 'SURGEON', '123123127', 5),
        (6, '128', 'linda.jones@mail.com', 'Linda', 'Jones', 'GP', '123123128', 6),
        (7, '129', 'robert.miller@mail.com', 'Robert', 'Miller', 'DERMATOLOGIST', '123123129', 7),
        (8, '130', 'patricia.davis@mail.com', 'Patricia', 'Davis', 'OCULIST', '123123130', 8),
        (9, '131', 'james.garcia@mail.com', 'James', 'Garcia', 'SURGEON', '123123131', 9),
        (10, '132', 'elizabeth.martinez@mail.com', 'Elizabeth', 'Martinez', 'GP', '123123132', 10);

insert into patient (id, date_of_birth, date_of_registration, email, first_name, last_name, patient_number, telephone_number, address_id) values
        (1, '1990-01-13', '2020-01-01', 'adam.johnson@mail.com', 'Adam', 'Johnson', '0001', '123123133', 11),
        (2, '1990-02-14', '2020-01-02', 'emily.wilson@mail.com', 'Emily', 'Wilson', '0002', '123123134', 12),
        (3, '1990-03-15', '2020-01-03', 'charles.thomas@mail.com', 'Charles', 'Thomas', '0003', '123123135', 13),
        (4, '1990-04-16', '2020-01-04', 'sophia.jackson@mail.com', 'Sophia', 'Jackson', '0004', '123123136', 14),
        (5, '1990-05-17', '2020-01-05', 'henry.white@mail.com', 'Henry', 'White', '0005', '123123137', 15),
        (6, '1990-06-18', '2020-01-06', 'olivia.harris@mail.com', 'Olivia', 'Harris', '0006', '123123138', 16),
        (7, '1990-07-19', '2020-01-07', 'jacob.martin@mail.com', 'Jacob', 'Martin', '0007', '123123139', 17),
        (8, '1990-08-20', '2020-01-08', 'ava.thompson@mail.com', 'Ava', 'Thompson', '0008', '123123140', 18),
        (9, '1990-09-21', '2020-01-09', 'william.garcia@mail.com', 'William', 'Garcia', '0009', '123123141', 19),
        (10, '1990-10-22', '2020-01-10', 'mia.martinez@mail.com', 'Mia', 'Martinez', '0010', '123123142', 20);


insert into visit (id, description, time, doctor_id, patient_id) values
        (1, 'Routine check-up', '2023-01-01 10:00:00', 1, 1),
        (2, 'Follow-up visit', '2023-01-02 11:00:00', 1, 2),
        (3, 'Initial consultation', '2023-01-03 12:00:00', 2, 1),
        (4, 'Post-surgery check', '2023-01-04 13:00:00', 2, 2),
        (5, 'Emergency visit', '2023-01-05 14:00:00', 3, 5),
        (6, 'Routine check-up', '2023-01-06 15:00:00', 3, 6),
        (7, 'Follow-up visit', '2023-01-07 16:00:00', 4, 5),
        (8, 'Initial consultation', '2023-01-08 17:00:00', 4, 6),
        (9, 'Post-surgery check', '2023-01-09 18:00:00', 5, 5),
        (10, 'Emergency visit', '2023-01-10 19:00:00', 5, 6);


insert into medical_treatment (id, description, type, visit_id) values
        (1, 'Initial diagnosis', 'USG', 1),
        (2, 'Follow-up examination', 'EKG', 1),
        (3, 'Post-surgery check', 'RTG', 2),
        (4, 'Routine check-up', 'USG', 2),
        (5, 'Emergency treatment', 'EKG', 3),
        (6, 'Initial diagnosis', 'RTG', 3),
        (7, 'Follow-up examination', 'USG', 4),
        (8, 'Post-surgery check', 'EKG', 4),
        (9, 'Routine check-up', 'RTG', 5),
        (10, 'Emergency treatment', 'USG', 5),
        (11, 'Initial diagnosis', 'EKG', 6),
        (12, 'Follow-up examination', 'RTG', 6),
        (13, 'Post-surgery check', 'USG', 7),
        (14, 'Routine check-up', 'EKG', 7),
        (15, 'Emergency treatment', 'RTG', 8),
        (16, 'Initial diagnosis', 'USG', 8),
        (17, 'Follow-up examination', 'EKG', 9),
        (18, 'Post-surgery check', 'RTG', 9),
        (19, 'Routine check-up', 'USG', 10),
        (20, 'Emergency treatment', 'EKG', 10);