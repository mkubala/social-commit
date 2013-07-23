package pl.mkubala.socialcommit

import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._
import org.json4s.JsonAST._
import pl.mkubala.socialcommit.model.GithubPayload

class SocialCommitServlet extends SocialCommitStack with JacksonJsonSupport {

  protected implicit val jsonFormats: Formats = DefaultFormats

  before() {
    //contentType = formats("json")
  }

  // Because 'private' is reserved keyword in Scala
  // we need to rename each fields named 'private' since we parse request payload to case class.
  // This method will be applied to each requests JSON body in this scalatra servlet.
  protected override def transformRequestBody(body: JValue): JValue = body.transformField {
    case JField("private", value) => JField("isPrivate", value)
    case otherJField => otherJField
  }

  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say
        <a href="hello-scalate">hello to Scalate</a>
        .
      </body>
    </html>
  }

  get("/commit") {
    <html>
      <body>
        <h1>Push POST request here</h1>
        Request should contains a valid Github WebHook payload.
        <br/>
        Looking for example payload?
        <a href="https://gist.github.com/gjtorikian/5171861#file-sample_payload-json">See here</a>
        .
      </body>
    </html>
  }

  post("/commit") {
    val payload = parsedBody.extract[GithubPayload]
    <html>
      <body>
        <h1>Data received</h1>
        <pre>
          {payload}
        </pre>
      </body>
    </html>
  }

}
