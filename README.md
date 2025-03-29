# p4

Below is the list of available API endpoints:

| Method | Route                       | Body                                              | Description                             | Possible Responses            |
|--------|-----------------------------|---------------------------------------------------|-----------------------------------------|-------------------------------|
| `GET`  | `/api/cats/{name}`           | None                                              | Retrieves a cat by name              | 200 OK (if found), 404 Not Found |
| `POST` | `/api/cats`                  | `{ "name": "string", "age": "int" }`              | Adds a new cat with the provided name and age | 201 Created, 400 Bad Request (if missing fields) |
| `PUT`  | `/api/cats/{name}/age/{age}` | None                                              | Updates the age of an existing cat      | 200 OK (if updated), 404 Not Found |
| `DELETE`| `/api/cats/{name}`          | None                                              | Deletes a cat by name                | 200 OK (if deleted), 404 Not Found |

---

### Example

**1. POST request to add a new cat:**

```json
{
  "name": "Gatito",
  "age": 3
}
