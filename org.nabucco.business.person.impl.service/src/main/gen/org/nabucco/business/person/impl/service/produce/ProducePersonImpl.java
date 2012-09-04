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
package org.nabucco.business.person.impl.service.produce;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.business.person.facade.message.ApplicantListMsg;
import org.nabucco.business.person.facade.message.BankAccountListMsg;
import org.nabucco.business.person.facade.message.ContactPersonListMsg;
import org.nabucco.business.person.facade.message.EmployeeAccountingDataListMsg;
import org.nabucco.business.person.facade.message.EmployeeContractDataListMsg;
import org.nabucco.business.person.facade.message.EmployeeListMsg;
import org.nabucco.business.person.facade.message.EmployeeRoleListMsg;
import org.nabucco.business.person.facade.message.IndividualPersonListMsg;
import org.nabucco.business.person.facade.message.produce.ApplicantProduceRq;
import org.nabucco.business.person.facade.message.produce.BankAccountProduceRq;
import org.nabucco.business.person.facade.message.produce.ContactPersonProduceRq;
import org.nabucco.business.person.facade.message.produce.EmployeeAccountingDataProduceRq;
import org.nabucco.business.person.facade.message.produce.EmployeeContractDataProduceRq;
import org.nabucco.business.person.facade.message.produce.EmployeeProduceRq;
import org.nabucco.business.person.facade.message.produce.EmployeeRoleProduceRq;
import org.nabucco.business.person.facade.message.produce.IndividualPersonProduceRq;
import org.nabucco.business.person.facade.service.produce.ProducePerson;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * ProducePersonImpl<p/>Produce Service for Person<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class ProducePersonImpl extends ServiceSupport implements ProducePerson {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ProducePerson";

    private static Map<String, String[]> ASPECTS;

    private ProduceEmployeeServiceHandler produceEmployeeServiceHandler;

    private ProduceEmployeeRoleServiceHandler produceEmployeeRoleServiceHandler;

    private ProduceBankAccountServiceHandler produceBankAccountServiceHandler;

    private ProduceEmployeeAccountingDataServiceHandler produceEmployeeAccountingDataServiceHandler;

    private ProduceEmployeeContractDataServiceHandler produceEmployeeContractDataServiceHandler;

    private ProduceIndividualPersonServiceHandler produceIndividualPersonServiceHandler;

    private ProduceContactPersonServiceHandler produceContactPersonServiceHandler;

    private ProduceApplicantServiceHandler produceApplicantServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new ProducePersonImpl instance. */
    public ProducePersonImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.produceEmployeeServiceHandler = injector.inject(ProduceEmployeeServiceHandler.getId());
        if ((this.produceEmployeeServiceHandler != null)) {
            this.produceEmployeeServiceHandler.setPersistenceManager(persistenceManager);
            this.produceEmployeeServiceHandler.setLogger(super.getLogger());
        }
        this.produceEmployeeRoleServiceHandler = injector.inject(ProduceEmployeeRoleServiceHandler.getId());
        if ((this.produceEmployeeRoleServiceHandler != null)) {
            this.produceEmployeeRoleServiceHandler.setPersistenceManager(persistenceManager);
            this.produceEmployeeRoleServiceHandler.setLogger(super.getLogger());
        }
        this.produceBankAccountServiceHandler = injector.inject(ProduceBankAccountServiceHandler.getId());
        if ((this.produceBankAccountServiceHandler != null)) {
            this.produceBankAccountServiceHandler.setPersistenceManager(persistenceManager);
            this.produceBankAccountServiceHandler.setLogger(super.getLogger());
        }
        this.produceEmployeeAccountingDataServiceHandler = injector.inject(ProduceEmployeeAccountingDataServiceHandler
                .getId());
        if ((this.produceEmployeeAccountingDataServiceHandler != null)) {
            this.produceEmployeeAccountingDataServiceHandler.setPersistenceManager(persistenceManager);
            this.produceEmployeeAccountingDataServiceHandler.setLogger(super.getLogger());
        }
        this.produceEmployeeContractDataServiceHandler = injector.inject(ProduceEmployeeContractDataServiceHandler
                .getId());
        if ((this.produceEmployeeContractDataServiceHandler != null)) {
            this.produceEmployeeContractDataServiceHandler.setPersistenceManager(persistenceManager);
            this.produceEmployeeContractDataServiceHandler.setLogger(super.getLogger());
        }
        this.produceIndividualPersonServiceHandler = injector.inject(ProduceIndividualPersonServiceHandler.getId());
        if ((this.produceIndividualPersonServiceHandler != null)) {
            this.produceIndividualPersonServiceHandler.setPersistenceManager(persistenceManager);
            this.produceIndividualPersonServiceHandler.setLogger(super.getLogger());
        }
        this.produceContactPersonServiceHandler = injector.inject(ProduceContactPersonServiceHandler.getId());
        if ((this.produceContactPersonServiceHandler != null)) {
            this.produceContactPersonServiceHandler.setPersistenceManager(persistenceManager);
            this.produceContactPersonServiceHandler.setLogger(super.getLogger());
        }
        this.produceApplicantServiceHandler = injector.inject(ProduceApplicantServiceHandler.getId());
        if ((this.produceApplicantServiceHandler != null)) {
            this.produceApplicantServiceHandler.setPersistenceManager(persistenceManager);
            this.produceApplicantServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("produceEmployee", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceEmployeeRole", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceBankAccount", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceEmployeeAccountingData", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceEmployeeContractData", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceIndividualPerson", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceContactPerson", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceApplicant", new String[] { "org.nabucco.aspect.initializing" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<EmployeeListMsg> produceEmployee(ServiceRequest<EmployeeProduceRq> rq)
            throws ProduceException {
        if ((this.produceEmployeeServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceEmployee().");
            throw new InjectionException("No service implementation configured for produceEmployee().");
        }
        ServiceResponse<EmployeeListMsg> rs;
        this.produceEmployeeServiceHandler.init();
        rs = this.produceEmployeeServiceHandler.invoke(rq);
        this.produceEmployeeServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<EmployeeRoleListMsg> produceEmployeeRole(ServiceRequest<EmployeeRoleProduceRq> rq)
            throws ProduceException {
        if ((this.produceEmployeeRoleServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceEmployeeRole().");
            throw new InjectionException("No service implementation configured for produceEmployeeRole().");
        }
        ServiceResponse<EmployeeRoleListMsg> rs;
        this.produceEmployeeRoleServiceHandler.init();
        rs = this.produceEmployeeRoleServiceHandler.invoke(rq);
        this.produceEmployeeRoleServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<BankAccountListMsg> produceBankAccount(ServiceRequest<BankAccountProduceRq> rq)
            throws ProduceException {
        if ((this.produceBankAccountServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceBankAccount().");
            throw new InjectionException("No service implementation configured for produceBankAccount().");
        }
        ServiceResponse<BankAccountListMsg> rs;
        this.produceBankAccountServiceHandler.init();
        rs = this.produceBankAccountServiceHandler.invoke(rq);
        this.produceBankAccountServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<EmployeeAccountingDataListMsg> produceEmployeeAccountingData(
            ServiceRequest<EmployeeAccountingDataProduceRq> rq) throws ProduceException {
        if ((this.produceEmployeeAccountingDataServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceEmployeeAccountingData().");
            throw new InjectionException("No service implementation configured for produceEmployeeAccountingData().");
        }
        ServiceResponse<EmployeeAccountingDataListMsg> rs;
        this.produceEmployeeAccountingDataServiceHandler.init();
        rs = this.produceEmployeeAccountingDataServiceHandler.invoke(rq);
        this.produceEmployeeAccountingDataServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<EmployeeContractDataListMsg> produceEmployeeContractData(
            ServiceRequest<EmployeeContractDataProduceRq> rq) throws ProduceException {
        if ((this.produceEmployeeContractDataServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceEmployeeContractData().");
            throw new InjectionException("No service implementation configured for produceEmployeeContractData().");
        }
        ServiceResponse<EmployeeContractDataListMsg> rs;
        this.produceEmployeeContractDataServiceHandler.init();
        rs = this.produceEmployeeContractDataServiceHandler.invoke(rq);
        this.produceEmployeeContractDataServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<IndividualPersonListMsg> produceIndividualPerson(ServiceRequest<IndividualPersonProduceRq> rq)
            throws ProduceException {
        if ((this.produceIndividualPersonServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceIndividualPerson().");
            throw new InjectionException("No service implementation configured for produceIndividualPerson().");
        }
        ServiceResponse<IndividualPersonListMsg> rs;
        this.produceIndividualPersonServiceHandler.init();
        rs = this.produceIndividualPersonServiceHandler.invoke(rq);
        this.produceIndividualPersonServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ContactPersonListMsg> produceContactPerson(ServiceRequest<ContactPersonProduceRq> rq)
            throws ProduceException {
        if ((this.produceContactPersonServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceContactPerson().");
            throw new InjectionException("No service implementation configured for produceContactPerson().");
        }
        ServiceResponse<ContactPersonListMsg> rs;
        this.produceContactPersonServiceHandler.init();
        rs = this.produceContactPersonServiceHandler.invoke(rq);
        this.produceContactPersonServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ApplicantListMsg> produceApplicant(ServiceRequest<ApplicantProduceRq> rq)
            throws ProduceException {
        if ((this.produceApplicantServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceApplicant().");
            throw new InjectionException("No service implementation configured for produceApplicant().");
        }
        ServiceResponse<ApplicantListMsg> rs;
        this.produceApplicantServiceHandler.init();
        rs = this.produceApplicantServiceHandler.invoke(rq);
        this.produceApplicantServiceHandler.finish();
        return rs;
    }
}
