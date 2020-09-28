FROM copilotcli/co-pilot-cli:latest

WORKDIR /config

COPY . .

RUN test/mvn-templates-test.sh
RUN test/co-pilot-orders-test.sh

CMD ["echo", "TESTING DONE"]
