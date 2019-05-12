package user.repository

import user.model.User

/**
  * ユーザー取得リポジトリ
  */
trait UserRepository {
  def findById(id: Int): Option[User]
}

/**
  * interface
  */
trait UsesUserRepository {
  /**
    * ユーザー取得リポジトリ
    */
  val userRepository: UserRepository
}

