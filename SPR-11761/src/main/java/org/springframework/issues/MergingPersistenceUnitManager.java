package org.springframework.issues;

import java.lang.reflect.Field;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Properties;

import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.datasource.lookup.DataSourceLookup;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;

public final class MergingPersistenceUnitManager extends DefaultPersistenceUnitManager implements DataSourceLookup, ApplicationContextAware {

    private ApplicationContext context;
    
    public MergingPersistenceUnitManager() {
        setDataSourceLookup(this);
    }

    @Override
    public void setApplicationContext(final ApplicationContext context) {
        this.context = context;
    }

    @Override
    public DataSource getDataSource(final String dataSourceName) {
        return context.getBean(dataSourceName + "DataSource", DataSource.class);
    }

    @Override
    protected boolean isPersistenceUnitOverrideAllowed() {
        return true;
    }
    
    @Override
    protected void postProcessPersistenceUnitInfo(final MutablePersistenceUnitInfo newPU) {

        super.postProcessPersistenceUnitInfo(newPU);

        newPU.addJarFileUrl(newPU.getPersistenceUnitRootUrl());
        newPU.setPersistenceUnitRootUrl(null);

        final String persistenceUnitName = newPU.getPersistenceUnitName();
        
        final PersistenceUnitInfo oldPU = getPersistenceUnitInfo(persistenceUnitName);
        if (oldPU != null) {
            // merge jar file url's
            for (URL url : oldPU.getJarFileUrls()) {
                newPU.addJarFileUrl(url);
            }
            // merge mapping class names
            for (String managedClassName : oldPU.getManagedClassNames()) {
                newPU.addManagedClassName(managedClassName);
            }
            // merge mapping file names
            for (String mappingFileName : oldPU.getMappingFileNames()) {
                newPU.addMappingFileName(mappingFileName);
            }

            // merge properties
            newPU.getProperties().putAll(oldPU.getProperties());
            
            if (oldPU.getPersistenceProviderClassName() != null) {
                if (newPU.getPersistenceProviderClassName() == null) {
                    newPU.setPersistenceProviderClassName(oldPU.getPersistenceProviderClassName());
                } else if (!newPU.getPersistenceProviderClassName().equals(oldPU.getPersistenceProviderClassName())) {
                    throw new IllegalStateException("Different PersistenceProviderClassName specified for persistence unit name [" + newPU.getPersistenceUnitName() + "]");
                }
            }

            // merge attributes
            if (oldPU.getJtaDataSource() != null) {
                if (newPU.getJtaDataSource() == null) {
                    newPU.setJtaDataSource(oldPU.getJtaDataSource());
                } else if (!newPU.getJtaDataSource().equals(oldPU.getJtaDataSource())) {
                    throw new IllegalStateException("Different JTA datasources specified for persistence unit name [" + newPU.getPersistenceUnitName() + "]");
                }
            }
            
            if (oldPU.getNonJtaDataSource() != null) {
                if (newPU.getNonJtaDataSource() == null) {
                    newPU.setNonJtaDataSource(oldPU.getNonJtaDataSource());
                } else if (!newPU.getNonJtaDataSource().equals(oldPU.getNonJtaDataSource())) {
                    throw new IllegalStateException("Different non-JTA datasources specified for persistence unit name [" + newPU.getPersistenceUnitName() + "]");
                }
            }
            
            checkAttributeByReflection(oldPU, newPU, "transactionType", PersistenceUnitTransactionType.RESOURCE_LOCAL, "transaction type");
            checkAttributeByReflection(oldPU, newPU, "validationModeName", "AUTO", "validation mode");
            checkAttributeByReflection(oldPU, newPU, "sharedCacheModeName", "UNSPECIFIED", "shared cache mode");
            checkAttributeByReflection(oldPU, newPU, "loadTimeWeaver", null, "load time weaver");
        }

        if (context.containsBean(persistenceUnitName + "JpaProperties")) {
            newPU.getProperties().putAll((Properties)context.getBean(persistenceUnitName + "JpaProperties", Reference.class).get());
        }

    }

    private void checkAttributeByReflection(final PersistenceUnitInfo oldPU, 
                                            final PersistenceUnitInfo newPU, 
                                            final String attribute, 
                                            final Object defaultValue,
                                            final String desc) {
        
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            @Override
            public Void run() {
                try {
                    final Field field = oldPU.getClass().getDeclaredField(attribute);
                    field.setAccessible(true);
                    Object oldValue = field.get(oldPU);
                    Object newValue = field.get(newPU);
                    
                    if (oldValue != null) {
                        if (newValue == null) {
                            field.set(newPU, oldValue);
                        } else if (!oldValue.equals(defaultValue)) {
                            if (newValue.equals(defaultValue)) {
                                field.set(newPU, oldValue);
                            } else if (!newValue.equals(oldValue)) {
                                throw new IllegalStateException("Different " + desc + " specified for persistence unit name [" + newPU.getPersistenceUnitName() + "]");
                            }
                        }
                    }

                } catch (NoSuchFieldException e) {
                    // silently ignore
                } catch (IllegalAccessException e) {
                    // silently ignore
                }
                return null;
            }
        });
    }

}
