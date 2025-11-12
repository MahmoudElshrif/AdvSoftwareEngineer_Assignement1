# Restaurant Order System

Quick instructions to compile and run the project, plus example interactive test cases and discount scenarios.

## Compile

Open PowerShell in the repository root (where `src` is located) and run:

```powershell
# create bin directory (if missing)
New-Item -ItemType Directory -Force -Path bin

# collect all .java files and compile to bin
$files = Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object { $_.FullName }
javac -d bin $files
```

This compiles sources into `bin/` preserving packages.

## Run

After successful compile run the Main class (note its package is `src`):

```powershell
java -cp bin src.Main
```

Follow the interactive prompts in the console.

## Example interactive test case: Pizza (discount scenario)

This shows how to add a pizza item (which has a pizza discount in the code) and complete payment.

Example inputs (enter these values when prompted):

1. When program asks:
   Enter your username: TestUser
   Enter your phone number: 12345

2. Main menu: enter `1` (Browse Menu & Order)
   Menu selection: enter `3` (Non-Vegetarian Menu)
   When the menu items are printed, enter the item number for `Pizza` (in current code it's item 4).

3. Back in main menu, enter `3` (Proceed to Payment)
   Select order type (1/2/3) as desired.
   Payment method: enter `1` (Cash) or `2` or `3`.

Expected bill snippet (approx):

```
-Pizza $10.0 x1
  30% pizza discount applied $7.0
-- $7.0

----------

Total: $7.0
Tax: $0.7
Final Total: $7.7
```

Notes: The program shows the discounted price (7.0) under the discount details and then totals include tax.

## Example: Meat discount

Add the `Burger` (meat category) from the Non-Vegetarian menu.

Expected behaviour: a 5% meat discount is applied.

Approx bill lines:

```
-Burger $5.0 x1
  5% meat discount applied $4.75
-- $4.75

Total: $4.75
Tax: $0.475
Final Total: $5.225
```

## Quick manual tests (inputs for multiple items)

- Add a Pizza (NonVeg menu) and a Burger (NonVeg) — verify totals reflect both pizza (30%) and meat (5%) discounts.
- Add an addon (choose main menu option `2` after adding items) to an OrderItem and re-run billing to see addon pricing applied.
