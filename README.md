# multiroomchat-backend

Start container:

docker run -it -d --name mongochat \
    -e MONGO_INITDB_ROOT_USERNAME= \
    -e MONGO_INITDB_ROOT_PASSWORD= \
    -v /volumes/mongodb/chat:/data/db \
    -p 27017:27017 \
    mongo:4.4.0-bionic