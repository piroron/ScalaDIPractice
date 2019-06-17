package shop.infrastructure

import shop.domain.model.{Shop, ShopSelection, Table}
import shop.domain.repository.{ShopRepository, UsesShopRepository}

private object ShopRepositoryImpl extends ShopRepository {
  override def findByChoice(choice: ShopSelection): Seq[Shop] = {
    val sel = choice.choice

    Seq(
      sel.guest.map(_ => Shop(12000, 60, Table)),
      sel.price.map(_ => Shop(10000, 100, Table)),
      sel.style.map(_ => Shop(14000, 70 , Table))
    ).flatten
  }
}

trait MixinShopRepository extends UsesShopRepository {
  override val shopRepository: ShopRepository = ShopRepositoryImpl
}

case class ArgShopRepository(shopRepository: ShopRepository) extends UsesShopRepository
