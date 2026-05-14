# VendingMachine

A console-based Java vending machine simulator built with small, composable components for inventory, payments, dispensing, revenue tracking, and command handling.

## Overview

This project starts an interactive terminal app where you can:

- browse products by slot
- insert money
- buy items by slot code
- return remaining balance as change
- restock inventory
- track total revenue

The codebase is organized with interfaces and concrete implementations, which makes the core machine behavior easy to follow and extend.

## Features

- Interactive command-line workflow
- Preloaded beverage, snack, and food inventory
- Slot-based product selection
- Balance and change handling
- Out-of-stock, invalid-slot, and insufficient-funds validation
- Revenue tracking for successful sales
- Clear separation of concerns across machine, inventory, payment, display, and command layers

## Project Structure

```text
src/
|-- Main.java
`-- com/vendingmachine/
    |-- command/     Command registration and user actions
    |-- display/     Console output
    |-- dispenser/   Product dispensing rules
    |-- inventory/   Slots and inventory management
    |-- loader/      Default product seeding
    |-- machine/     Vending machine controller logic
    |-- model/       Money and dispensing result models
    |-- payment/     Cash balance handling
    |-- product/     Product types
    `-- revenue/     Revenue tracking
```

## Requirements

- Java JDK 8 or newer

## Compile and Run

From the project root:

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
java -cp out Main
```

## Available Commands

| Command | Description | Example |
| --- | --- | --- |
| `list` | Show all products | `list` |
| `insert <amount>` | Insert money into the machine | `insert 1.50` |
| `select <slot>` | Buy a product from a slot | `select A1` |
| `return` | Return the current balance | `return` |
| `status` | Show current balance and total revenue | `status` |
| `restock <slot> <amount>` | Add stock to a slot | `restock A1 5` |
| `help` | Show command help | `help` |
| `exit` | Exit the application | `exit` |

`quit` is also accepted as an alias for `exit`.

## Default Inventory

The machine is seeded with products such as:

- Beverages: Cola, Diet Cola, Orange Juice, Water
- Snacks: Chips, Pretzels, Granola Bar, Chocolate, Gummy Bears
- Food: Sandwich, Salad, Yogurt

## Example Session

```text
=== Vending Machine ===
Commands:
  list     - Show all products
  insert   - Insert money
  select   - Buy a product
  return   - Return inserted money
  status   - Show balance and revenue
  restock  - Restock a slot
  help     - Show this help
  exit     - Exit the program

> list
> insert 2.00
> select A1
> status
> return
> exit
```

## Design Notes

- `Main` wires together the inventory, payment processor, dispenser, revenue tracker, display, and commands.
- `AbstractVendingMachine` centralizes the main vending flow and records revenue after successful purchases.
- `StandardDispenser` enforces slot validity, stock checks, payment checks, and change return.
- `Money` stores values in cents to keep currency handling predictable.

## Ideas for Extension

- Card payments or multiple payment strategies
- Persistent inventory and sales history
- Admin-only commands
- Product loading from JSON or CSV
- Automated unit tests for machine and command behavior
