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
package org.nabucco.business.person.ui.web.communication;

import org.nabucco.business.person.facade.component.PersonComponent;
import org.nabucco.business.person.facade.component.PersonComponentLocator;
import org.nabucco.business.person.ui.web.communication.maintain.MaintainPersonDelegate;
import org.nabucco.business.person.ui.web.communication.produce.ProducePersonDelegate;
import org.nabucco.business.person.ui.web.communication.resolve.ResolvePersonDelegate;
import org.nabucco.business.person.ui.web.communication.search.SearchPersonDelegate;
import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateFactorySupport;

/**
 * ServiceDelegateFactoryTemplate<p/>Person component<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class PersonComponentServiceDelegateFactory extends ServiceDelegateFactorySupport<PersonComponent> {

    private static PersonComponentServiceDelegateFactory instance = new PersonComponentServiceDelegateFactory();

    private MaintainPersonDelegate maintainPersonDelegate;

    private ProducePersonDelegate producePersonDelegate;

    private ResolvePersonDelegate resolvePersonDelegate;

    private SearchPersonDelegate searchPersonDelegate;

    /** Constructs a new PersonComponentServiceDelegateFactory instance. */
    private PersonComponentServiceDelegateFactory() {
        super(PersonComponentLocator.getInstance());
    }

    /**
     * Getter for the MaintainPerson.
     *
     * @return the MaintainPersonDelegate.
     * @throws ClientException
     */
    public MaintainPersonDelegate getMaintainPerson() throws ClientException {
        try {
            if ((this.maintainPersonDelegate == null)) {
                this.maintainPersonDelegate = new MaintainPersonDelegate(this.getComponent().getMaintainPerson());
            }
            return this.maintainPersonDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: MaintainPerson", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the ProducePerson.
     *
     * @return the ProducePersonDelegate.
     * @throws ClientException
     */
    public ProducePersonDelegate getProducePerson() throws ClientException {
        try {
            if ((this.producePersonDelegate == null)) {
                this.producePersonDelegate = new ProducePersonDelegate(this.getComponent().getProducePerson());
            }
            return this.producePersonDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: ProducePerson", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the ResolvePerson.
     *
     * @return the ResolvePersonDelegate.
     * @throws ClientException
     */
    public ResolvePersonDelegate getResolvePerson() throws ClientException {
        try {
            if ((this.resolvePersonDelegate == null)) {
                this.resolvePersonDelegate = new ResolvePersonDelegate(this.getComponent().getResolvePerson());
            }
            return this.resolvePersonDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: ResolvePerson", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the SearchPerson.
     *
     * @return the SearchPersonDelegate.
     * @throws ClientException
     */
    public SearchPersonDelegate getSearchPerson() throws ClientException {
        try {
            if ((this.searchPersonDelegate == null)) {
                this.searchPersonDelegate = new SearchPersonDelegate(this.getComponent().getSearchPerson());
            }
            return this.searchPersonDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: SearchPerson", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the Instance.
     *
     * @return the PersonComponentServiceDelegateFactory.
     */
    public static PersonComponentServiceDelegateFactory getInstance() {
        return instance;
    }
}
