# UILogger

Simple service with rest endpoint to collect logs and save them to db

## Building


Compile and run tests:
```
mvn clean install
```

Start the app in dev-mode:

```
mvn clean install quarkus:dev
```

## Running app

set DB connection in resources/application.properties or export env variables:

```
export POSTGRESQL_URL="jdbc:postgresql://connection"
export POSTGRESQL_USER="user"
export POSTGRESQL_PASS="password"
```
then

```
java -jar target/uilogger-runner.jar
```

## App info

`/doc` openapi documentation

`/rest/version` endpoint returns version and build information about running app
