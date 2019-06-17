package shop.domain.model

case class Shop(price: Int, guest: Int, style: PartyStyle) {

}

object Shop {
  def apply(price: Int, guest:Int, style: PartyStyle) =
    new Shop(price, guest, style)
}
