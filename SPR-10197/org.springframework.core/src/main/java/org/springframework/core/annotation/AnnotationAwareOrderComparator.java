/*
 * Copyright 2002-2006 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.annotation;

import org.springframework.core.OrderComparator;
import org.springframework.core.Ordered;

/**
 * {@link java.util.Comparator} implementation that checks
 * {@link org.springframework.core.Ordered} as well as the
 * {@link Order} annotation, with an order value provided by an
 * <code>Ordered</code> instance overriding a statically defined
 * annotation value (if any).
 *
 * @author Juergen Hoeller
 * @since 2.0.1
 * @see org.springframework.core.Ordered
 * @see Order
 */
public class AnnotationAwareOrderComparator extends OrderComparator {

	@Override
	protected int getOrder(Object obj) {
		if (obj instanceof Ordered) {
			return ((Ordered) obj).getOrder();
		}
		if (obj != null) {
			Order order = obj.getClass().getAnnotation(Order.class);
			if (order != null) {
				return order.value();
			}
		}
		return Ordered.LOWEST_PRECEDENCE;
	}

}
