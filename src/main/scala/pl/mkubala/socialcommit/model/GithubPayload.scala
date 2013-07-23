package pl.mkubala.socialcommit.model

case class GithubPayload(
  after: String,
  before: String,
  commits: Option[Seq[GithubCommit]],
  compare: String,
  created: Boolean,
  deleted: Boolean,
  forced: Boolean,
  head_commit: Option[GithubCommit],
  pusher: GithubUser,
  ref: String,
  repository: GithubRepo)

case class GithubCommit(
  added: Option[Seq[String]],
  author: GithubUser,
  committer: GithubUser,
  distinct: Boolean,
  id: String,
  message: String,
  modified: Option[Seq[String]],
  removed: Option[Seq[String]],
  timestamp: String,
  url: String)

case class GithubUser(
  email: Option[String],
  name: String,
  username: Option[String])

case class GithubRepo(
  created_at: Long,
  description: String,
  fork: Boolean,
  forks: Long,
  has_downloads: Boolean,
  has_issues: Boolean,
  has_wiki: Boolean,
  homepage: String,
  id: Long,
  language: String,
  master_branch: String,
  name: String,
  open_issues: Long,
  owner: GithubUser,
  isPrivate: Boolean,
  pushed_at: Long,
  size: Long,
  stargazers: Long,
  url: String,
  watchers: Long)