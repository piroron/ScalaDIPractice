import shop.domain.model.{PriceRange, PriceSelectionSpecification, Selection}
import shop.impl.MixinShopSelectionService

object Main extends MixinShopSelectionService{
  def main(args: Array[String]): Unit = {

    val selection = PriceSelectionSpecification(PriceRange(1000, 2000))

    val res = shopSelectionService.findByUserChoice(selection.choice)

    println(res)
  }

//  private def getUser: User = {
//    UserFindService.findByUser()
//  }
}
