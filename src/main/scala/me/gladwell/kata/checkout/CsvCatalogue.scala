package me.gladwell.kata.checkout

import scala.io.Source

trait CsvCatalogue extends Catalogue {
  this: Configuration =>

  override lazy val catalogue: ProductCatalogue = {
    val csv = Source.fromURL(productDataCsv)
    val data = csv.getLines().drop(1).map(_.split(","))
    data.map(rowToProduct).toSet
  }

  def rowToProduct(row: Array[String]) =
    Product(row(0).trim.toInt, row(1).trim, row(2).trim.drop(1).toDouble)

}
