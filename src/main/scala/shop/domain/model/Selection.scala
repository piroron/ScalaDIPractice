package shop.domain.model

/**
  * 店舗選択仕様です。
  */
trait ShopSelection {
  /**
    * 選択条件
    */
  val choice: Selection
}

//trait ShopSelectionSpecification {
//  def isSatisfiedBy(shop: Shop): Boolean
//}

case class ShopSelectionSpecification(userChoice: Selection) extends ShopSelection {
  val choice = userChoice
}

case class PriceSelectionSpecification(userPrice: PriceRange) extends ShopSelection {
  val choice = Selection(price = Some(userPrice))
}

case class GuestSelectionSpecification(userGuest: GuestRange) extends ShopSelection {
  val choice = Selection(guest = Some(userGuest))
}



/**
  * 店舗を選択する条件を示します。
  * @param price 価格範囲
  * @param guest ゲスト人数範囲
  * @param style 店舗のスタイル
  */
case class Selection(price: Option[PriceRange] = None, guest: Option[GuestRange] = None, style: Option[PartyStyle] = None) {

}
