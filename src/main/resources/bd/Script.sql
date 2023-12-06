-- Database: vehicles-jee

-- DROP DATABASE IF EXISTS "vehicles-jee";

CREATE DATABASE "vehicles-jee"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Spain.1252'
    LC_CTYPE = 'Spanish_Spain.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
-- Database: vehicles-jee

-- DROP DATABASE IF EXISTS "vehicles-jee";

CREATE SCHEMA vehicles;

CREATE TABLE Vehicle (
                         vehicle_code SERIAL PRIMARY KEY,
                         vehicle_plates VARCHAR(8),
                         vehicle_comment VARCHAR,
                         vehicle_purchasedDate DATE,
                         vehicle_lastMaintenance DATE,
                         vehicle_price DECIMAL(10,2)
);

CREATE TABLE Model (
                       model_code SERIAL PRIMARY KEY,
                       model_year INT,
                       model_brand VARCHAR,
                       model_manufacter VARCHAR
);

-- Modificar la tabla Vehicle para incluir la relación con Model
ALTER TABLE Vehicle
    ADD COLUMN model_code INT,
ADD CONSTRAINT fk_model
    FOREIGN KEY (model_code)
    REFERENCES Model(model_code)
    ON DELETE CASCADE;


INSERT INTO Model (model_year, model_brand, model_manufacter) VALUES
                                                                  (2020, 'Sedan', 'Toyota'),
                                                                  (2019, 'SUV', 'Honda'),
                                                                  (2021, 'Coupe', 'Ford'),
                                                                  (2018, 'Hatchback', 'Volkswagen'),
                                                                  (2022, 'Truck', 'Chevrolet'),
                                                                  (2017, 'Convertible', 'BMW'),
                                                                  (2016, 'Minivan', 'Chrysler'),
                                                                  (2023, 'Sports Car', 'Porsche'),
                                                                  (2015, 'Crossover', 'Nissan'),
                                                                  (2014, 'Electric', 'Tesla');



INSERT INTO Vehicle (vehicle_plates, vehicle_comment, vehicle_purchasedDate, vehicle_lastMaintenance, model_code, vehicle_price) VALUES
                                                                                                                                     ('ABC12345', 'First vehicle', '2022-01-01', '2022-06-01', 1, 100.20),
                                                                                                                                     ('XYZ67890', 'Second vehicle', '2021-05-15', '2022-03-10', 2, 100.20),
                                                                                                                                     ('DEF54321', 'Third vehicle', '2020-11-20', '2021-09-05', 3, 100.20),
                                                                                                                                     ('GHI98765', 'Fourth vehicle', '2023-02-28', '2023-10-15', 4, 100.20),
                                                                                                                                     ('JKL23456', 'Fifth vehicle', '2019-07-12', '2020-04-30', 5, 100.20),
                                                                                                                                     ('MNO87654', 'Sixth vehicle', '2020-03-05', '2021-01-20', 6, 100.20),
                                                                                                                                     ('PQR78901', 'Seventh vehicle', '2021-09-30', '2022-08-25', 7, 100.20),
                                                                                                                                     ('STU01234', 'Eighth vehicle', '2022-11-15', '2023-07-02', 8, 100.20),
                                                                                                                                     ('VWX45678', 'Ninth vehicle', '2018-04-22', '2019-12-10', 9, 100.20),
                                                                                                                                     ('YZA89012', 'Tenth vehicle', '2019-12-10', '2020-08-01', 10, 100.20);