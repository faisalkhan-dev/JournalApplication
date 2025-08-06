# OpenAPI definition



**Version:** v0

## Base URLs

- `http://localhost:8080` - Generated server url

## Endpoints

### `GET /user`

#### Responses

| Status Code | Description | Schema |
|-------------|-------------|--------|
| 200 | OK | ```json
{
  "*/*": {
    "schema": {
      "type": "object"
    }
  }
}
``` |

### `PUT /user`

#### Request Body

```json
{
  "application/json": {
    "schema": {
      "$ref": "#/components/schemas/User"
    }
  }
}
```

#### Responses

| Status Code | Description | Schema |
|-------------|-------------|--------|
| 200 | OK | ```json
{
  "*/*": {
    "schema": {
      "type": "object"
    }
  }
}
``` |

### `DELETE /user`

#### Responses

| Status Code | Description | Schema |
|-------------|-------------|--------|
| 200 | OK | ```json
{
  "*/*": {
    "schema": {
      "type": "object"
    }
  }
}
``` |

### `GET /journal/id/{myId}`

#### Parameters

| Name | In | Required | Description | Type |
|------|----|----------|-------------|------|
| `myId` | path | Yes | - | - |

#### Responses

| Status Code | Description | Schema |
|-------------|-------------|--------|
| 200 | OK | ```json
{
  "*/*": {
    "schema": {
      "$ref": "#/components/schemas/JournalEntry"
    }
  }
}
``` |

### `PUT /journal/id/{myId}`

#### Parameters

| Name | In | Required | Description | Type |
|------|----|----------|-------------|------|
| `myId` | path | Yes | - | - |

#### Request Body

```json
{
  "application/json": {
    "schema": {
      "$ref": "#/components/schemas/JournalEntry"
    }
  }
}
```

#### Responses

| Status Code | Description | Schema |
|-------------|-------------|--------|
| 200 | OK | ```json
{
  "*/*": {
    "schema": {
      "type": "object"
    }
  }
}
``` |

### `DELETE /journal/id/{myId}`

#### Parameters

| Name | In | Required | Description | Type |
|------|----|----------|-------------|------|
| `myId` | path | Yes | - | - |

#### Responses

| Status Code | Description | Schema |
|-------------|-------------|--------|
| 200 | OK | ```json
{
  "*/*": {
    "schema": {
      "type": "object"
    }
  }
}
``` |

### `POST /public/signup`

#### Request Body

```json
{
  "application/json": {
    "schema": {
      "$ref": "#/components/schemas/User"
    }
  }
}
```

#### Responses

| Status Code | Description | Schema |
|-------------|-------------|--------|
| 200 | OK | - |

### `POST /public/login`

#### Request Body

```json
{
  "application/json": {
    "schema": {
      "$ref": "#/components/schemas/User"
    }
  }
}
```

#### Responses

| Status Code | Description | Schema |
|-------------|-------------|--------|
| 200 | OK | ```json
{
  "*/*": {
    "schema": {
      "type": "string"
    }
  }
}
``` |

### `GET /journal`

#### Responses

| Status Code | Description | Schema |
|-------------|-------------|--------|
| 200 | OK | ```json
{
  "*/*": {
    "schema": {
      "type": "object"
    }
  }
}
``` |

### `POST /journal`

#### Request Body

```json
{
  "application/json": {
    "schema": {
      "$ref": "#/components/schemas/JournalEntry"
    }
  }
}
```

#### Responses

| Status Code | Description | Schema |
|-------------|-------------|--------|
| 200 | OK | ```json
{
  "*/*": {
    "schema": {
      "$ref": "#/components/schemas/JournalEntry"
    }
  }
}
``` |

### `POST /admin/create-admin-user`

#### Request Body

```json
{
  "application/json": {
    "schema": {
      "$ref": "#/components/schemas/User"
    }
  }
}
```

#### Responses

| Status Code | Description | Schema |
|-------------|-------------|--------|
| 200 | OK | - |

### `GET /public/health-check`

#### Responses

| Status Code | Description | Schema |
|-------------|-------------|--------|
| 200 | OK | ```json
{
  "*/*": {
    "schema": {
      "type": "string"
    }
  }
}
``` |

### `GET /admin/clear-app-cache`

#### Responses

| Status Code | Description | Schema |
|-------------|-------------|--------|
| 200 | OK | - |

### `GET /admin/all-users`

#### Responses

| Status Code | Description | Schema |
|-------------|-------------|--------|
| 200 | OK | ```json
{
  "*/*": {
    "schema": {
      "type": "object"
    }
  }
}
``` |

## Schemas

### JournalEntry

```json
{
  "type": "object",
  "properties": {
    "id": {
      "$ref": "#/components/schemas/ObjectId"
    },
    "title": {
      "type": "string"
    },
    "content": {
      "type": "string"
    },
    "date": {
      "type": "string",
      "format": "date-time"
    },
    "sentiment": {
      "type": "string",
      "enum": [
        "HAPPY",
        "SAD",
        "ANGRY",
        "ANXIOUS"
      ]
    }
  }
}
```

### ObjectId

```json
{
  "type": "object",
  "properties": {
    "timestamp": {
      "type": "integer",
      "format": "int32"
    },
    "date": {
      "type": "string",
      "format": "date-time"
    }
  }
}
```

### User

```json
{
  "type": "object",
  "properties": {
    "id": {
      "$ref": "#/components/schemas/ObjectId"
    },
    "userName": {
      "type": "string"
    },
    "email": {
      "type": "string"
    },
    "sentimentAnalysis": {
      "type": "boolean"
    },
    "password": {
      "type": "string"
    },
    "journalEntries": {
      "type": "array",
      "items": {
        "$ref": "#/components/schemas/JournalEntry"
      }
    },
    "roles": {
      "type": "array",
      "items": {
        "type": "string"
      }
    }
  }
}
```

