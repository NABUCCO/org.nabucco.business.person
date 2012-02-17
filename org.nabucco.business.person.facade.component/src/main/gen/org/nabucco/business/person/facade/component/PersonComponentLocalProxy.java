/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.business.person.facade.component;

import org.nabucco.business.person.facade.component.PersonComponent;
import org.nabucco.business.person.facade.service.maintain.MaintainPerson;
import org.nabucco.business.person.facade.service.produce.ProducePerson;
import org.nabucco.business.person.facade.service.resolve.ResolvePerson;
import org.nabucco.business.person.facade.service.search.SearchPerson;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.facade.service.queryfilter.QueryFilterService;

/**
 * PersonComponentLocalProxy<p/>Person component<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class PersonComponentLocalProxy implements PersonComponent {

    private static final long serialVersionUID = 1L;

    private final PersonComponentLocal delegate;

    /**
     * Constructs a new PersonComponentLocalProxy instance.
     *
     * @param delegate the PersonComponentLocal.
     */
    public PersonComponentLocalProxy(PersonComponentLocal delegate) {
        super();
        if ((delegate == null)) {
            throw new IllegalArgumentException("Cannot create local proxy for component [null].");
        }
        this.delegate = delegate;
    }

    @Override
    public String getId() {
        return this.delegate.getId();
    }

    @Override
    public String getName() {
        return this.delegate.getName();
    }

    @Override
    public String getJndiName() {
        return this.delegate.getJndiName();
    }

    @Override
    public ComponentRelationService getComponentRelationService() throws ServiceException {
        return this.delegate.getComponentRelationServiceLocal();
    }

    @Override
    public QueryFilterService getQueryFilterService() throws ServiceException {
        return this.delegate.getQueryFilterServiceLocal();
    }

    @Override
    public String toString() {
        return this.delegate.toString();
    }

    @Override
    public MaintainPerson getMaintainPerson() throws ServiceException {
        return this.delegate.getMaintainPersonLocal();
    }

    @Override
    public ProducePerson getProducePerson() throws ServiceException {
        return this.delegate.getProducePersonLocal();
    }

    @Override
    public ResolvePerson getResolvePerson() throws ServiceException {
        return this.delegate.getResolvePersonLocal();
    }

    @Override
    public SearchPerson getSearchPerson() throws ServiceException {
        return this.delegate.getSearchPersonLocal();
    }
}
