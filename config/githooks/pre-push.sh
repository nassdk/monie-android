#!/bin/sh

echo "Запускаем анализатор кода детект..."

# Inspect code using Detekt
bash gradlew detekt

status=$?

if [ "$status" = 0 ] ; then
    echo "Анализатор кода закончил проверку. Хорошая работа:)"
    exit 0
else
    echo 1>&2 "Анализатор кода нашел нарушения. Поправь их пожалуйста!"
    exit 1
fi
