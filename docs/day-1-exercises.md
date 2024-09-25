# Day 1 Exercises

The repository has some code in it already, but it isn't working because the
project hasn't been set up properly! The focus of these exercises is to follow
the steps required to get this repo working.

## Exercise 1: Setting up the project

- [ ] Read the docs on
      [Creating a Maven project](https://tech-docs.corndel.com/java/creating-projects.html).

- [ ] Add the `picocli` dependency to the `pom.xml` file

- [ ] Run `./mvnw test -DTest="D1E1Tests"` to check it's right, then commit and
      push

## Exercise 2: Creating a CLI

- [ ] Read the docs on
      [creating a CLI](https://tech-docs.corndel.com/java/making-a-cli.html)

There is a file in `exercises/HelloWorld.java` where we will create a simple
CLI.

Use `picocli` just like in the video to create a CLI according to the following
specifications:

- [ ] Import `picocli.CommandLine` and `picocli.CommandLine.Command`

- [ ] Use the `@Command` decorator, making sure the `name` is `"hello"`

- [ ] Make sure the `Hello` class implements runnable and `@Override`s the
      `run()` method

- [ ] The `run()` should simply print `"Hello, World!"` (this is
      case-sensitive!)

- [ ] In the `main()` method, create and execute the CLI and call `System.exit`
      with the exit code

> [!TIP]
>
> If you want to debug your CLI, you should be able to run it directly with the
> command
>
> ```bash
> ./mvnw -q exec:java -Dexec.mainClass="com.corndel.supportbank.exercises.HelloWorld"
> ```

- [ ] Run `./mvnw test -DTest="D1E2ests"` to check it's right, then commit and
      push

## Exercise 3: Adding params

- [ ] Add a `@Parameter` to the `HelloWorld` class

- [ ] Make sure the `index` is `0`

- [ ] Set `defaultValue = "World"` in the parameter to ensure that Exercise 2
      doesn't break!

> [!TIP]
>
> You can debug your CLI with arguments by running a command like
>
> ```bash
> ./mvnw -q exec:java -Dexec.mainClass="com.corndel.supportbank.exercises.HelloWorld" -Dexec.args="Alice"
> ```

## Exercise 4: Attaching a subcommand

In `exercises/ColorCommand` you will find a subcommand. All we need to do is
attach it to the `HelloWorld` app!

- [ ] Read the notes on
      [adding subcommands](https://tech-docs.corndel.com/java/adding-subcommands.html)

- [ ] Uncomment the code in `exercises/ColorCommand` (use `Ctrl + A` to
      highlight the whole text, then `Ctrl + /` to uncomment)

- [ ] Add the `ColorCommand` subcommand to the `HelloWorld` app by including it
      in the `subcommands` argument.

> [!NOTE]
>
> this is a simple subcommand, not a nested subcommand, so your code will look
> more like
> [this section](https://tech-docs.corndel.com/java/adding-subcommands.html)
> (i.e. you don't need to make a controller class).

> [!TIP]
>
> You can debug the color subcommand by running
>
> ```bash
> ./mvnw -q exec:java -Dexec.mainClass="com.corndel.supportbank.exercises.HelloWorld" -Dexec.args="color"
> ```
