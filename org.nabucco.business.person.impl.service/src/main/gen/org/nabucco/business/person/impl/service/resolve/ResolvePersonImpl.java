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
package org.nabucco.business.person.impl.service.resolve;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.business.person.facade.message.ApplicantListMsg;
import org.nabucco.business.person.facade.message.ApplicantMsg;
import org.nabucco.business.person.facade.message.ContactPersonMsg;
import org.nabucco.business.person.facade.message.EmployeeMsg;
import org.nabucco.business.person.facade.message.IndividualPersonMsg;
import org.nabucco.business.person.facade.message.PersonMasterMsg;
import org.nabucco.business.person.facade.message.resolve.ResolveDatatypeListRq;
import org.nabucco.business.person.facade.message.resolve.ResolveDatatypeListRs;
import org.nabucco.business.person.facade.service.resolve.ResolvePerson;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * ResolvePersonImpl<p/>Resolve Service for Person<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class ResolvePersonImpl extends ServiceSupport implements ResolvePerson {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ResolvePerson";

    private static Map<String, String[]> ASPECTS;

    private ResolveEmployeeServiceHandler resolveEmployeeServiceHandler;

    private ResolvePersonMasterServiceHandler resolvePersonMasterServiceHandler;

    private ResolveIndividualPersonServiceHandler resolveIndividualPersonServiceHandler;

    private ResolveContactPersonServiceHandler resolveContactPersonServiceHandler;

    private ResolveApplicantServiceHandler resolveApplicantServiceHandler;

    private ResolveApplicantListServiceHandler resolveApplicantListServiceHandler;

    private ResolveDatatypeListServiceHandler resolveDatatypeListServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new ResolvePersonImpl instance. */
    public ResolvePersonImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.resolveEmployeeServiceHandler = injector.inject(ResolveEmployeeServiceHandler.getId());
        if ((this.resolveEmployeeServiceHandler != null)) {
            this.resolveEmployeeServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveEmployeeServiceHandler.setLogger(super.getLogger());
        }
        this.resolvePersonMasterServiceHandler = injector.inject(ResolvePersonMasterServiceHandler.getId());
        if ((this.resolvePersonMasterServiceHandler != null)) {
            this.resolvePersonMasterServiceHandler.setPersistenceManager(persistenceManager);
            this.resolvePersonMasterServiceHandler.setLogger(super.getLogger());
        }
        this.resolveIndividualPersonServiceHandler = injector.inject(ResolveIndividualPersonServiceHandler.getId());
        if ((this.resolveIndividualPersonServiceHandler != null)) {
            this.resolveIndividualPersonServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveIndividualPersonServiceHandler.setLogger(super.getLogger());
        }
        this.resolveContactPersonServiceHandler = injector.inject(ResolveContactPersonServiceHandler.getId());
        if ((this.resolveContactPersonServiceHandler != null)) {
            this.resolveContactPersonServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveContactPersonServiceHandler.setLogger(super.getLogger());
        }
        this.resolveApplicantServiceHandler = injector.inject(ResolveApplicantServiceHandler.getId());
        if ((this.resolveApplicantServiceHandler != null)) {
            this.resolveApplicantServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveApplicantServiceHandler.setLogger(super.getLogger());
        }
        this.resolveApplicantListServiceHandler = injector.inject(ResolveApplicantListServiceHandler.getId());
        if ((this.resolveApplicantListServiceHandler != null)) {
            this.resolveApplicantListServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveApplicantListServiceHandler.setLogger(super.getLogger());
        }
        this.resolveDatatypeListServiceHandler = injector.inject(ResolveDatatypeListServiceHandler.getId());
        if ((this.resolveDatatypeListServiceHandler != null)) {
            this.resolveDatatypeListServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveDatatypeListServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("resolveEmployee", new String[] { "org.nabucco.aspect.journaling",
                    "org.nabucco.aspect.resolving", "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.transitioning" });
            ASPECTS.put("resolvePersonMaster", new String[] { "org.nabucco.aspect.resolving",
                    "org.nabucco.aspect.constraining", "org.nabucco.aspect.transitioning" });
            ASPECTS.put("resolveIndividualPerson", new String[] { "org.nabucco.aspect.resolving",
                    "org.nabucco.aspect.constraining", "org.nabucco.aspect.transitioning" });
            ASPECTS.put("resolveContactPerson", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.transitioning" });
            ASPECTS.put("resolveApplicant", new String[] { "org.nabucco.aspect.resolving",
                    "org.nabucco.aspect.transitioning", "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.historization" });
            ASPECTS.put("resolveApplicantList", new String[] { "org.nabucco.aspect.resolving",
                    "org.nabucco.aspect.transitioning", "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.historization" });
            ASPECTS.put("resolveDatatypeList", new String[] { "org.nabucco.aspect.constraining",
                    "org.nabucco.aspect.transitioning" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<EmployeeMsg> resolveEmployee(ServiceRequest<EmployeeMsg> rq) throws ResolveException {
        if ((this.resolveEmployeeServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveEmployee().");
            throw new InjectionException("No service implementation configured for resolveEmployee().");
        }
        ServiceResponse<EmployeeMsg> rs;
        this.resolveEmployeeServiceHandler.init();
        rs = this.resolveEmployeeServiceHandler.invoke(rq);
        this.resolveEmployeeServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PersonMasterMsg> resolvePersonMaster(ServiceRequest<PersonMasterMsg> rq)
            throws ResolveException {
        if ((this.resolvePersonMasterServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolvePersonMaster().");
            throw new InjectionException("No service implementation configured for resolvePersonMaster().");
        }
        ServiceResponse<PersonMasterMsg> rs;
        this.resolvePersonMasterServiceHandler.init();
        rs = this.resolvePersonMasterServiceHandler.invoke(rq);
        this.resolvePersonMasterServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<IndividualPersonMsg> resolveIndividualPerson(ServiceRequest<IndividualPersonMsg> rq)
            throws ResolveException {
        if ((this.resolveIndividualPersonServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveIndividualPerson().");
            throw new InjectionException("No service implementation configured for resolveIndividualPerson().");
        }
        ServiceResponse<IndividualPersonMsg> rs;
        this.resolveIndividualPersonServiceHandler.init();
        rs = this.resolveIndividualPersonServiceHandler.invoke(rq);
        this.resolveIndividualPersonServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ContactPersonMsg> resolveContactPerson(ServiceRequest<ContactPersonMsg> rq)
            throws ResolveException {
        if ((this.resolveContactPersonServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveContactPerson().");
            throw new InjectionException("No service implementation configured for resolveContactPerson().");
        }
        ServiceResponse<ContactPersonMsg> rs;
        this.resolveContactPersonServiceHandler.init();
        rs = this.resolveContactPersonServiceHandler.invoke(rq);
        this.resolveContactPersonServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ApplicantMsg> resolveApplicant(ServiceRequest<ApplicantMsg> rq) throws ResolveException {
        if ((this.resolveApplicantServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveApplicant().");
            throw new InjectionException("No service implementation configured for resolveApplicant().");
        }
        ServiceResponse<ApplicantMsg> rs;
        this.resolveApplicantServiceHandler.init();
        rs = this.resolveApplicantServiceHandler.invoke(rq);
        this.resolveApplicantServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ApplicantListMsg> resolveApplicantList(ServiceRequest<ApplicantListMsg> rq)
            throws ResolveException {
        if ((this.resolveApplicantListServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveApplicantList().");
            throw new InjectionException("No service implementation configured for resolveApplicantList().");
        }
        ServiceResponse<ApplicantListMsg> rs;
        this.resolveApplicantListServiceHandler.init();
        rs = this.resolveApplicantListServiceHandler.invoke(rq);
        this.resolveApplicantListServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ResolveDatatypeListRs> resolveDatatypeList(ServiceRequest<ResolveDatatypeListRq> rq)
            throws ResolveException {
        if ((this.resolveDatatypeListServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveDatatypeList().");
            throw new InjectionException("No service implementation configured for resolveDatatypeList().");
        }
        ServiceResponse<ResolveDatatypeListRs> rs;
        this.resolveDatatypeListServiceHandler.init();
        rs = this.resolveDatatypeListServiceHandler.invoke(rq);
        this.resolveDatatypeListServiceHandler.finish();
        return rs;
    }
}
