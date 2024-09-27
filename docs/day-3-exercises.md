# Day 3 Exercises

## Exercise 1: Environment variables

- [ ] Have a look at the documentation on
      [environment variables](https://tech-docs.corndel.com/java/environment-variables.html)

- [ ] Add the `java-dotenv`
      [dependency](https://tech-docs.corndel.com/java/environment-variables.html#reading-environment-variables)
      to `pom.xml`

- [ ] Add the following environment variable:

      ```
      SECRET_KEY=opensesame
      ```

- [ ] Test, commit and push!

## Exercise 2: GET Requests

In this exercise, we'll be fetching data from the
[PokeAPI](https://pokeapi.co/docs/v2).

- [ ] Have a look at the documentation on
      [fetching data](https://tech-docs.corndel.com/java/fetching-data.html).

- [ ] Open `exercises/pokeAPI.java`.

- [ ] Complete the static method `getPokemonByName(name)`. It should

  - make a `GET` request to `"https://pokeapi.co/api/v2/pokemon/" + name`

  - map the response body into `Pokemon.class` (this class is provided for you
    in the `pokeAPI.java` file)

  - return the `Pokemon` object

## Extension

See if you can get a list of pokemon back from the API, and map it into a java
`List` of `Pokemon` objects.

There is a note on parsing lists of JSON [here](pokeAPI.java).
