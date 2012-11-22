package org.springframework.issues.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "testcontroller")
public class TestingController extends AbstractTestController<TestDTO>
{

}
