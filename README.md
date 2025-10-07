Del 3 (Database Backend) af TuristGuide forløbet. 
Formålet med denne del var at forbinde Spring boot med MySQL database og etablere CI/CD workflow.

Læringsmål :
Designe en database vha. ER modellering og sql-scripts.
Tilgå databasen vha JdbcTemplate
Github Actions CI/CD pipeline
Deploye applikationen og databasen til Azure App Service

Github repo: https://github.com/aimo0001/Turistguide2 

ER-diagrammet findes i docs mappen. 
SQL-scripts findes under resources/templates

Beskrivelse over tabellerne:
city: indeholder byer(København, Aarhus, Odense)
tag: indeholder kategorier (Museum, Family , Park)
attraction: indeholder attraktioner med FK til city_id
attraction_tag: mange til mange relation mellem attraction og tag

Repository klassen anvender JdbcTemplate til CRUD operationer i stedet for lister.
