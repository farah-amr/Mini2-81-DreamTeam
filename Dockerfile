FROM ubuntu:latest
LABEL authors="farahamr"

ENTRYPOINT ["top", "-b"]