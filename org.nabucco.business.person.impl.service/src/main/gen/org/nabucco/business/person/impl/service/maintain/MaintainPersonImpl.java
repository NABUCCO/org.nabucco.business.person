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
package org.nabucco.business.person.impl.service.maintain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.business.person.facade.message.ApplicantMsg;
import org.nabucco.business.person.facade.message.ContactPersonMsg;
import org.nabucco.business.person.facade.message.EmployeeMsg;
import org.nabucco.business.person.facade.message.IndividualPersonMsg;
import org.nabucco.business.person.facade.service.maintain.MaintainPerson;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * MaintainPersonImpl<p/>Maintain Service for Person<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class MaintainPersonImpl extends ServiceSupport implements MaintainPerson {

    private static final long serialVersionUID = 1L;

    private static final String ID = "MaintainPerson";

    private static Map<String, String[]> ASPECTS;

    private MaintainEmployeeServiceHandler maintainEmployeeServiceHandler;

    private MaintainContactPersonServiceHandler maintainContactPersonServiceHandler;

    private MaintainIndividualPersonServiceHandler maintainIndividualPersonServiceHandler;

    private DeleteEmployeeServiceHandler deleteEmployeeServiceHandler;

    private MaintainApplicantServiceHandler maintainApplicantServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new MaintainPersonImpl instance. */
    public MaintainPersonImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.maintainEmployeeServiceHandler = injector.inject(MaintainEmployeeServiceHandler.getId());
        if ((this.maintainEmployeeServiceHandler != null)) {
            this.maintainEmployeeServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainEmployeeServiceHandler.setLogger(super.getLogger());
        }
        this.maintainContactPersonServiceHandler = injector.inject(MaintainContactPersonServiceHandler.getId());
        if ((this.maintainContactPersonServiceHandler != null)) {
            this.maintainContactPersonServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainContactPersonServiceHandler.setLogger(super.getLogger());
        }
        this.maintainIndividualPersonServiceHandler = injector.inject(MaintainIndividualPersonServiceHandler.getId());
        if ((this.maintainIndividualPersonServiceHandler != null)) {
            this.maintainIndividualPersonServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainIndividualPersonServiceHandler.setLogger(super.getLogger());
        }
        this.deleteEmployeeServiceHandler = injector.inject(DeleteEmployeeServiceHandler.getId());
        if ((this.deleteEmployeeServiceHandler != null)) {
            this.deleteEmployeeServiceHandler.setPersistenceManager(persistenceManager);
            this.deleteEmployeeServiceHandler.setLogger(super.getLogger());
        }
        this.maintainApplicantServiceHandler = injector.inject(MaintainApplicantServiceHandler.getId());
        if ((this.maintainApplicantServiceHandler != null)) {
            this.maintainApplicantServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainApplicantServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("maintainEmployee", new String[] { "org.nabucco.aspect.journaling",
                    "org.nabucco.aspect.indexing", "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.transitioning" });
            ASPECTS.put("maintainContactPerson", new String[] { "org.nabucco.aspect.relating",
                    "org.nabucco.aspect.resolving", "org.nabucco.aspect.journaling",
                    "org.nabucco.aspect.transitioning", "org.nabucco.aspect.validating" });
            ASPECTS.put("maintainIndividualPerson", new String[] { "org.nabucco.aspect.journaling",
                    "org.nabucco.aspect.indexing", "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.transitioning" });
            ASPECTS.put("deleteEmployee", new String[] { "org.nabucco.aspect.validating",
                    "org.nabucco.aspect.transitioning" });
            ASPECTS.put("maintainApplicant", new String[] { "org.nabucco.aspect.validating",
                    "org.nabucco.aspect.transitioning", "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving",
                    "org.nabucco.aspect.indexing", "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.historization" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<EmployeeMsg> maintainEmployee(ServiceRequest<EmployeeMsg> rq) throws MaintainException {
        if ((this.maintainEmployeeServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainEmployee().");
            throw new InjectionException("No service implementation configured for maintainEmployee().");
        }
        ServiceResponse<EmployeeMsg> rs;
        this.maintainEmployeeServiceHandler.init();
        rs = this.maintainEmployeeServiceHandler.invoke(rq);
        this.maintainEmployeeServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ContactPersonMsg> maintainContactPerson(ServiceRequest<ContactPersonMsg> rq)
            throws MaintainException {
        if ((this.maintainContactPersonServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainContactPerson().");
            throw new InjectionException("No service implementation configured for maintainContactPerson().");
        }
        ServiceResponse<ContactPersonMsg> rs;
        this.maintainContactPersonServiceHandler.init();
        rs = this.maintainContactPersonServiceHandler.invoke(rq);
        this.maintainContactPersonServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<IndividualPersonMsg> maintainIndividualPerson(ServiceRequest<IndividualPersonMsg> rq)
            throws MaintainException {
        if ((this.maintainIndividualPersonServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainIndividualPerson().");
            throw new InjectionException("No service implementation configured for maintainIndividualPerson().");
        }
        ServiceResponse<IndividualPersonMsg> rs;
        this.maintainIndividualPersonServiceHandler.init();
        rs = this.maintainIndividualPersonServiceHandler.invoke(rq);
        this.maintainIndividualPersonServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<EmployeeMsg> deleteEmployee(ServiceRequest<EmployeeMsg> rq) throws MaintainException {
        if ((this.deleteEmployeeServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for deleteEmployee().");
            throw new InjectionException("No service implementation configured for deleteEmployee().");
        }
        ServiceResponse<EmployeeMsg> rs;
        this.deleteEmployeeServiceHandler.init();
        rs = this.deleteEmployeeServiceHandler.invoke(rq);
        this.deleteEmployeeServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ApplicantMsg> maintainApplicant(ServiceRequest<ApplicantMsg> rq) throws MaintainException {
        if ((this.maintainApplicantServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainApplicant().");
            throw new InjectionException("No service implementation configured for maintainApplicant().");
        }
        ServiceResponse<ApplicantMsg> rs;
        this.maintainApplicantServiceHandler.init();
        rs = this.maintainApplicantServiceHandler.invoke(rq);
        this.maintainApplicantServiceHandler.finish();
        return rs;
    }
}
