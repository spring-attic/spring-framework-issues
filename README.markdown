## Welcome!

This repository is designed to allow Spring users and team members to contribute self-contained projects reproducing issues logged against Spring's JIRA issue tracker at https://jira.springsource.org.  We think it provides a superior alternative to attaching .zip files to JIRA issues for a few reasons:

* Streamlines the process of evaluating potential issues, meaning more bugs fixed more quickly!
* Facilitates two-way communication via working code: we can make modifications to your contributed projects as necessary and you can track it directly
* Makes it possible to share code easily across the team
* Provides a valuable archive of small working Spring projects across a wide range of use cases and framework features

We hope you'll find it to be a convenient and useful way of interacting with the Spring team.


## How to use this repository

The instructions below assume that you've encountered a bug against the core Spring Framework project.  If that's the case, carry on!


### First-time setup

1. [Create a Github account](https://github.com/signup/free) if you don't already have one
1. [Fork this repository and clone it locally](http://help.github.com/fork-a-repo/)

### Log an issue against Spring's JIRA issue tracker

1. First, [search SPR JIRA](https://jira.springframework.org/browse/SPR) to see if your issue has already been reported. If so, there may already be a reproduction issue in this repository!
1. If after searching an issue does not already exist, [create a new issue](https://jira.springsource.org/secure/CreateIssue!default.jspa)
    * You will now have an issue named, for example, "SPR-9876".  Make note of this, as you'll need it below when creating your project.

### Create a project that reproduces your issue

The idea is to create the smallest possible project that can reproduce your issue.  Issues may be built with either Maven or Gradle, and must contain only sources, XML and other necessary text files.  No JARs, please!

For the purpose of these instructions, we'll assume your new JIRA issue ID is "SPR-9876"

#### Steps

1\. In your local clone of spring-framework-issues, copy the `SPR-0000` directory. This is a simple 'template' issue to help you get started.

```bash
cd spring-framework-issues
cp -r SPR-0000 SPR-9876
```

2\. Modify the pom.xml to change the Maven artifactId to your JIRA issue ID

```xml
<groupId>org.springframework.issues</groupId>
<artifactId>SPR-9876</artifactId>
<version>1.0-SNAPSHOT</version>
```

3\. Import the project into your IDE and modify it as necessary to reproduce your issue.

* It is already a buildable Maven project, so you may use your IDE's built-in support for Maven to do the importing.

4\. Add, commit, and push your local fork

```bash
git add SPR-9876
git commit -m"Add repro project for SPR-9876"
git push
```

5\. [Send a pull request from the Github web interface](http://help.github.com/send-pull-requests/)

* The Spring Framework team will be notified and will look at your request
* It is also a good idea to add a comment to your JIRA issue noting that a pull request has been made

... and that's it!

## FAQ

### What if my issue is not a bug, but an improvement or new feature request?

In certain cases, it may make sense to submit a project for improvement requests.  Feel free to submit a project here for your issue if you think it will help us to understand the scenario better.

### What about patches against the Spring Framework itself? Should I still attach those to my JIRA issue?

For now, yes.  It is possible that Spring Framework will move from it's current home in SVN to Github -- when that happens, we may consider pull requests against forks of that repository.

### Can I still attach .zip files to my JIRA issue?  Is it required to use this repository?

Yes, you may still attach zip files if it works best for you.  Submitting pull requests against this repository as described above is the mechanism that the Spring team prefers, but what's most important is that we get code from you that reproduces the problem!  Please consider this approach, but zip files are still OK.
