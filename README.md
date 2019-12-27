В данном проекте представлен простой REST API, сделанный по одному из туториалов, взятому на baeldung.com.
Наш REST API передает Json-objects, c помощью фреймворка Spark. БД на стороне сервера выступает HashMap, которая
работает в Runtime.
<details><summary>Примеры запросов</summary>

`Request:`

### POST http://localhost:4567/users - create user

```javascript
{
    "id": "1012",
    "email": "your-email@your-domain.com",
    "firstName": "Mac",
    "lastName": "Mason1"
}
```

`Response:`

```javascript
{
    "status":"SUCCESS"
}
```

`Request:`

### GET http://localhost:4567/users - get all users
`Response:`

```javascript
{
    "status":"SUCCESS",
    "data":[
        {
            "id":"1014",
            "firstName":"John",
            "lastName":"Miller",
            "email":"your-email@your-domain.com"
        },
        {
            "id":"1012",
            "firstName":"Mac",
            "lastName":"Mason1",
            "email":"your-email@your-domain.com"
        }
    ]
}
```

`Request:`

### GET http://localhost:4567/users/1012 - get user by id
`Response:`

```javascript
{
    "status":"SUCCESS",
    "data":{
        "id":"1012",
        "firstName":"Mac",
        "lastName":"Mason1",
        "email":"your-email@your-domain.com"
    }
}
```

`Request:`

### PUT http://localhost:4567/users/1012 - change user by id (In this example, change the lastName)

```javascript
{
    "lastName": "Mason"
}
```

`Response:`

```javascript
{
    "status":"SUCCESS",
    "data":{
        "id":"1012",
        "firstName":"Mac",
        "lastName":"Mason",
        "email":"your-email@your-domain.com"
    }
}
```

`Request:`

### DELETE http://localhost:4567/users/1012 - delete user by id
`Response:`

```javascript
{
    "status":"SUCCESS",
    "message":"user deleted"
}
```

`Request:`

### OPTIONS http://localhost:4567/users/1012 - check that user exists
`Response:`

```javascript
{
    "status":"SUCCESS",
    "message":"User exists"
}
```
</details>

