#!/usr/bin/env bash

dev() {
    echo "Starting in dev mode"
    sass
    ./gradlew jsBrowserDevelopmentWebpack
    sass "watch" &
    serve
}

prod() {
    echo "Starting in prod mode"
    sass
    ./gradlew jsBrowserProductionWebpack
    serve "sudo"
}

serve() {
    if [ "$1" == "sudo" ]; then
        env /home/daniel/.nvm/versions/node/v18.4.0/bin/node /home/daniel/.nvm/versions/node/v18.4.0/bin/serve . --listen 80 --single --cors
    else
        env serve . --listen 3000 --single --cors
    fi
}

sass() {
    echo "Compiling sass"
    if [ "$1" == "watch" ]; then
        env sass src/jsMain/resources/styles/main.scss:src/jsMain/resources/styles/main.css --watch
    else
        env sass src/jsMain/resources/styles/main.scss:src/jsMain/resources/styles/main.css
    fi
}

case "$1" in
    dev|development)
        dev
        ;;
    prod|production)
        prod
        ;;
    *)
        dev
        ;;
esac
