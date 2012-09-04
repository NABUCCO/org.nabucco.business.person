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
package org.nabucco.business.person.impl.service.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.business.person.facade.message.ApplicantListMsg;
import org.nabucco.business.person.facade.message.ContactPersonListMsg;
import org.nabucco.business.person.facade.message.EmployeeIdListMsg;
import org.nabucco.business.person.facade.message.EmployeeListMsg;
import org.nabucco.business.person.facade.message.IndividualPersonListMsg;
import org.nabucco.business.person.facade.message.PersonCharacteristicMsg;
import org.nabucco.business.person.facade.message.PersonMasterListMsg;
import org.nabucco.business.person.facade.message.PersonMsg;
import org.nabucco.business.person.facade.message.search.ApplicantSearchRq;
import org.nabucco.business.person.facade.message.search.ContactPersonSearchRq;
import org.nabucco.business.person.facade.message.search.EmployeeIdSearchRq;
import org.nabucco.business.person.facade.message.search.EmployeeSearchRq;
import org.nabucco.business.person.facade.message.search.IndividualPersonSearchRq;
import org.nabucco.business.person.facade.message.search.PersonCharacteristicSearchRq;
import org.nabucco.business.person.facade.message.search.PersonMasterSearchRq;
import org.nabucco.business.person.facade.message.search.PersonSearchRq;
import org.nabucco.business.person.facade.service.search.SearchPerson;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * SearchPersonImpl<p/>Search Service for Person<p/>
 *
 * @version 1.2
 * @author Dominic Trumpfheller, Holger Librenz, PRODYNA AG, 2011-07-19
 */
public class SearchPersonImpl extends ServiceSupport implements SearchPerson {

    private static final long serialVersionUID = 1L;

    private static final String ID = "SearchPerson";

    private static Map<String, String[]> ASPECTS;

    private SearchEmployeeServiceHandler searchEmployeeServiceHandler;

    private SearchEmployeeIdServiceHandler searchEmployeeIdServiceHandler;

    private SearchPersonCharacteristicByPersonMasterIdServiceHandler searchPersonCharacteristicByPersonMasterIdServiceHandler;

    private SearchIndividualPersonServiceHandler searchIndividualPersonServiceHandler;

    private SearchContactPersonServiceHandler searchContactPersonServiceHandler;

    private SearchApplicantServiceHandler searchApplicantServiceHandler;

    private SearchPersonDatatypeServiceHandler searchPersonDatatypeServiceHandler;

