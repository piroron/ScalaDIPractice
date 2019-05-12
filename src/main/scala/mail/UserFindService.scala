package mail

import user.model.User
import user.repository.UsesUserRepository

trait UserFindService extends UsesUserRepository {
  /**
    * ユーザーを見つけます。
    * @return
    */
  def findByUser(): User = {
    userRepository.findById(1) match {
      case Some(u) => u
      case None => User("none", 0)
    }
  }
}

object UserFindService extends UserFindService with MixinMailUserRepository
