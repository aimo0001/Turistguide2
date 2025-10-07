erDiagram
CITY {
int id PK
varchar(120) name UNIQUE
}

TAG {
int id PK
varchar(80) name UNIQUE
}

ATTRACTION {
int id PK
varchar(160) name UNIQUE
text description
varchar(120) city
}

ATTRACTION_TAG {
int attraction_id FK
int tag_id FK
PK (attraction_id, tag_id)
}

ATTRACTION }o--o{ TAG : has


