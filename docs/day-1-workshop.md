# Day 1 Workshop

Now that you've got a working project, it's time to start adding some
functionality to it.

> [!NOTE]
>
> Be sure to read `CONTRIBUTING.md` before getting started on the workshops.

> [!TIP]
>
> The tasks suggested here don't all need to be completed. They are just
> recommendations of features you could add to practise what you have been
> learning. Experiment, explore, and have fun!

## Bill splitter

Let's make a command which splits the bill when people want to share the cost.
To split a £60 bill between three people, it should take an input like this:

```bash
supportbank bill split 60 3
```

and print a message in the console to say each person owes £20.

> [!NOTE]
>
> When you are debugging the project in development, you can use a command like
>
> ```bash
> ./mvnw exec:java -Dexec.args="bill split 60 3"
> ```
>
> to manually check the CLI.

> [!TIP]
>
> Consider making a `Bill` class with a `total` property and a
> `split(numPeople)` property.

## Currency converter

Let's write a currency converter. It should take an input like the following:

```bash
supportbank currency convert 100 USD GBP
```

and return the equivalent amount in the second currency. Try adding a few
different currencies and allow the users to convert between them.

Feel free to hard-code the
[exchange rates](https://www.google.com/search?q=1+usd+to+gbp) for now. We'll
improve this in a later workshop.

> [!TIP]
>
> See the hints at the bottom of this file.

## Investment calculator

Our users might want an investment calculator.

Let's say they invest £1500 at a rate of 4% over 12 years with
[simple interest](https://www.bbc.co.uk/bitesize/guides/zv9p34j/revision/2).

```bash
supportbank invest simple 1500 4 12
```

The above command should calculate the projected value of the investment.

Add a similar command for an investment with
[compound interest](https://www.bbc.co.uk/bitesize/articles/z2jfp4j#zhv94xs).

## Tax calculator

Calculating tax by hand is inconvenient, so let's help our users with a tax
calculator.

Here are the UK [rules for income tax](https://www.gov.uk/income-tax-rates):

| Band               |   Taxable income    | Tax rate |
| :----------------- | :-----------------: | :------: |
| Personal Allowance |    Up to £12,570    |    0%    |
| Basic rate         | £12,571 to £50,270  |   20%    |
| Higher rate        | £50,271 to £125,140 |   40%    |
| Additional rate    |    over £125,140    |   45%    |

If a customer has a salary of £28,000, they should be able to run

```bash
supportbank salary tax 28000
```

and see their new salary after tax.

## Extensions

### Tests

Consider adding some tests to `tests/models` to ensure your models behave as
they should.

### Optional parameters

We can add options to our CLI commands using the `@Option` decorator.

For example,

```java
class Bill {

  @Option(names = {"-t", "--tip"}, description = "The optional tip percentage.")
  private double tip = 0.0; // default value if not provided

}
```

means that `tip` is optional and would be used like this:

```bash
supportbank bill split 100 4 --tip 15
# Each person owes: £28.75
```

- Could you add an optional tip to add to the bill before spltting?

- Could your investment calculator have an option to show the value of the
  investment each year during its whole term?

- Could your tax calculator optionally incorporate student loans?

## Hints

### Map

In Java, we can make a simple key value store like this:

```java
var map = Map.of("a", 1, "b", 2);

map.get("a"); // 1
map.get("b"); // 2
```

This could be useful for storing rates or symbols, for example:

```java
var symbols = Map.of(
  "GBP", "£",
  "EUR", "€",
  "USD", "$",
  "JPY", "¥",
  "AUD", "A$");

var str = symbols.get("EUR") + 2.75 // €2.75
```
