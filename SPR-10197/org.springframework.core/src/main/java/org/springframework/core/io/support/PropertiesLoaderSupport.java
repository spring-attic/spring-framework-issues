/*
 * Copyright 2002-2012 the original author or authors.
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

package org.springframework.core.io.support;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.core.io.Resource;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;

/**
 * Base class for JavaBean-style components that need to load properties
 * from one or more resources. Supports local properties as well, with
 * configurable overriding.
 *
 * @author Juergen Hoeller
 * @since 1.2.2
 */
public abstract class PropertiesLoaderSupport {

	public static final String XML_FILE_EXTENSION = ".xml";


	/** Logger available to subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	protected Properties[] localProperties;

	protected boolean localOverride = false;

	private Resource[] locations;

	private boolean ignoreResourceNotFound = false;

	private String fileEncoding;

	private PropertiesPersister propertiesPersister = new DefaultPropertiesPersister();


	/**
	 * Set local properties, e.g. via the "props" tag in XML bean definitions.
	 * These can be considered defaults, to be overridden by properties
	 * loaded from files.
	 */
	public void setProperties(Properties properties) {
		this.localProperties = new Properties[] {properties};
	}

	/**
	 * Set local properties, e.g. via the "props" tag in XML bean definitions,
	 * allowing for merging multiple properties sets into one.
	 */
	public void setPropertiesArray(Properties[] propertiesArray) {
		this.localProperties = propertiesArray;
	}

	/**
	 * Set a location of a properties file to be loaded.
	 * <p>Can point to a classic properties file or to an XML file
	 * that follows JDK 1.5's properties XML format.
	 */
	public void setLocation(Resource location) {
		this.locations = new Resource[] {location};
	}

	/**
	 * Set locations of properties files to be loaded.
	 * <p>Can point to classic properties files or to XML files
	 * that follow JDK 1.5's properties XML format.
	 * <p>Note: Properties defined in later files will override
	 * properties defined earlier files, in case of overlapping keys.
	 * Hence, make sure that the most specific files are the last
	 * ones in the given list of locations.
	 */
	public void setLocations(Resource[] locations) {
		this.locations = locations;
	}

	/**
	 * Set whether local properties override properties from files.
	 * <p>Default is "false": Properties from files override local defaults.
	 * Can be switched to "true" to let local properties override defaults
	 * from files.
	 */
	public void setLocalOverride(boolean localOverride) {
		this.localOverride = localOverride;
	}

	/**
	 * Set if failure to find the property resource should be ignored.
	 * <p>"true" is appropriate if the properties file is completely optional.
	 * Default is "false".
	 */
	public void setIgnoreResourceNotFound(boolean ignoreResourceNotFound) {
		this.ignoreResourceNotFound = ignoreResourceNotFound;
	}

	/**
	 * Set the encoding to use for parsing properties files.
	 * <p>Default is none, using the <code>java.util.Properties</code>
	 * default encoding.
	 * <p>Only applies to classic properties files, not to XML files.
	 * @see org.springframework.util.PropertiesPersister#load
	 */
	public void setFileEncoding(String encoding) {
		this.fileEncoding = encoding;
	}

	/**
	 * Set the PropertiesPersister to use for parsing properties files.
	 * The default is DefaultPropertiesPersister.
	 * @see org.springframework.util.DefaultPropertiesPersister
	 */
	public void setPropertiesPersister(PropertiesPersister propertiesPersister) {
		this.propertiesPersister =
				(propertiesPersister != null ? propertiesPersister : new DefaultPropertiesPersister());
	}


	/**
	 * Return a merged Properties instance containing both the
	 * loaded properties and properties set on this FactoryBean.
	 */
	protected Properties mergeProperties() throws IOException {
		Properties result = new Properties();

		if (this.localOverride) {
			// Load properties from file upfront, to let local properties override.
			loadProperties(result);
		}

		if (this.localProperties != null) {
			for (Properties localProp : this.localProperties) {
				CollectionUtils.mergePropertiesIntoMap(localProp, result);
			}
		}

		if (!this.localOverride) {
			// Load properties from file afterwards, to let those properties override.
			loadProperties(result);
		}

		return result;
	}

	/**
	 * Load properties into the given instance.
	 * @param props the Properties instance to load into
	 * @throws java.io.IOException in case of I/O errors
	 * @see #setLocations
	 */
	protected void loadProperties(Properties props) throws IOException {
		if (this.locations != null) {
			for (Resource location : this.locations) {
				if (logger.isInfoEnabled()) {
					logger.info("Loading properties file from " + location);
				}
				InputStream is = null;
				try {
					is = location.getInputStream();
					String filename = location.getFilename();
					if (filename != null && filename.endsWith(XML_FILE_EXTENSION)) {
						this.propertiesPersister.loadFromXml(props, is);
					}
					else {
						if (this.fileEncoding != null) {
							this.propertiesPersister.load(props, new InputStreamReader(is, this.fileEncoding));
						}
						else {
							this.propertiesPersister.load(props, is);
						}
					}
				}
				catch (IOException ex) {
					if (this.ignoreResourceNotFound) {
						if (logger.isWarnEnabled()) {
							logger.warn("Could not load properties from " + location + ": " + ex.getMessage());
						}
					}
					else {
						throw ex;
					}
				}
				finally {
					if (is != null) {
						is.close();
					}
				}
			}
		}
	}

}
