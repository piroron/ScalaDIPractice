import mail.UserFindService
import org.scalatest.FlatSpec
import user.model.User
import user.repository.{UserRepository, UsesUserRepository}

class UserFindServiceTest extends FlatSpec {

  /* prepare */
  trait FakeUserRepository extends UsesUserRepository {
    val userRepository: UserRepository = FakeRepository("test")
  }

  case class FakeRepository(name: String) extends UserRepository {
    override def findById(id: Int): Option[User] = { Some(User(name, id))}
  }

  trait EmptyUserRepository extends UsesUserRepository {
    val userRepository: UserRepository = EmptyRepository
  }

  object EmptyRepository extends UserRepository {
    override def findById(id: Int): Option[User] = None
  }

  object EmptyUserService extends UserFindService with EmptyUserRepository
  object FakeUserFindService extends UserFindService with FakeUserRepository

  /* end prepare */

  behavior of "UserFindServiceTest"

  it should "findByUser" in {
    val u: UserFindService = FakeUserFindService
    assert(u.findByUser().name === "test")
  }

  it should "empty user" in {
    val u: UserFindService = EmptyUserService
    assert(u.findByUser().name === "none")
  }
}


