CREATE DATABASE ACDB;
CREATE table ACTIVITYTYPE
(
ACTIVITYTYPEID SMALLINT UNSIGNED,
ACTIVITYNAME VARCHAR(255),
ACTIVITYDESC VARCHAR(2047),
CONSTRAINT PK_ACTIVITYTYPE PRIMARY KEY (ACTIVITYTYPEID)
);
CREATE table UNITTYPE
(
UNITTYPEID INT UNSIGNED,
UNITTYPENAME VARCHAR(255),
CONSTRAINT PK_UNITTYPE PRIMARY KEY (UNITTYPEID)
);
CREATE table UNITTYPEACTIVITY
(
UNITTYPEID INT UNSIGNED,
ACTIVITYTYPEID SMALLINT UNSIGNED,
CONSTRAINT PK_UNITTYPEACTIVITY PRIMARY KEY (UNITTYPEID, ACTIVITYTYPEID),
CONSTRAINT FK_UNITTYPE FOREIGN KEY (UNITTYPEID) REFERENCES UNITTYPE(UNITTYPEID),
CONSTRAINT FK_ACTIVITYTYPE FOREIGN KEY (ACTIVITYTYPEID) REFERENCES ACTIVITYTYPE(ACTIVITYTYPEID)
);
CREATE table UNIT
(
UNITTYPEID INT UNSIGNED,
UNITID MEDIUMINT UNSIGNED,
ACTIVE BOOL,
NOTES VARCHAR (2047),
CONSTRAINT PK_UNIT PRIMARY KEY (UNITTYPEID, UNITID),
CONSTRAINT FK_UNITTYPE_UNIT FOREIGN KEY (UNITTYPEID) REFERENCES UNITTYPE(UNITTYPEID)
);
CREATE TABLE USR
(
USERID VARCHAR (6),
FNAME VARCHAR (255),
LNAME VARCHAR (255),
EMAIL VARCHAR (255),
PWD CHAR(32),
CONSTRAINT PK_USR PRIMARY KEY (USERID)
);
CREATE table ACTIVITY
(
UNITTYPEID INT UNSIGNED,
UNITID MEDIUMINT UNSIGNED,
ACTIVITYTYPEID SMALLINT UNSIGNED,
ACTIVITYNUM TINYINT UNSIGNED,
USERCRT VARCHAR(6),
DATECRT TIMESTAMP,
CONSTRAINT PK_ACTIVITY PRIMARY KEY (UNITTYPEID, UNITID, ACTIVITYTYPEID, ACTIVITYNUM),
CONSTRAINT FK_ACTIVITY_UNIT FOREIGN KEY (UNITTYPEID, UNITID) REFERENCES UNIT (UNITTYPEID, UNITID),
CONSTRAINT FK_ACTIVITY_ACTTYPE FOREIGN KEY (ACTIVITYTYPEID) REFERENCES ACTIVITYTYPE (ACTIVITYTYPEID),
CONSTRAINT FK_ACTIVITY_USER FOREIGN KEY (USERCRT) REFERENCES USR (USERID) 
);