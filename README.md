# KSHshare
HBV501G2016

Opnið terminal/cmd og staðsetjið ykkur þannig að þið getið keyrt skipanirnar sem fylgja PostgreSQL
(hvar sem er ef það er í Path hjá ykkur, annars eitthvað eins og "C:\Program Files\PostgreSQL\9.6\bin")

##Windows
###Keyrið
createuser -U <Notandi sem getur búið til Role/DB> -P <Nafn á nýjum notanda>
createdb -U <Notandi sem getur búið til Role/DB> -O <Nafnið sem var búið til í síðustu skipun> <Database Nafn>
og gerið það sem promptið biður um

###Eða
psql -U <Notandi sem getur búið til Role/DB>
Gefið svo skipanirnar:
CREATE ROLE <Nafn> PASSWORD '<Lykilorð>' NOSUPERUSER NOCREATEDB NOCREATEROLE INHERIT LOGIN;
CREATE DATABASE <Database Nafn> OWNER <Nafnið sem var búið til í síðustu skipun>;
\q

###Eða
Búið til Role og Database í gegnum pgAdmin

##Linux(og væntanlega Mac)
###Keyrið
sudo -u postgres -i
createuser -P <Nafn á nýjum notanda>
createdb -O <Nafnið sem var búið til í síðustu skipun> <Database Nafn>

###Eða
sudo -u postgres -i
psql
Gefið svo skipanirnar:
CREATE ROLE <Nafn> PASSWORD '<Lykilorð>' NOSUPERUSER NOCREATEDB NOCREATEROLE INHERIT LOGIN;
CREATE DATABASE <Database Nafn> OWNER <Nafnið sem var búið til í síðustu skipun>;
\q

###Eða
Búið til Role og Database í gegnum pgAdmin

##Svo
Farið í möppu forritsins og opnið ./src/main/resources/application.properties
Breytið:
spring.datasource.url=jdbc:postgresql://localhost:5432/<Database Nafn>
spring.datasource.username=<Nafn nýja notandans>
spring.datasource.password=<Lykilorð>

Farið svo í möppu forritsins og opnið ./src/main/resources/path.cfg
Breytið:
filePath=<Hvar sem þið viljið að myndirnar séu vistaðar á tölvunni ykkar>

##Buildið með:
mvn package
