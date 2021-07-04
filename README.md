# graph-QL

- New API standard that provides a more efficient, powerful and flexible alternative to REST (Representational State Transfer)
- GraphQL enables declarative data fetching where a client can specify exactly what data it needs from an API
- Not a DB based language
<img src="/images/diagram.png" width="800" height="450" />
<details>
    <summary>Problems with REST</summary>
    
    Multiple End points- Server and views coupled together
    Backend needs to be adjusted
    REST APIs have shown to be too inflexible to keep up with the rapidly changing requirements on the clients that access them
</details>

#### Flow

- Static View -> Query -(Server)-> Data -(Store)-> Views
- Flow will be handled by GraphQl Client

#### GraphQL Client (Relay/Apollo)

- Fetching through REST
  - Construct and send http request
  - Receive and parse response
  - Store locally
  - Finally display in UI
- With GraphQL client
  - Declare the data
  - Display the data in UI

### Queries

- [x] <b>Read[GET]</b>

```
{
    allUsers(last: 2) {
        name
    }
}
```

`Response`

```
{
    "allUsers" : [
        {"name" : "Vikas"},
        {"name" : "Teckudos"}
    ]
}
```

- [x] <b>Mutations[WRITE]</b>

```
mutation {
    createUser(id: "1", name:"Vikas", age: "25") {
        id
        name
        age
    }
}
```

`Response`

```
"createUser": {
    "id": 1,
    "name": "Vikas",
    "age": "25",
}
```

- [x] <b>Subscription</b>

```
subscription {
    newUser {
        id
        name
        age
    }
}
```

`Whenever Mutations changes something Subscription act on it`

### Schema

- Define root
  - Query
  - Mutation
  - Subscription
- Define Payload/Data

```
type Query {
    allUsers(last: int): [Person!]!
}
type Mutation {
    createUser(name: String!, age: Int!): Person!
}
type Subscription {
    newUser: Person!
}
type User {
    id: Int!
    name: String!
    age: Int!
    posts: [Post!]!
}
type Post {
    title: String!
    author: Person!
}
```
