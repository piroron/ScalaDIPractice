import mail.UserFindService
import user.model.User

object Main {
  def main(args: Array[String]): Unit = {
    println(getUser)
  }

  private def getUser: User = {
    UserFindService.findByUser()
  }
}
