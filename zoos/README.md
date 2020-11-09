# Java Zoos

Repository: https://github.com/LambdaSchool/java-zoos

Using the provided seed data, the given endpoint will produce the stated output. Expand each endpoint to see its correct output. Note that the stretch goals change the database layout and so a complete separate project is done for those!

### MVP

<details>
<summary>http://localhost:2019/animals/count</summary>

```JSON
[
    {
        "animaltype": "bear",
        "animalid": 2,
        "countzoos": 3
    },
    {
        "animaltype": "lion",
        "animalid": 1,
        "countzoos": 3
    },
    {
        "animaltype": "llama",
        "animalid": 6,
        "countzoos": 1
    },
    {
        "animaltype": "monkey",
        "animalid": 3,
        "countzoos": 0
    },
    {
        "animaltype": "penguin",
        "animalid": 4,
        "countzoos": 0
    },
    {
        "animaltype": "tiger",
        "animalid": 5,
        "countzoos": 1
    },
    {
        "animaltype": "turtle",
        "animalid": 7,
        "countzoos": 1
    }
]
```

</details>

<details>
<summary>http://localhost:2019/zoos/zoos</summary>

```JSON
[
    {
        "zooid": 1,
        "zooname": "Gladys Porter Zoo",
        "telephones": [
            {
                "phoneid": 1,
                "phonetype": "MAIN",
                "phonenumber": "555-555-5555"
            },
            {
                "phoneid": 2,
                "phonetype": "EDUCATION",
                "phonenumber": "555-555-1234"
            },
            {
                "phoneid": 3,
                "phonetype": "MEMBERSHIP",
                "phonenumber": "555-555-4321"
            }
        ],
        "animals": [
            {
                "animal": {
                    "animalid": 1,
                    "animaltype": "lion"
                },
                "incomingzoo": "Point Defiance Zoo"
            },
            {
                "animal": {
                    "animalid": 2,
                    "animaltype": "bear"
                },
                "incomingzoo": "Point Defiance Zoo"
            }
        ]
    },
    {
        "zooid": 2,
        "zooname": "Point Defiance Zoo",
        "telephones": [],
        "animals": [
            {
                "animal": {
                    "animalid": 2,
                    "animaltype": "bear"
                },
                "incomingzoo": "Gladys Porter Zoo"
            }
        ]
    },
    {
        "zooid": 3,
        "zooname": "San Diego Zoo",
        "telephones": [
            {
                "phoneid": 5,
                "phonetype": "MAIN",
                "phonenumber": "555-123-5555"
            }
        ],
        "animals": [
            {
                "animal": {
                    "animalid": 1,
                    "animaltype": "lion"
                },
                "incomingzoo": "Gladys Porter Zoo"
            },
            {
                "animal": {
                    "animalid": 2,
                    "animaltype": "bear"
                },
                "incomingzoo": "Point Defiance Zoo"
            }
        ]
    },
    {
        "zooid": 4,
        "zooname": "San Antonio Zoo",
        "telephones": [
            {
                "phoneid": 4,
                "phonetype": "MAIN",
                "phonenumber": "123-555-5555"
            }
        ],
        "animals": []
    },
    {
        "zooid": 5,
        "zooname": "Smithsonian National Zoo",
        "telephones": [],
        "animals": [
            {
                "animal": {
                    "animalid": 7,
                    "animaltype": "turtle"
                },
                "incomingzoo": "San Diego Zoo"
            },
            {
                "animal": {
                    "animalid": 6,
                    "animaltype": "llama"
                },
                "incomingzoo": "Gladys Porter Zoo"
            },
            {
                "animal": {
                    "animalid": 5,
                    "animaltype": "tiger"
                },
                "incomingzoo": "Gladys Porter Zoo"
            },
            {
                "animal": {
                    "animalid": 1,
                    "animaltype": "lion"
                },
                "incomingzoo": "Gladys Porter Zoo"
            }
        ]
    }
]
```

</details>

<details>
<summary>http://localhost:2019/zoos/zoo/5</summary>

```JSON
{
    "zooid": 5,
    "zooname": "Smithsonian National Zoo",
    "telephones": [],
    "animals": [
        {
            "animal": {
                "animalid": 7,
                "animaltype": "turtle"
            },
            "incomingzoo": "San Diego Zoo"
        },
        {
            "animal": {
                "animalid": 6,
                "animaltype": "llama"
            },
            "incomingzoo": "Gladys Porter Zoo"
        },
        {
            "animal": {
                "animalid": 5,
                "animaltype": "tiger"
            },
            "incomingzoo": "Gladys Porter Zoo"
        },
        {
            "animal": {
                "animalid": 1,
                "animaltype": "lion"
            },
            "incomingzoo": "Gladys Porter Zoo"
        }
    ]
}
```

</details>

<details>
<summary>POST http://localhost:2019/zoos/zoo</summary>

DATA

```JSON
{
    "zooname": "Lambda Llama School Zoo",
    "telephones": [
            {
                "phonetype": "OTHER",
                "phonenumber": "555-555-5555"
            },
            {
                "phonetype": "EDUCATION",
                "phonenumber": "555-555-1234"
            }
        ],
    "animals": [
        {
            "animal": {
                "animalid": 1
            },
            "incomingzoo": "San Diego Zoo"
        },
        {
            "animal": {
                "animalid": 2
            },
            "incomingzoo": "Gladys Porter Zoo"
        },
        {
            "animal": {
                "animalid": 3,
                "animaltype": "tiger"
            }
        }
    ]
}
```

OUTPUT

```TEXT
No Body Data

Location Header: http://localhost:2019/zoos/zoo/10
Status 201 Created
```

</details>

<details>
<summary>PUT http://localhost:2019/zoos/zoo/5</summary>

DATA

```JSON
{
    "zooname": "The Best Zoo",
    "telephones": [
            {
                "phonetype": "OTHER",
                "phonenumber": "555-555-5555"
            }
        ],
    "animals": [
        {
            "animal": {
                "animalid": 3
            },
            "incomingzoo": "San Diego Zoo"
        },
        {
            "animal": {
                "animalid": 5
            },
            "incomingzoo": "Gladys Porter Zoo"
        },
        {
            "animal": {
                "animalid": 7,
                "animaltype": "tiger"
            }
        }
    ]
}
```

OUTPUT

```TEXT
No Body Text

Status OK
```

</details>

<details>
<summary>PATCH http://localhost:2019/zoos/zoo/4</summary>

DATA

```JSON
{
     "telephones": [
            {
                "phonetype": "OTHER",
                "phonenumber": "555-555-5555"
            }
        ]
}
```

OUTPUT

```TEXT
No Body Data

Status OK
```

</details>

<details>
<summary>DELETE http://localhost:2019/zoos/zoo/5</summary>

OUTPUT

```TEXT
No Body Data

Status OK
```

</details>
