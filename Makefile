.PHONY: build up down logs test clean

up:
	docker-compose up --build -d

down:
	docker-compose down

logs:
	docker-compose logs -f

build:
	mvn clean install -DskipTests

test:
	mvn test

clean:
	mvn clean
	find . -type d -name "target" -exec rm -rf {} +

build-backend:
	cd backend/auth-service && mvn clean install -DskipTests
	cd backend/analysis-service && mvn clean install -DskipTests
	cd backend/gene-upload-service && mvn clean install -DskipTests
	cd backend/report-service && mvn clean install -DskipTests
	cd backend/kafka-consumer-service && mvn clean install -DskipTests
	cd backend/notification-service && mvn clean install -DskipTests
	cd backend/api-gateway && mvn clean install -DskipTests
	cd backend/discovery-service && mvn clean install -DskipTests
	cd backend/shared-lib && mvn clean install -DskipTests

build-frontend:
	cd frontend && npm install && npm run build

rebuild: clean build