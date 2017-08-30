package org.springframework.issues.model;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

public class ThingRequest {

    @Size(min = 1, max = 1)
    private String otherParameter;

    @Valid
    @Size(min = 1)
    private List<@ValidThingId String> thingIds;

    public String getOtherParameter() {
        return otherParameter;
    }

    public void setOtherParameter(String otherParameter) {
        this.otherParameter = otherParameter;
    }

    public List<String> getThingIds() {
        return thingIds;
    }

    public void setThingIds(List<String> thingIds) {
        this.thingIds = thingIds;
    }
}
