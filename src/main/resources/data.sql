INSERT INTO brand
(id, name)
VALUES
    (1, 'BERNER'),
    (2, 'WINTERSTEIGER'),
    (3, '4SERWIS'),
    (4, 'BTWIN'),
    (5, 'DYSTRYBUCJA ZEWNĘTRZNA');


INSERT INTO product_details
    (id, name, link, safety_data, brand_id, gama, code)
VALUES
    (1, 'środek do usuwania naklejek','null' , 'https://drive.google.com/file/d/1cuib0iur0o7nudhuktp3mn6anak8c9jw/view?usp=drive_link', 1, 'g1', '367943 '),
    (2, 'Smar do gwintów', 'null', 'https://drive.google.com/file/d/1lh9tcmXzlLmcPpOm3StjMJefTSXdDeRi/view?usp=drive_link', 1, 'G1', '399310'),
    (3, 'Odrdzewiacz MoS2', 'null', 'https://drive.google.com/file/d/1t_WI_9vdwYOmr-FpMmMmdFike9BLUPyv/view?usp=drive_link', 1, 'G1', '207445 '),
    (4, 'Spray do czyszczenia opon', 'null', 'https://drive.google.com/file/d/1T6WDMZsha50_A_icHaTgizJJhZVAkRi9/view?usp=drive_link', 1, 'G1', '365877 '),
    (5, 'SMAR UNIWERSALNY 400G', 'null', 'https://drive.google.com/file/d/1k3m8tBVexXpBUcvkWEQZODe8X_OUi8gJ/view?usp=drive_link', 1, 'G1', '215894 '),
    (6, 'ODTŁUSZCZACZ 500 ML', 'null', 'https://drive.google.com/file/d/1EfB4cmjKbSI6897XYwZT2MwyqCTE44eK/view?usp=drive_link', 1, 'G1', '409029 '),
    (7, 'SPRAY UNIWERSALNY S6 PLUS 400 ML', 'null', 'https://drive.google.com/file/d/1e_GQvBDi0PtzSKcIjIxW_PDt-bH9og-L/view?usp=drive_link', 1, 'G1', '14195 '),
    (8, 'DOT4', 'null', 'https://drive.google.com/file/d/1PAHiO-TrD0gh3za-6PnMHeyd5Sp3-uw5/view?usp=drive_link', 1, 'G2', '60729 '),
    (9, 'SMAR ADHEZYJNY SPRAY 400ML', 'null', 'https://drive.google.com/file/d/14z04j_eYwIfLhQ9s26KHG8JsbTr3mIKI/view?usp=drive_link', 1, 'G2', '143656 '),
    (10, 'Spray Do Montażu/ Demontażu Opon', 'null', 'https://drive.google.com/file/d/1inyj7egnj0KkAzt23Mmv4e5s-Eu8w6UG/view?usp=drive_link', 1, 'G2', '249576 '),
    (11, 'KREM DO PIELĘGN. RĄK (NIEWIDZIALNA RĘKAWICZKA) 250ML', 'null', 'ND', 1, 'G1', '240033 '),
    (12, 'ŚR.DO OSADZANIA ŁOŻYSK/TULEI 60g', 'null', 'https://drive.google.com/file/d/1lXPIT3cIivjhKp3dtGNKTsMD1mtm4cbT/view?usp=drive_link', 1, 'null', '244688 '),
    (13, 'PASTA DO RĄK STANDARD 2L', 'null', 'ND', 1, 'G1', '362807 '),
    (14, 'PASTA DO RĄK STANDARD 3L', 'null', 'ND', 1, 'G1', '362813 '),
    (15, 'PASTA DO RĄK PREMIUM 2L', 'null', 'ND', 1, 'G1', '420472 '),
    (16, 'PASTA DO RĄK 10L WIADRO', 'null', 'ND', 1, 'G1', '132238 '),
    (17, 'SYNT. SMAR PENETRUJĄCY 500 ML', 'null', 'https://drive.google.com/file/d/190C9zl_6HAMop_dHDyCm0GMrUraumfck/view?usp=drive_link', 1, 'G1', '207824 '),
    (18, 'ZMYWACZ DO HAMULCÓW KAN. 5 L', 'null', 'https://drive.google.com/file/d/1HjX-M2oHKDQT_WoWAOemKwZfBuXRNO74/view?usp=drive_link', 1, 'G1', '245435 '),
    (19, 'SMAR GRAFITOWY 400G', 'null', 'https://drive.google.com/file/d/1XsOAez08QnVMXgw1-mYJyJqqA5Z4tcJP/view?usp=drive_link', 1, 'G1', '215898 '),
    (20, 'BALSAM PIELĘGNACYJNY DO SKÓRY 250ML', 'null', 'ND', 1, 'G1', '420474');

insert into employee
    (id, first_name, last_name, email, password, store_id)
values
    (1, 'Cordie', 'Striker', 'root@email.com','{noop}pass' , '729'),
    (2, 'Massimiliano', 'Zimmermeister', 'mzimmermeister1@prnewswire.com', '{noop}pass', '651'),
    (3, 'Justin', 'Priscott', 'jpriscott2@mit.edu', '{noop}pass', '729'),
    (4, 'Christophorus', 'Domokos', 'cdomokos3@alibaba.com', '{noop}pass', '651'),
    (5, 'Kristina', 'Durram', 'kdurram4@diigo.com', '{noop}pass', '729'),
    (6, 'Lizzie', 'Siddaley', 'lsiddaley5@wisc.edu', '{noop}pass', '651'),
    (7, 'Town', 'Pero', 'tpero6@youtu.be', '{noop}pass', '729'),
    (8, 'Obidiah', 'Harce', 'oharce7@reuters.com', '{noop}pass', '651'),
    (9, 'Brennan', 'Dunstone', 'bdunstone8@prlog.org', '{noop}pass', '729'),
    (10, 'Glynis', 'Muckeen', 'gmuckeen9@oakley.com', '{noop}pass', '651'),
    (11, 'Skippy', 'Brandt', 'sbrandta@eepurl.com', '{noop}pass', '729'),
    (12, 'Olly', 'Tallowin', 'otallowinb@techcrunch.com', '{noop}pass', '651'),
    (13, 'Elnar', 'Easen', 'eeasenc@squarespace.com', '{noop}pass', '729'),
    (14, 'Osborn', 'Vipan', 'ovipand@lulu.com', '{noop}pass', '651'),
    (15, 'Emmanuel', 'Greenaway', 'egreenawaye@usa.gov', '{noop}pass', '729'),
    (16, 'Ulrika', 'Fountain', 'ufountainf@dot.gov', '{noop}pass', '651'),
    (17, 'Burton', 'Full', 'bfullg@digg.com', '{noop}pass', '729'),
    (18, 'Kenyon', 'Lapthorn', 'klapthornh@booking.com', '{noop}pass', '651'),
    (19, 'Kaitlynn', 'Florence', 'kflorencei@theguardian.com', '{noop}pass', '729'),
    (20, 'Son', 'Colliar', 'scolliarj@fema.gov', '{noop}pass', '651');

INSERT INTO employee_role
    (id, name)
VALUES
    (1, 'ADMIN'),
    (2, 'EMPLOYEE');

INSERT INTO
    employee_roles (employee_id, role_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 2);

INSERT INTO store
(id, name)
VALUES
    (1, "RUMIA"),
    (2, "GDAŃSK KARTUSKA");
