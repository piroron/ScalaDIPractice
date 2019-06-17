package shop.domain.repository

import shop.domain.model.{Shop, ShopSelection}

/**
  * 店舗取得リポジトリです。
  */
trait ShopRepository {
  def findByChoice(choice: ShopSelection): Seq[Shop]
}

/**
  * 店舗取得処理を表します。
  */
trait UsesShopRepository {
  val shopRepository: ShopRepository
}