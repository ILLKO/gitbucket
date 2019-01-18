package gitbucket.core.view

import gitbucket.core.controller.Context
import gitbucket.core.service.RepositoryService.RepositoryInfo
import org.scalatest.FunSpec
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._

class DiffSpec extends FunSpec with MockitoSugar {

  private implicit val context = mock[Context]
  private val repository = mock[RepositoryInfo]

  when(repository.name).thenReturn("name")
  when(repository.owner).thenReturn("owner")
  when(context.path).thenReturn("path")

  import gitbucket.core.helper.html.diff

  describe("diff") {

    it("show diff") {
      val diffs = Nil

      val render = diff(diffs, repository, None, None, false, None, false, false)
      println(render.toString())
      assert(true)
    }
  }
}
