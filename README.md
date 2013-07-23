# Social Commit #
Simple, scalatra & json4s based, GitHub post-service WebHook example.

## Build & Run ##

```sh
$ cd social-commit
$ ./sbt
> container:start
> browse
```

If `browse` doesn't launch your browser, manually open [http://localhost:8080/](http://localhost:8080/) in your browser.

## Usage ##
Send Http POST request to '/commit'.
The request should contains JSON-encoded payload.
See [https://help.github.com/articles/post-receive-hooks#the-payload](https://help.github.com/articles/post-receive-hooks#the-payload) for payload schema and examples.

As a response you will get html containing received payload object (string-encoded).
