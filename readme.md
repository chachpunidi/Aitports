## Инициализация БД

Для инициализации БД приложения выполнить скрипт из текущей директории:
```aidl
docker run -d --name my-postgres -v $PWD/docker/airport-db:/docker-entrypoint-initdb.d -e POSTGRES_PASSWORD=mysecretpassword -p 5434:5432 postgres
```
Для выполнения команды потребуется установленный докер

Будет проинициализированна БД со следующими настройкамо
```
БД: demo 
адрес: localhost:5434
пользователь: postgres
пароль: mysecretpassword
```