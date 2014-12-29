## SPR-8016 repro project

Trying to reproduce problems described [in this comment](https://jira.spring.io/browse/SPR-8016?focusedCommentId=110954&page=com.atlassian.jira.plugin.system.issuetabpanels:comment-tabpanel#comment-110954).

## Running the project

Launch the server:

    mvn clean package cargo:run -Ptomcat8 -DskipTests=true

Locally run the test in `RestTemplateTests`.

