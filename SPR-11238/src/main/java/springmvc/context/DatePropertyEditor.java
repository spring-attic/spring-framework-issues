package springmvc.context;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.util.StringUtils;

/**
 *
 * @author Kent Yeh
 */
public class DatePropertyEditor extends PropertyEditorSupport {

    private static Logger logger = LogManager.getLogger(DatePropertyEditor.class);
    private static Map<String, String> patterns = new HashMap<String, String>();

    static {
        DatePropertyEditor.patterns.put("yyyyMMdd", "^\\d{8}$");
        DatePropertyEditor.patterns.put("yyyyMMddHHmmss", "^\\d{14}$");
        DatePropertyEditor.patterns.put("yyyy/M/d", "^\\d{4}/\\d{1,2}/\\d{1,2}$");
        DatePropertyEditor.patterns.put("yyyy/M/d H:m", "^\\d{4}/\\d{1,2}/\\d{1,2} \\d{1,2}:\\d{1,2}$");
        DatePropertyEditor.patterns.put("yyyy/M/d H:m:s", "^\\d{4}/\\d{1,2}/\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$");
        DatePropertyEditor.patterns.put("yyyy-M-d", "^\\d{4}-\\d{1,2}-\\d{1,2}$");
        DatePropertyEditor.patterns.put("yyyy-M-d H:m", "^\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}$");
        DatePropertyEditor.patterns.put("yyyy-M-d H:m:s", "^\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$");
    }

    @Override
    public String getAsText() {
        return getValue()==null?"":String.format("%1$tY/%1$tm/%1$td", getValue());
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (!StringUtils.hasText(text)) {
            setValue(null);
        } else if (text instanceof String) {
            Object dateObj = null;
            SimpleDateFormat df = new SimpleDateFormat();
            for (String key : DatePropertyEditor.patterns.keySet()) {
                if (text.matches(DatePropertyEditor.patterns.get(key))) {
                    df.applyPattern(key);
                    try {
                        dateObj = df.parse(text);
                    } catch (Exception e) {
                        logger.error(String.format("轉換日期%s[%s]失敗", text, key), e.getMessage(), e);
                    }
                    break;
                }
            }
            setValue(dateObj);
        } else {
            setValue(null);
        }
    }
}
