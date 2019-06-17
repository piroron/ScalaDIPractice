package shop.domain.model

sealed abstract class PartyStyle(style: Int, name: String)

/**
  * テーブル形式
  */
case object Table extends PartyStyle(1, "テーブル")

/**
  * ビュッフェ形式
  */
case object Buffet extends PartyStyle(2, "ビュッフェ")
