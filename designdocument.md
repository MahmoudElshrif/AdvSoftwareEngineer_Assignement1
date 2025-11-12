# Class → Pattern mapping

MenuFactory -> Factory Method
allows to quickly build multiple menu types

DiscountFactory -> Simple Factory
centralizes selection of the appropriate discount strategy for a menu item

DiscountStrategy -> Strategy
allows switching between multiple discount algorithms without changing clients

PaymentStrategy -> Strategy
allows adding and switching payment methods without changing billing flow

OrderManager -> Notifier (Observer)
publishes order events so subscribers can react without tight coupling

BillingGenerator -> Facade / Coordinator
generates textual bills and coordinates pricing & payment concerns

PricingService -> Service
isolates pricing calculations so they are testable and maintainable

TaxService -> Service
isolates tax rules so tax logic can change independently
