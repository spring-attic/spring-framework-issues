package org.springframework.issues.hibernate;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.util.Assert;

public class HibernateClassBypassingLoadTimeWeaver implements LoadTimeWeaver {

	private final LoadTimeWeaver loadTimeWeaver;

	public HibernateClassBypassingLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
		Assert.notNull(loadTimeWeaver);
		this.loadTimeWeaver = loadTimeWeaver;
	}

	@Override
	public ClassLoader getInstrumentableClassLoader() {
		return loadTimeWeaver.getInstrumentableClassLoader();
	}

	@Override
	public ClassLoader getThrowawayClassLoader() {
		return loadTimeWeaver.getThrowawayClassLoader();
	}

	@Override
	public void addTransformer(ClassFileTransformer transformer) {
		loadTimeWeaver.addTransformer(new HibernateClassBypassingClassFileTransformer(transformer));
	}

	/**
	 * ClassFileTransformer decorator that suppresses processing of Hibernate
	 * classes in order to avoid potential LinkageErrors.
	 * @see org.springframework.context.annotation.LoadTimeWeavingConfiguration
	 */
	private static class HibernateClassBypassingClassFileTransformer implements ClassFileTransformer {
		private static final Logger LOGGER = LoggerFactory.getLogger(HibernateClassBypassingClassFileTransformer.class);

		private final ClassFileTransformer delegate;

		public HibernateClassBypassingClassFileTransformer(ClassFileTransformer delegate) {
			this.delegate = delegate;
		}

		@Override
		public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer)
				throws IllegalClassFormatException {

			if (className.startsWith("org.hibernate") || className.startsWith("org/hibernate") || className.startsWith("javassist")) {
				LOGGER.trace("Bypassing class: {}", className);
				return classfileBuffer;
			}
			return this.delegate.transform(loader, className, classBeingRedefined, protectionDomain, classfileBuffer);
		}
	}
}