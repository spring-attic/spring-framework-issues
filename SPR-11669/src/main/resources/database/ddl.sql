CREATE TABLE member (
    id CHAR(36) NOT NULL,
    name NVARCHAR(50) NOT NULL,
    email NVARCHAR(256) NOT NULL,
    CONSTRAINT pk_member PRIMARY KEY(id),
    CONSTRAINT uk_member1 UNIQUE KEY(email)
);
COMMIT;