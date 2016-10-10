package service

import javax.inject.Inject
import com.google.inject.Singleton
import dao.UserDao
import models.User
import scala.concurrent.Future

@Singleton
class UserServiceImpl @Inject()(userDAO: UserDao) extends UserService {
  override def addUser(user: User): Future[String] = {
    userDAO.add(user)
  }

  override def deleteUser(id: Long): Future[Int] = {
    userDAO.delete(id)
  }

  override def getUser(id: Long): Future[Option[models.User]] = {
    userDAO.get(id)
  }

  override def listAllUsers: Future[Seq[models.User]] = {
    userDAO.listAll
  }
}