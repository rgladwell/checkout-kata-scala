package me.gladwell.kata.checkout

trait ShoppingBasket {
  this: Catalogue =>

  val basket = new SeqShoppingBasket(Seq(), catalogue)

  class SeqShoppingBasket(val items: Seq[Product], catalogue: ProductCatalogue) {

    def scan(id: Int) = new SeqShoppingBasket(items ++ findInCatalogue(id), catalogue)
    def unscan(id: Int) = new SeqShoppingBasket(items diff Seq(findInCatalogue(id).get), catalogue)

    private def findInCatalogue(id: Int) = catalogue.find { product => product.id == id }
  }

}
