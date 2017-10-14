CREATE TABLE Code (
    Id        INT           IDENTITY NOT NULL,
    CodeType  VARCHAR (10) NOT NULL,
    CodeValue VARCHAR (10) NOT NULL,
    CodeText  VARCHAR (10) NOT NULL,
    ParentId  INT           NULL,
    PRIMARY KEY (Id),
    CONSTRAINT FK_Table_ToTable FOREIGN KEY (ParentId) REFERENCES Code (Id)
);