CREATE TABLE meal (
                      meal_id UUID PRIMARY KEY,
                      name VARCHAR(100) NOT NULL,
                      cost DECIMAL(10, 2) NOT NULL,
                      ingredients VARCHAR(500),
                      recipe VARCHAR(1000)
);