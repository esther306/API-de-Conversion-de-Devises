# 🌍 Currency Conversion API

###  ⚙️ Prerequisites

- Java 21.0.6
- Maven
- WebClient
- An API testing tool (Postman, Thunder Client, etc.)


This API allows you to convert an amount from one currency to another using real-time exchange rates from an external provider.
The project also integrates Swagger/OpenAPI for interactive API documentation.

---

## 🚀 How to Use

### ✅ Successful Conversion

**Endpoint:**
```
POST http://localhost:8080/Conversion/EUR/USD/150
```

**Description:**
Convert 150 EUR to USD.

**Expected Response:**
```json
171.495
```

This response indicates that 150 EUR is equivalent to 171.495 USD based on the current exchange rate.

---

### ❌ Error Case – Invalid Currency Code

**Endpoint:**
```
POST http://localhost:8080/Conversion/EUR/xxx/150
```

**Description:**
Attempting to convert to an invalid currency (e.g., `xxx`).

**Expected Error Response:**
```json
{
  "timestamp": "2025-06-03T15:30:05.544+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "message": "404 Not Found from GET https://v6.exchangerate-api.com/v6/1d56f40c65d139346b616a38/pair/EUR/XXX/150.0",
  "path": "/Conversion/EUR/XXX/150"
}
```

---

## 🛠️ Notes

- This API uses [ExchangeRate-API](https://www.exchangerate-api.com/) to fetch live exchange rates.
- Only valid ISO 4217 currency codes are supported (e.g., `USD`, `EUR`, `JPY`).
- Ensure your external API key is active and supports the requested currency pair.

---

## 👤 Author

**Kengne Esther**
