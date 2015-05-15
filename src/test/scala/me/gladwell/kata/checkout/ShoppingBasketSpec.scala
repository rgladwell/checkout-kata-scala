package me.gladwell.kata.checkout

import org.specs2.mutable.Specification
import org.specs2.specification.Scope

object ShoppingBasketSpec extends Specification {

  "The shopping basket" >> {

    trait TestConfiguration extends Configuration {
      override val productDataCsv = getClass.getResource("/product-data.csv")
    }

    trait TestCatalogue extends CsvCatalogue with TestConfiguration with Scope

    trait TestShoppingBasket extends TestCatalogue with ShoppingBasket

    "should add an item" in new TestShoppingBasket {
      basket.scan(5).items must_== Seq(Product(5, "Leather Jacket", 199.99))
    }

  }

}
