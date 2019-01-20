#!/usr/bin/env bash

set -euxo pipefail

./gradlew clean build fatJar
# -H:ReflectionConfigurationFiles=reflect.json \

native-image \
  -H:+ReportUnsupportedElementsAtRuntime \
  --no-server \
  --allow-incomplete-classpath \
  --enable-url-protocols=https \
  --rerun-class-initialization-at-runtime=javax.net.ssl.SSLContext \
  -H:-UseServiceLoaderFeature \
  --enable-all-security-services \
  -jar ./build/libs/gtest-SNAPSHOT.jar

mv gtest-SNAPSHOT gtest
