all: build

start:
	@docker-compose up -d

build:
	@./gradlew build --warning-mode all

rebuild:
	@docker compose down -v --remove-orphans && docker compose up --build --force-recreate --no-deps -d

lint:
	@docker exec ivanhernandez-java_ddd_example-test_server ./gradlew spotlessCheck

run-tests:
	@./gradlew test --warning-mode all

test:
	@docker exec ivanhernandez-java_ddd_example-test_server ./gradlew test --warning-mode all

run:
	@./gradlew :run

ping-mysql:
	@docker exec ivanhernandez-java_ddd_example-mysql mysqladmin --user=root --password= --host "127.0.0.1" ping --silent
