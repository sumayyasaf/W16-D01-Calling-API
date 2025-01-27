# Lab: Calling External APIs - RestCountries and Star Wars API

## Objective:
The objective of this lab is to interact with two external APIs:
1. **RestCountries API**: To retrieve details about a country based on user input.
2. **Star Wars API**: To retrieve information about a specific Star Wars character (ID 4).

### Required Libraries:
1. **HttpClient**: For making HTTP requests.
2. **Gson**: For parsing JSON responses.

Add Gson dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.11.0</version>
</dependency>
```

### API Documentation:
1. **RestCountries API**: [https://restcountries.com/](https://restcountries.com/)
2. **Star Wars API**: [https://swapi.dev/](https://swapi.dev/)

---

## Step 1: Make a call to the RestCountries API

**Goal**: Get information for a country based on the user's input. The response should be displayed with the following format:

```
{name} country is a great country with a great population of {population} and is in {continent} continent. With the following capitals: {capital}
```

### API Endpoint for RestCountries API:
- URL: `https://restcountries.com/v3.1/name/{country}` (replace `{country}` with the name of the country)

**Example API call**: `https://restcountries.com/v3.1/name/USA`

---

## Step 2: Handle cases where no country is found

If the country is not found, proceed with calling the **Star Wars API** to fetch and display the name of the character with ID 4.

### API Endpoint for Star Wars API:
- URL: `https://swapi.dev/api/people/4/`

---

## Deliverables:
1. **Functionality**: 
   - Make an API call to RestCountries based on user input.
   - Display the country details if found or make a call to the Star Wars API if the country is not found.
   - Display the correct information for the country or Star Wars character.
   
2. **Optional Challenge**:
   - Add more error handling in case the API returns an error (e.g., invalid input, no response, etc.).
   - Explore additional data from the APIs (e.g., return more details for the country, or make additional calls to the Star Wars API).
