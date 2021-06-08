# Cucumber Testing Project

This is a simple example of cucumber testing project using selenium.

## Project Structure

The basic structure of the project is:

```text
      +-------------------------+
      |   Main (test.project)   |
      |   +----------------+    |
      |   |      API       |    |
      |   +----------------+    |
      |   +----------------+    |
      |   |    External    |    |
      |   +----------------+    |
      |   +----------------+    |
      |   |     Infra      |    |
      |   +----------------+    |
      |   +----------------+    |
      |   |  Page Objects  |    |
      |   +----------------+    |
      |           .             |
      |           .             |
      |           .             |
      +-------------------------+
```

All the packages described above are just some examples of what could be added in a test project.
The following sections briefly describe what the packages in the example could be handling.

### API

This package could handle API calls to the system to be tested. In this case, all implementation
would be isolated adding the possibility to shared between test projects / components.


### External

Any call to external services can be implemented under this package (if no SDK or library is already available and can
reused).

### Infra

Package with implementation of test infra. E.g. Selenium helpers, connection to tools used by automation to report test
results, etc.

### Page Objects

Page object implementation, referenced in the test flow.
