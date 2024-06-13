CREATE TABLE IF NOT EXISTS RUNS(
ID INT NOT NULL,
TITLE VARCHAR(250) NOT NULL,
STARTED_ON TIMESTAMP NOT NULL,
COMPLETED_ON TIMESTAMP NOT NULL,
MILES INT NOT NULL,
LOCATION VARCHAR(10) NOT NULL,
PRIMARY KEY(ID)
);