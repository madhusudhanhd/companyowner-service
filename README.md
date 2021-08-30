# Company Owner REST API Application

A company has the following attributes:
* Company Name
* Country
* Phone Number
* One or more owners

An owner has the following attributes:
* Name
* Social Security Number

Below are the list of supported functions:
* Create new company
* Get a list of all companies
* Get details about a company
* Update a company
* Add an owner of the company
* Check of Social Security Number


The entire application is contained within the `app.rb` file.

`config.ru` is a minimal Rack configuration for unicorn.

`run-tests.sh` runs a simplistic test and generates the API
documentation below.

It uses `run-curl-tests.rb` which runs each command defined in
`commands.yml`.

## Swagger API Documentation

    http://localhost:9002/v2/api-docs
    http://localhost:9002/swagger-ui.html

## Install

    bundle install

## Run the app

    unicorn -p 7000

## Run the tests

    ./run-tests.sh

# REST API

The REST API to the Company Owner app is described below.

## Create new company

### Request

`POST /company/create`

    curl --location --request POST 'http://localhost:9002/company/create' \ --header 'Content-Type: application/json' \ --data-raw '{     "name": "LG Nokia India Ltd",     "country": "India",     "phoneNbr": "+91-8039839833" }'

### Response

    {"id":1,"name":"LG Nokia India Ltd","country":"India","phoneNbr":"+91-8039839833","owners":[]}

## Get a list of all companies

### Request

`GET /company/getAllCompanies`

    curl --location --request GET 'http://localhost:9002/company/getAllCompanies'

### Response
	Status: 200 OK
	Content-Type: application/json
	[{"id":1,"name":"LG Nokia India Ltd","country":"India","phoneNbr":"+91-8039839833","owners":[{"id":1,"name":"Madhu","socialSecurityNumber":null}]}]

## Get details about a company

### Request

`GET /company/getCompanyById/{id}`

    curl --location --request GET 'http://localhost:9002/company/getCompanyById/1'

### Response
	Status: 200 OK
	Content-Type: application/json
    {"id":1,"name":"LG Nokia India Ltd","country":"India","phoneNbr":"+91-8039839833","owners":[]}



## Update a company

### Request

`PUT /updateCompany/{id}`

    curl --location --request PUT 'http://localhost:9002/company/updateCompany/2' --header 'Content-Type: application/json' --data-raw '{
    "name":"Nokia de",
    "country":"India",
    "phoneNbr":"+91-8039839833"
}'

### Response
	Status: 200 OK
	Content-Type: application/json
    {"id":2,"name":"Nokia de","country":"India","phoneNbr":"+91-8039839833","owners":[]}




## Add an owner of the company

### Request

`GET /company/getCompanyById/{id}`

    curl --location --request GET 'http://localhost:9002/company/getCompanyById/1'

### Response
	Status: 200 OK
	Content-Type: application/json
    {"id":1,"name":"LG Nokia India Ltd","country":"India","phoneNbr":"+91-8039839833","owners":[]}


## Check of Social Security Number

### Request

`GET /company/getCompanyById/{id}`

    curl --location --request GET 'http://localhost:9002/owner/isValidSSN/08923909382'

### Response
	Status: 200 OK
	Content-Type: application/json
    VALID
    or
    INVALID



### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)


