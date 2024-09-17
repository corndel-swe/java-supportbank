# Day 1 Exercises

The repository has some code in it already, but it isn't working because the
project hasn't been set up properly! The focus of these exercises is to follow
the steps required to get this repo working.

## Exercise 1: Setting up the project

(Please note that no tests will pass for Exercise 1 until all steps are
completed, because the testing tools haven't been installed yet!)

- [ ] Read the docs on
      [Creating a Maven project](https://tech-docs.corndel.com/java/creating-projects.html).

- [ ]

- [ ] Add Picocli

## Exercise 2: Public classes and importing packages

You'll have seen and used some `import` statements in the code
you've been working with. This exercise is about setting that up for the
project.

- [ ] Read the docs on
      [import and export](https://tech-docs.corndel.com/js/imports-and-exports.html).

- [ ] There is a file in `exercises/hello.java`. Make sure qq class is public

- [ ] make sure qq property is public

- [ ] Check that the tests are passing. Commit and push!

## Exercise 3: Using Picocli

Let's set up a CLI so that we can run the program from the command line.

- [ ] Read the page on
      [Making a CLI](https://tech-docs.corndel.com/js/making-a-cli.html).

- [ ] make a new commandLine in main class

- [ ] import and register the transaction command as a "subcommand"
      In `cli/transaction.js` there is a `transactionController`. It hasn't been
      registered yet.
      [Import and register](https://tech-docs.corndel.com/java/making-a-cli.html#qq)
      it with the CLI in `cli/index.js`.

- [ ] Right now, the `transaction log` command doesn't do anything. We want to
      make it so that it logs the transactions to the console. Make it log a
      transaction nicely, so that the command

      ```bash
      ./mvnw  cli transaction log "Jon A" "Joe G" 100
      ```

      prints out something useful, such as

      ```
      At 01/03/2024 11:27am, Jon A sent Joe G £100
      ```

- [ ] All tests should now be passing. Commit and push!

Congratulations! Your project is set up with qq 🎉!
