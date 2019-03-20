How to reproduce the issue:

* Run the application with Tomcat 7
* Access from browser: https://.../get_message
* Open another tab and access: https://.../send_message
* First tab prints the word message
* Switch to Tomcat 8.
* Access from browser: https://.../get_message
* Open another tab and access: https://.../send_message
* Nothing happens in first tab
