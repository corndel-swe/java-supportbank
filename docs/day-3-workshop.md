# Day 3 Workshop

During the first workshop, we wrote a currency converter. However, we hard-coded
the exchange rates. This time, we want to fetch the exchange rates from an API.

We'll be using [openexchangerates.org](https://openexchangerates.org/). You'll
need to sign up for a free account to get an API key.

## Part 1: Getting an App ID and adding it to the environment variables

Set up a _free_ account on Open Exchange Rates. You can do that
[here](https://openexchangerates.org/signup/free).

You should then be able to find your App ID in the dashboard. Add it to your
`.env` file. For example,

```
OPEN_EXCHANGE_RATES_APP_ID=your_app_id_here
```

Make sure that your `.env` file is added to the `.gitignore` file so that it
doesn't get committed! It's important for security to keep your API key secret.

## Part 2: Fetching the exchange rates

Use the Open Exchange Rates API to get the latest exchange rates.

You can read an introduction to their api
[here](https://docs.openexchangerates.org/reference/api-introduction).

You can read how to include your APP_ID
[here](https://docs.openexchangerates.org/reference/authentication).

You can read about the `/latest.json` endpoint
[here](https://docs.openexchangerates.org/reference/latest-json).

Add a command to your CLI to list the latest exchange rates from the API.

## Part 3: Using the exchange rates

During workshop 1, we wrote a currency converter. We hard-coded the exchange
rates.

Modify the currency converter to use live exchange rates, fetched from the API.

## Extension

In `Transactions2011.csv`, you can see that the `Currency` column specifies the
currency of the `Amount` transferred.

Modify your CLI so that the `transactions summarise` command displays each
person's balance according to the `2011` transactions.

The balances should be displayed in `GBP` by default, but you could add an
`@Option` called `--currency` which allows the user to select how the balances
are displayed.
