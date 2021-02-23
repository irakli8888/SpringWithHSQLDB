# SpringWithHSQLDB
демонстрационное Spring приложение


файл конфигурации fillForm\src\main\resources\application.properties ->

spring.datasource.url=jdbc:hsqldb:mem:{$DATABASE};DB_CLOSE_DELAY=-1 - {$DATABASE} вместо этого параметра необходимо указать вашу базу данных, если она не указана в PATH_VARIABLES
вашего компьютера

spring.datasource.username={$USERNAME} - {$USERNAME} вместо этого параметра необходимо указать ваш юзернейм HSQLDB, если он не указан в PATH_VARIABLES
вашего компьютера

spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update

upload.path = {$UPLOAD_PATH}  - {$UPLOAD_PATH} вместо этого параметра необходимо указать ваш путь загрузки картинок на сервер, если он не указан в PATH_VARIABLES
вашего компьютера (пример: /C:/Users/1/Desktop/fillForm/src/main/resources/static)

spring.http.multipart.max=10MB
spring.servlet.multipart.max-file-size=10MB
