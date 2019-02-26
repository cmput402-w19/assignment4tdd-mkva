use messageBoard;
CREATE TABLE user (
        username VARCHAR(50) NOT NULL,
		password VARCHAR(30)  NOT NULL,
        name VARCHAR(80) NOT NULL,
        email VARCHAR(50) NOT NULL,
        star INT,
        PRIMARY KEY (username)
);

CREATE TABLE post (
	ID INT NOT NULL AUTO_INCREMENT,
    type INT NOT NULL,
	parent INT,
    content VARCHAR(500) NOT NULL,
    author VARCHAR(50) NOT NULL,
    date VARCHAR(50) not null,
    votes INT,
    PRIMARY KEY (ID)
);