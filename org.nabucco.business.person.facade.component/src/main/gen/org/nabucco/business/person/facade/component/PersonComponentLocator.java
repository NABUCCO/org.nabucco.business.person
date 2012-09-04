/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.business.person.facade.component;

import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.component.locator.ComponentLocator;
import org.nabucco.framework.base.facade.component.locator.ComponentLocatorSupport;

/**
 * Locator for PersonComponent.
 *
 * @author NABUCCO Generator, PRODYNA AG
 */
public class PersonComponentLocator extends ComponentLocatorSupport<PersonComponent> implements
        ComponentLocator<PersonComponent> {

    private static PersonComponentLocator instance;

    /**
     * Constructs a new PersonComponentLocator instance.
     *
     * @param component the Class<PersonComponent>.
     * @param jndiName the String.
     */
    private PersonComponentLocator(String jndiName, Class<PersonComponent> component) {
        super(jndiName, component);
    }

    @Override
    public PersonComponent getComponent() throws ConnectionException {
        PersonComponent component = super.getComponent();
        if ((component instanceof PersonComponentLocal)) {
            return new PersonComponentLocalProxy(((PersonComponentLocal) component));
        }
        return component;
    }

    /**
     * Getter for the Instance.
     *
     * @return the PersonComponentLocator.
     */
    public static PersonComponentLocator getInstance() {
        if ((instance == null)) {
            instance = new PersonComponentLocator(PersonComponent.JNDI_NAME, PersonComponent.class);
        }
        return instance;
    }
}
