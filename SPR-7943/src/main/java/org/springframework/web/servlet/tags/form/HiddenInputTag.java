/*
 * Copyright 2002-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.servlet.tags.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ParameterHandler;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * Data-binding aware JSP tag for rendering a hidden HTML '<code>input</code>' field
 * containing the databound value.
 *
 * <p>Example (binding to 'name' property of form backing object):
 * <pre class="code>
 * &lt;form:hidden path=&quot;name&quot;/&gt;
 * </pre>
 *
 * @author Rob Harrop
 * @author Juergen Hoeller
 * @since 2.0
 */
public class HiddenInputTag extends AbstractHtmlElementTag {

	/**
	 * Writes the HTML '<code>input</code>' tag to the supplied {@link TagWriter} including the
	 * databound value.
	 * @see #writeDefaultAttributes(TagWriter)
	 * @see #getBoundValue()
	 */
	@Override
	protected int writeTagContent(TagWriter tagWriter) throws JspException {
		tagWriter.startTag("input");
		writeDefaultAttributes(tagWriter);
		tagWriter.writeAttribute("type", "hidden");

		String displayValue = getDisplayString(getBoundValue(), getPropertyEditor());
		String displayName = getDisplayString(evaluate("name", getName()));
		
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		ParameterHandler parameterHandler = RequestContextUtils.getParameterHandler(request);		
		parameterHandler.processFormParameterName(request, displayName, "hidden");
		String processedValue = 
			parameterHandler.processFormParameterValue(request, displayName, displayValue, "hidden");
		
		tagWriter.writeAttribute("value", processedValue);
		tagWriter.endTag();
		
		return SKIP_BODY;
	}

}
