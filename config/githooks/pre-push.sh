#!/bin/sh

echo "Launching detekt"

# Inspect code using Detekt
bash gradlew detekt

status=$?

if [ "$status" = 0 ] ; then
    exit 0
else
    exit 1
fi
