package mail

import user.model.User
import user.repository.{UserRepository, UsesUserRepository}

trait MixinMailUserRepository extends UsesUserRepository {
  val userRepository: UserRepository = MailUserRepository
}

object MailUserRepository extends UserRepository {
  override def findById(id: Int): Option[User] = {
    Some(User("name@aaa.com", id))
  }
}
