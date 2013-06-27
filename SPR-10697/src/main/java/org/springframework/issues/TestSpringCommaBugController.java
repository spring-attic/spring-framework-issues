package org.springframework.issues;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestSpringCommaBugController {

    private static final String JSP_MODEL_NAME = "softwareVendor";

    @RequestMapping(value = "/addSoftwareVersion2.html")
    public ModelAndView addSoftwareVersion2() {

        SoftwareVendorVO softwareVendorVO = new SoftwareVendorVO(2, "SoftwareVendor1");
        List<SoftwareNameVO> softwareNameVOs = new ArrayList<SoftwareNameVO>();

        SoftwareNameVO softwareNameWith2 = new SoftwareNameVO(143, "5");
        List<SoftwareVersionVO> versions = new ArrayList<SoftwareVersionVO>();
        versions.add(new SoftwareVersionVO(542, "5", false, false));
        versions.add(new SoftwareVersionVO(370, "6", true, true));
        softwareNameWith2.setVersions(versions);
        softwareNameVOs.add(softwareNameWith2);

        softwareVendorVO.setSoftware(softwareNameVOs);

        return new ModelAndView("edit_tokenization_add_software_version", JSP_MODEL_NAME, softwareVendorVO);
    }

    @RequestMapping(value = "/saveSoftwareVersion.html")
    public ModelAndView saveSoftwareVersion(@ModelAttribute("softwareVendorVO") SoftwareVendorVO softwareVendorVO) {
        return new ModelAndView("edit_tokenization_add_software_version", JSP_MODEL_NAME, softwareVendorVO);
    }
}
