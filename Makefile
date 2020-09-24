test:
	docker build --tag co-pilot-config-test:latest .
	docker run -it --rm co-pilot-config-test:latest

pull:
	docker pull copilotcli/co-pilot-cli:latest

.PHONY: pull test
