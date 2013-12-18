package springmvc.context;

import java.beans.PropertyEditorSupport;
import org.springframework.util.StringUtils;

/**
 *
 * @author Kent Yeh
 */
public class BooleanPropertyEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        return Boolean.TRUE.equals(getValue()) ? "是(Yes)" : "否(No)";
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.hasText(text)) {
            setValue("yes".equalsIgnoreCase(text) || "true".equalsIgnoreCase(text) || "T".equalsIgnoreCase(text) || "Y".equalsIgnoreCase(text)
                    ? Boolean.TRUE : Boolean.FALSE);
        } else {
            setValue(null);
        }
    }
}