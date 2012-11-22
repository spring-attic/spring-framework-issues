package org.springframework.issues.test2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "testcontroller2")
public class Testing2Controller extends AbstractTest2Controller<Test2DTO,Long>
{

}
