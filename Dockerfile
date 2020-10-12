FROM co-pilot:latest

RUN apk --update add bash maven openjdk11 && \
    rm -rf /var/lib/apt/lists/* && \
    rm /var/cache/apk/*

WORKDIR /config

COPY . .

RUN test/mvn-templates-test.sh
RUN test/co-pilot-orders-test.sh

CMD ["echo", "TESTING DONE"]