    private SearchPersonMasterServiceHandler searchPersonMasterServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new SearchPersonImpl instance. */
    public SearchPersonImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.searchEmployeeServiceHandler = injector.inject(SearchEmployeeServiceHandler.getId());
        if ((this.searchEmployeeServiceHandler != null)) {
            this.searchEmployeeServiceHandler.setPersistenceManager(persistenceManager);
            this.searchEmployeeServiceHandler.setLogger(super.getLogger());
        }
        this.searchEmployeeIdServiceHandler = injector.inject(SearchEmployeeIdServiceHandler.getId());
        if ((this.searchEmployeeIdServiceHandler != null)) {
            this.searchEmployeeIdServiceHandler.setPersistenceManager(persistenceManager);
            this.searchEmployeeIdServiceHandler.setLogger(super.getLogger());
        }
        this.searchPersonCharacteristicByPersonMasterIdServiceHandler = injector
                .inject(SearchPersonCharacteristicByPersonMasterIdServiceHandler.getId());
        if ((this.searchPersonCharacteristicByPersonMasterIdServiceHandler != null)) {
            this.searchPersonCharacteristicByPersonMasterIdServiceHandler.setPersistenceManager(persistenceManager);
            this.searchPersonCharacteristicByPersonMasterIdServiceHandler.setLogger(super.getLogger());
        }
        this.searchIndividualPersonServiceHandler = injector.inject(SearchIndividualPersonServiceHandler.getId());
        if ((this.searchIndividualPersonServiceHandler != null)) {
            this.searchIndividualPersonServiceHandler.setPersistenceManager(persistenceManager);
            this.searchIndividualPersonServiceHandler.setLogger(super.getLogger());
        }
        this.searchContactPersonServiceHandler = injector.inject(SearchContactPersonServiceHandler.getId());
        if ((this.searchContactPersonServiceHandler != null)) {
            this.searchContactPersonServiceHandler.setPersistenceManager(persistenceManager);
            this.searchContactPersonServiceHandler.setLogger(super.getLogger());
        }
        this.searchApplicantServiceHandler = injector.inject(SearchApplicantServiceHandler.getId());
        if ((this.searchApplicantServiceHandler != null)) {
            this.searchApplicantServiceHandler.setPersistenceManager(persistenceManager);
            this.searchApplicantServiceHandler.setLogger(super.getLogger());
        }
        this.searchPersonDatatypeServiceHandler = injector.inject(SearchPersonDatatypeServiceHandler.getId());
        if ((this.searchPersonDatatypeServiceHandler != null)) {
            this.searchPersonDatatypeServiceHandler.setPersistenceManager(persistenceManager);
            this.searchPersonDatatypeServiceHandler.setLogger(super.getLogger());
        }
        this.searchPersonMasterServiceHandler = injector.inject(SearchPersonMasterServiceHandler.getId());
        if ((this.searchPersonMasterServiceHandler != null)) {
            this.searchPersonMasterServiceHandler.setPersistenceManager(persistenceManager);
            this.searchPersonMasterServiceHandler.setLogger(super.getLogger());
        }
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
    }

    @Override
    public String[] getAspects(String operationName) {
        if ((ASPECTS == null)) {
            ASPECTS = new HashMap<String, String[]>();
            ASPECTS.put("searchEmployee", new String[] { "org.nabucco.aspect.transitioning" });
            ASPECTS.put("searchEmployeeId", new String[] { "org.nabucco.aspect.transitioning" });
            ASPECTS.put("searchPersonCharacteristicByPersonMasterId",
                    new String[] { "org.nabucco.aspect.transitioning" });
            ASPECTS.put("searchIndividualPerson", new String[] { "org.nabucco.aspect.transitioning" });
            ASPECTS.put("searchContactPerson", new String[] { "org.nabucco.aspect.transitioning" });
            ASPECTS.put("searchApplicant", new String[] { "org.nabucco.aspect.transitioning" });
            ASPECTS.put("searchPersonDatatype", new String[] { "org.nabucco.aspect.transitioning" });
            ASPECTS.put("searchPersonMaster", new String[] { "org.nabucco.aspect.transitioning" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<EmployeeListMsg> searchEmployee(ServiceRequest<EmployeeSearchRq> rq) throws SearchException {
        if ((this.searchEmployeeServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchEmployee().");
            throw new InjectionException("No service implementation configured for searchEmployee().");
        }
        ServiceResponse<EmployeeListMsg> rs;
        this.searchEmployeeServiceHandler.init();
        rs = this.searchEmployeeServiceHandler.invoke(rq);
        this.searchEmployeeServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<EmployeeIdListMsg> searchEmployeeId(ServiceRequest<EmployeeIdSearchRq> rq)
            throws SearchException {
        if ((this.searchEmployeeIdServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchEmployeeId().");
            throw new InjectionException("No service implementation configured for searchEmployeeId().");
        }
        ServiceResponse<EmployeeIdListMsg> rs;
        this.searchEmployeeIdServiceHandler.init();
        rs = this.searchEmployeeIdServiceHandler.invoke(rq);
        this.searchEmployeeIdServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PersonCharacteristicMsg> searchPersonCharacteristicByPersonMasterId(
            ServiceRequest<PersonCharacteristicSearchRq> rq) throws SearchException {
        if ((this.searchPersonCharacteristicByPersonMasterIdServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for searchPersonCharacteristicByPersonMasterId().");
            throw new InjectionException(
                    "No service implementation configured for searchPersonCharacteristicByPersonMasterId().");
        }
        ServiceResponse<PersonCharacteristicMsg> rs;
        this.searchPersonCharacteristicByPersonMasterIdServiceHandler.init();
        rs = this.searchPersonCharacteristicByPersonMasterIdServiceHandler.invoke(rq);
        this.searchPersonCharacteristicByPersonMasterIdServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<IndividualPersonListMsg> searchIndividualPerson(ServiceRequest<IndividualPersonSearchRq> rq)
            throws SearchException {
        if ((this.searchIndividualPersonServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchIndividualPerson().");
            throw new InjectionException("No service implementation configured for searchIndividualPerson().");
        }
        ServiceResponse<IndividualPersonListMsg> rs;
        this.searchIndividualPersonServiceHandler.init();
        rs = this.searchIndividualPersonServiceHandler.invoke(rq);
        this.searchIndividualPersonServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ContactPersonListMsg> searchContactPerson(ServiceRequest<ContactPersonSearchRq> rq)
            throws SearchException {
        if ((this.searchContactPersonServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchContactPerson().");
            throw new InjectionException("No service implementation configured for searchContactPerson().");
        }
        ServiceResponse<ContactPersonListMsg> rs;
        this.searchContactPersonServiceHandler.init();
        rs = this.searchContactPersonServiceHandler.invoke(rq);
        this.searchContactPersonServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ApplicantListMsg> searchApplicant(ServiceRequest<ApplicantSearchRq> rq)
            throws SearchException {
        if ((this.searchApplicantServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchApplicant().");
            throw new InjectionException("No service implementation configured for searchApplicant().");
        }
        ServiceResponse<ApplicantListMsg> rs;
        this.searchApplicantServiceHandler.init();
        rs = this.searchApplicantServiceHandler.invoke(rq);
        this.searchApplicantServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PersonMsg> searchPersonDatatype(ServiceRequest<PersonSearchRq> rq) throws SearchException {
        if ((this.searchPersonDatatypeServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchPersonDatatype().");
            throw new InjectionException("No service implementation configured for searchPersonDatatype().");
        }
        ServiceResponse<PersonMsg> rs;
        this.searchPersonDatatypeServiceHandler.init();
        rs = this.searchPersonDatatypeServiceHandler.invoke(rq);
        this.searchPersonDatatypeServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PersonMasterListMsg> searchPersonMaster(ServiceRequest<PersonMasterSearchRq> rq)
            throws SearchException {
        if ((this.searchPersonMasterServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchPersonMaster().");
            throw new InjectionException("No service implementation configured for searchPersonMaster().");
        }
        ServiceResponse<PersonMasterListMsg> rs;
        this.searchPersonMasterServiceHandler.init();
        rs = this.searchPersonMasterServiceHandler.invoke(rq);
        this.searchPersonMasterServiceHandler.finish();
        return rs;
    }
}
