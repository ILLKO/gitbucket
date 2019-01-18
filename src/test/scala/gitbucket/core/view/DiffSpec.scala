package gitbucket.core.view

import gitbucket.core.controller.Context
import gitbucket.core.service.RepositoryService.RepositoryInfo
import gitbucket.core.util.JGitUtil.DiffInfo
import org.eclipse.jgit.diff.DiffEntry
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

    it("no diff") {
      val diffs = Nil

      val render = diff(diffs, repository, None, None, false, None, false, false)
      println(render.toString())
      assert(true)
    }

    it("one diff") {

      val diff1 = new DiffInfo(DiffEntry.ChangeType.MODIFY,
        "path", "path", Some("old content"), Some("new content"),
        false, false, Some("oldObjectId"), Some("newObjectId"),
        "mode", "mode", false, None)

      val diffs = diff1 :: Nil

      val render = diff(diffs, repository, Some("newCommitId"), Some("oldCommitId"), false, None, false, false)
      println(render.toString())
      assert(true)
    }

  }
}
