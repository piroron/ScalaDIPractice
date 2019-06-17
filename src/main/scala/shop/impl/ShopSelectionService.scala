package shop.impl

import shop.application.{ShopSelectionService, UsesShopSelectionService}
import shop.domain.model.{Selection, Shop, ShopSelectionSpecification}
import shop.domain.repository.{UsesShopRepository}
import shop.infrastructure.MixinShopRepository

trait ShopSelectionServiceImpl extends ShopSelectionService
  with UsesShopRepository {
  override def findByUserChoice(choice: Selection): Seq[Shop] = {
    shopRepository.findByChoice(ShopSelectionSpecification(choice))
  }
}

trait MixinShopSelectionService extends UsesShopSelectionService {
  override val shopSelectionService: ShopSelectionService =
    new ShopSelectionService
      with ShopSelectionServiceImpl
      with MixinShopRepository
}
