build: install
	docker build --tag co-pilot-testsite:latest .

run: build
	docker run -it --rm -p 8080:8080 co-pilot-testsite:latest

install:
	mvn clean install
