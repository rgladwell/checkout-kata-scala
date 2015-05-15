package me.gladwell.kata.checkout

trait Catalogue {

  type ProductCatalogue = Set[Product]
  val catalogue: ProductCatalogue

}