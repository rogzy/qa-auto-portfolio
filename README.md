[![Build Status](https://travis-ci.org/rogzy/qa-auto-portfolio.svg?branch=master)](https://travis-ci.org/rogzy/qa-auto-portfolio)

Демонстрационный проект

# 1. Краткое описание
Реализация демонстрационного проекта по автоматизации тестирования.
Для примеров взяты приложения:
API - reqres.in
WEB - wiley.com

# 2. Как работать с проектом
1. Скачать целиком код проекта.
2. Установить параметры запуска:
* ci.tags.include -- api, web -- теги для запуска через запятую, по умолчанию все.
3. Выполнить для запуска тестов:
    > ./gradlew test -Pci.tags.include=your_value

# 3. Структура
* api - Пакет, предназначенный для работы с api тестируемого приложения (AUT)
* web - Пакет, предназначенный для работы с web AUT

# 4. Технологический стэк
* система автоматической сборки: gradle 5.4.1
* java 8: lombok, owner
* test: Junit 5, assertj
* api: Retrofit 2.5
* di: guice 4.2.2
* report: Allure 2.0
* logger: slf4j