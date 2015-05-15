package me.gladwell.kata.checkout

import org.specs2.mutable.Specification
import org.specs2.specification.Scope
import java.io.File

object CsvCatalogueSpec extends Specification {

  "The product catalogue" >> {

    trait TestConfiguration extends Configuration {
      override val productDataCsv = getClass.getResource("/product-data.csv")
    }

    trait TestCatalogue extends CsvCatalogue with TestConfiguration with Scope

    "should parse the product data CSV correctly" in new TestCatalogue {
      catalogue must_== Set (
        Product(1, "Short Sleeve Jumper", 9.99),
        Product(2, "Shoulder Bag", 9.99),
        Product(3, "Skinny Jeans", 45),
        Product(4, "Leather Jeans", 80),
        Product(5, "Leather Jacket", 199.99),
        Product(6, "Wool Socks", 20.50),
        Product(7, "Piqué Polo shirt", 50.55)
      )
    }
  }

}
