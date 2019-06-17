package shop.domain.model

case class PriceRange(low: Int, high: Int) {
  if (low > high) {
    throw new IllegalArgumentException("high must greater than low.")
  }
}
