CREATE TABLE _user(
    id SERIAL PRIMARY KEY,
    _email VARCHAR(50) NOT NULL,
    _firstname VARCHAR(50) NOT NULL,
    _lastname VARCHAR(50) NOT NULL,
    _phone VARCHAR(10) NOT NULL,
    address_id int NOT NULL
);

CREATE TABLE _address(
    id SERIAL PRIMARY KEY,
    _number VARCHAR(10) NOT NULL,
    _street VARCHAR(50) NOT NULL,
    _zipcode VARCHAR(5) NOT NULL,
    _city VARCHAR(30) NOT NULL
);

CREATE TABLE _order(
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    _beginning TIMESTAMP NOT NULL,
    _end TIMESTAMP NOT NULL,
    _total NUMERIC(5,2) NOT NULL
);

CREATE TABLE _burger(
    id SERIAL PRIMARY KEY,
    _label VARCHAR(15),
    _price NUMERIC(4,2)
);

CREATE TABLE _order_items(
    order_id INT NOT NULL,
    burger_id INT NOT NULL,
    _quantity INT NOT NULL,
);

ALTER TABLE _user ADD FOREIGN KEY (address_id) REFERENCES _address(id);

ALTER TABLE _order ADD FOREIGN KEY (user_id) REFERENCES _user(id);

ALTER TABLE _order_items ADD PRIMARY KEY (burger_id, order_id);

ALTER TABLE _order_items ADD FOREIGN KEY (order_id) REFERENCES _order(id);
ALTER TABLE _order_items ADD FOREIGN KEY (burger_id) REFERENCES _burger(id);