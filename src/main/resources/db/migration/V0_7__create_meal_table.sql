CREATE TABLE IF NOT EXISTS "meal"(
    id  VARCHAR     CONSTRAINT meal_pk  PRIMARY KEY     DEFAULT uuid_generate_v4(),
    name    VARCHAR     NOT NULL,
    region_id    VARCHAR     NOT NULL     CONSTRAINT region_fk  REFERENCES  "region"(id),
    recipe_id    VARCHAR     NOT NULL     CONSTRAINT recipe_fk  REFERENCES  "recipe"(id),
    image    VARCHAR     NOT NULL,
    download    INTEGER     NOT NULL DEFAULT 0
);