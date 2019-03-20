## Welcome!

This repository is designed to allow Spring users and team members to contribute self-contained projects
reproducing issues logged against Spring's JIRA issue tracker at https://jira.spring.io.  It offers
the following advantages over attaching .zip or even patch files to JIRA issues:

* A streamlined process for evaluating issues so more bugs get fixed more quickly!
* A set of template projects to choose from
* Two-way communication with the Spring team based on working code
* Improved code sharing across the Spring team
* A back-reference and a valuable archive of small Spring projects across a wide range of
  use cases and features

All around a better way of interacting with the Spring team.

## Logging an issue against Spring's JIRA issue tracker

1. First, [search SPR JIRA](https://jira.spring.io/browse/SPR) to see if your issue has already
   been reported. If so, there may already be a reproduction issue in this repository!
1. If after searching an issue does not already exist,
   [create a new issue](https://jira.spring.io/secure/CreateIssue!default.jspa)
    * You will now have an issue named, for example, "SPR-9876".  Make note of this, as you'll need it
      below when creating your project.

## Using this repository to demonstrate the issue

Assuming you've encountered and created an issue in the core Spring Framework project you can now add a
project to demonstrate it.

### First-time setup

1. [Create a Github account](https://github.com/signup/free) if you don't already have one
1. [Fork this repository and clone it locally](https://help.github.com/fork-a-repo/)

### Create a project that reproduces your issue

The idea is to create the smallest possible project to demonstrate the issue. The project may be built
with Maven and must contain only sources, XML and other necessary text files. No JARs, please!

For the purpose of these instructions, we'll assume your new JIRA issue ID is "SPR-9876"

#### Steps

1\. In your local clone of this repository, create a copy of the appropriate 'template' directory. Their
names start with `SPR-0000`.

For [Core Spring Framework](https://github.com/spring-projects/spring-framework-issues/tree/master/SPR-0000#readme) issues:

```bash
cd spring-framework-issues
./create-repro-project.sh SPR-0000/ SPR-9876
```

For [Spring MVC issues using XML configuration](https://github.com/spring-projects/spring-framework-issues/tree/master/SPR-0000-war-xml#readme):

```bash
cd spring-framework-issues
./create-repro-project.sh SPR-0000-war-xml/ SPR-9876
```

For [Spring MVC issues using Java config](https://github.com/spring-projects/spring-framework-issues/tree/master/SPR-0000-war-java#readme):

```bash
cd spring-framework-issues
./create-repro-project.sh SPR-0000-war-java/ SPR-9876
```

2\. Review the list of dependencies and version numbers and modify the pom.xml as necessary.

3\. Import the project into your IDE and modify it as necessary to reproduce your issue.

* It is already a buildable Maven project, so you may use your IDE's built-in support for Maven to do
  the importing.
* If this is a web project, you can run it on the command line with an embedded container:
  `mvn clean package cargo:run -Ptomcat8`

4\. Add, commit, and push your local fork

```bash
git add SPR-9876
git commit -m "Add repro project for SPR-9876"
git push
```

5\. [Send a pull request from the Github web interface](https://help.github.com/send-pull-requests/)

* The Spring Framework team will be notified and will look at your request

... and that's it!

## FAQ

### What if my issue is not a bug, but an improvement or new feature request?

In certain cases, it may make sense to submit a project for improvement requests.  Feel free to submit a project
here for your issue if you think it will help us to understand the scenario better.

### What about patches against the Spring Framework itself? Should I still attach those to my JIRA issue?

Yes, patches against JIRA will always be supported, but keep in mind that the Spring Framework project itself
is hosted on GitHub as well, and pull requests are even better! See the "Contributing" section of the Spring
Framework [readme](https://github.com/spring-projects/spring-framework#readme) for details.

### Can I still attach .zip files to my JIRA issue?  Is it required to use this repository?

Yes, you may still attach zip files if it works best for you.  Submitting pull requests against this repository
as described above is the mechanism that the Spring team prefers, but what's most important is that we get code
from you that reproduces the problem!  Please consider this approach, but zip files are still OK.
