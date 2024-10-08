# Contributing

## Technologies used

| Name                                              | Purpose                                |
| ------------------------------------------------- | -------------------------------------- |
| `junit`                                           | Test the project                       |
| [`picocli`](https://picocli.info/)                | Create the command-line interface      |
| `java-dotenv`                                     | Securely store configuration variables |
| [`unirest`](https://kong.github.io/unirest-java/) | Retrieve data from a server            |

## Models

In the `models` folder you'll find a file called `.gitkeep`. GitHub doesn't
allows you to upload empty folders, so putting a `.gitkeep` file in a folder is
a way of making sure the folder gets uploaded to GitHub.

The `models` folder is the perfect place to put classes which encapsulate data
and logic, but it's up to you to decide which models to add in oder to get the
functionality of SupportBank working.

You might have a `Currency` class, an `Investment` class, and so on.

## Controllers

The `controllers` folder is where we write code that allows users to interact
with SupportBank by typing intuitive commands in the terminal.

In general, the code in this folder should focus on communicating between the
user and the models, and it should avoid performing business logic (e.g.
calculating tax) which really belongs in the model layer.

## Tests

Only exercises currently have tests - if you have any spare time in the
workshops, feel free to add more!

If you enjoy TDD, you could certainly use this methodology during the workshops.

## General advice

This is quite an open-ended project and there are many different ways to solve
it. Try not to think about your code in terms of "right or wrong" but imagine
this will be used by real people and you are trying to give them useful features
with a good user experience. If there is something else you want to add or do in
a different way, go ahead!
