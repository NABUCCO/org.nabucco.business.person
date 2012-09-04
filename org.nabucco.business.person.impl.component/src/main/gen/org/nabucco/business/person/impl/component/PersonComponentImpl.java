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
package org.nabucco.business.person.impl.component;

import org.nabucco.business.person.facade.component.PersonComponentLocal;
import org.nabucco.business.person.facade.component.PersonComponentRemote;
import org.nabucco.business.person.facade.service.maintain.MaintainPerson;
import org.nabucco.business.person.facade.service.produce.ProducePerson;
import org.nabucco.business.person.facade.service.resolve.ResolvePerson;
import org.nabucco.business.person.facade.service.search.SearchPerson;
import org.nabucco.framework.base.facade.component.handler.PostConstructHandler;
import org.nabucco.framework.base.facade.component.handler.PreDestroyHandler;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.facade.service.queryfilter.QueryFilterService;
import org.nabucco.framework.base.impl.component.ComponentSupport;

/**
 * PersonComponentImpl<p/>Person component<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class PersonComponentImpl extends ComponentSupport implements PersonComponentLocal, PersonComponentRemote {

    private static final long serialVersionUID = 1L;

    private static final String ID = "PersonComponent";

    /** Constructs a new PersonComponentImpl instance. */
    public PersonComponentImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PostConstructHandler handler = injector.inject(PostConstructHandler.getId());
        if ((handler == null)) {
            if (super.getLogger().isDebugEnabled()) {
                super.getLogger().debug("No post construct handler configured for \'", ID, "\'.");
            }
            return;
        }
        handler.setLocatable(this);
        handler.setLogger(super.getLogger());
        handler.invoke();
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PreDestroyHandler handler = injector.inject(PreDestroyHandler.getId());
        if ((handler == null)) {
            if (super.getLogger().isDebugEnabled()) {
                super.getLogger().debug("No pre destroy handler configured for \'", ID, "\'.");
            }
            return;
        }
        handler.setLocatable(this);
        handler.setLogger(super.getLogger());
        handler.invoke();
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getName() {
        return COMPONENT_NAME;
    }

    @Override
    public String getJndiName() {
        return JNDI_NAME;
    }

    @Override
    public ComponentRelationService getComponentRelationService() throws ServiceException {
        return super.lookup(PersonComponentJndiNames.COMPONENT_RELATION_SERVICE_REMOTE, ComponentRelationService.class);
    }

    @Override
    public ComponentRelationService getComponentRelationServiceLocal() throws ServiceException {
        return super.lookup(PersonComponentJndiNames.COMPONENT_RELATION_SERVICE_LOCAL, ComponentRelationService.class);
    }

    @Override
    public QueryFilterService getQueryFilterService() throws ServiceException {
        return super.lookup(PersonComponentJndiNames.QUERY_FILTER_SERVICE_REMOTE, QueryFilterService.class);
    }

    @Override
    public QueryFilterService getQueryFilterServiceLocal() throws ServiceException {
        return super.lookup(PersonComponentJndiNames.QUERY_FILTER_SERVICE_LOCAL, QueryFilterService.class);
    }

    @Override
    public MaintainPerson getMaintainPersonLocal() throws ServiceException {
        return super.lookup(PersonComponentJndiNames.MAINTAIN_PERSON_LOCAL, MaintainPerson.class);
    }

    @Override
    public MaintainPerson getMaintainPerson() throws ServiceException {
        return super.lookup(PersonComponentJndiNames.MAINTAIN_PERSON_REMOTE, MaintainPerson.class);
    }

    @Override
    public ProducePerson getProducePersonLocal() throws ServiceException {
        return super.lookup(PersonComponentJndiNames.PRODUCE_PERSON_LOCAL, ProducePerson.class);
    }

    @Override
    public ProducePerson getProducePerson() throws ServiceException {
        return super.lookup(PersonComponentJndiNames.PRODUCE_PERSON_REMOTE, ProducePerson.class);
    }

    @Override
    public ResolvePerson getResolvePersonLocal() throws ServiceException {
        return super.lookup(PersonComponentJndiNames.RESOLVE_PERSON_LOCAL, ResolvePerson.class);
    }

    @Override
    public ResolvePerson getResolvePerson() throws ServiceException {
        return super.lookup(PersonComponentJndiNames.RESOLVE_PERSON_REMOTE, ResolvePerson.class);
    }

    @Override
    public SearchPerson getSearchPersonLocal() throws ServiceException {
        return super.lookup(PersonComponentJndiNames.SEARCH_PERSON_LOCAL, SearchPerson.class);
    }

    @Override
    public SearchPerson getSearchPerson() throws ServiceException {
        return super.lookup(PersonComponentJndiNames.SEARCH_PERSON_REMOTE, SearchPerson.class);
    }
}
