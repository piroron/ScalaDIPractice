package shop.application

import shop.domain.model.{GuestRange, GuestSelectionSpecification, PriceRange, PriceSelectionSpecification, Selection, Shop}
import shop.domain.repository.UsesShopRepository

trait ShopSelectionService extends UsesShopRepository {
  def findByUserChoice(choice: Selection): Seq[Shop]
}

trait UsesShopSelectionService {
  val shopSelectionService: ShopSelectionService
}

trait ByPriceSelection extends UsesShopRepository {
  def findByPrice(price: PriceRange): Seq[Shop] = {
    shopRepository.findByChoice(PriceSelectionSpecification(price))
  }
}

trait ByGuestSelection extends UsesShopRepository {
  def findByGuest(guest: GuestRange): Seq[Shop] = {
    shopRepository.findByChoice(GuestSelectionSpecification(guest))
  }
}