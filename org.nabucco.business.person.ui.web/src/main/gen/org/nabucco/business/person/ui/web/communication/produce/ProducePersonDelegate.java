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
package org.nabucco.business.person.ui.web.communication.produce;

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
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;

/**
 * ProducePersonDelegate<p/>Produce Service for Person<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class ProducePersonDelegate extends ServiceDelegateSupport {

    private ProducePerson service;

    /**
     * Constructs a new ProducePersonDelegate instance.
     *
     * @param service the ProducePerson.
     */
    public ProducePersonDelegate(ProducePerson service) {
        super();
        this.service = service;
    }

    /**
     * ProduceEmployee.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the EmployeeProduceRq.
     * @return the EmployeeListMsg.
     * @throws ProduceException
     */
    public EmployeeListMsg produceEmployee(EmployeeProduceRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<EmployeeProduceRq> request = new ServiceRequest<EmployeeProduceRq>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmployeeListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceEmployee(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProducePerson.class, "produceEmployee", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProducePerson.produceEmployee");
    }

    /**
     * ProduceEmployeeRole.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the EmployeeRoleProduceRq.
     * @return the EmployeeRoleListMsg.
     * @throws ProduceException
     */
    public EmployeeRoleListMsg produceEmployeeRole(EmployeeRoleProduceRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<EmployeeRoleProduceRq> request = new ServiceRequest<EmployeeRoleProduceRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmployeeRoleListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceEmployeeRole(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProducePerson.class, "produceEmployeeRole", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProducePerson.produceEmployeeRole");
    }

    /**
     * ProduceBankAccount.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the BankAccountProduceRq.
     * @return the BankAccountListMsg.
     * @throws ProduceException
     */
    public BankAccountListMsg produceBankAccount(BankAccountProduceRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<BankAccountProduceRq> request = new ServiceRequest<BankAccountProduceRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<BankAccountListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceBankAccount(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProducePerson.class, "produceBankAccount", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProducePerson.produceBankAccount");
    }

    /**
     * ProduceEmployeeAccountingData.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the EmployeeAccountingDataProduceRq.
     * @return the EmployeeAccountingDataListMsg.
     * @throws ProduceException
     */
    public EmployeeAccountingDataListMsg produceEmployeeAccountingData(EmployeeAccountingDataProduceRq message,
            NabuccoSession session, ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<EmployeeAccountingDataProduceRq> request = new ServiceRequest<EmployeeAccountingDataProduceRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmployeeAccountingDataListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceEmployeeAccountingData(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProducePerson.class, "produceEmployeeAccountingData", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProducePerson.produceEmployeeAccountingData");
    }

    /**
     * ProduceEmployeeContractData.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the EmployeeContractDataProduceRq.
     * @return the EmployeeContractDataListMsg.
     * @throws ProduceException
     */
    public EmployeeContractDataListMsg produceEmployeeContractData(EmployeeContractDataProduceRq message,
            NabuccoSession session, ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<EmployeeContractDataProduceRq> request = new ServiceRequest<EmployeeContractDataProduceRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmployeeContractDataListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceEmployeeContractData(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProducePerson.class, "produceEmployeeContractData", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProducePerson.produceEmployeeContractData");
    }

    /**
     * ProduceIndividualPerson.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the IndividualPersonProduceRq.
     * @return the IndividualPersonListMsg.
     * @throws ProduceException
     */
    public IndividualPersonListMsg produceIndividualPerson(IndividualPersonProduceRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<IndividualPersonProduceRq> request = new ServiceRequest<IndividualPersonProduceRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<IndividualPersonListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceIndividualPerson(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProducePerson.class, "produceIndividualPerson", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProducePerson.produceIndividualPerson");
    }

    /**
     * ProduceContactPerson.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the ContactPersonProduceRq.
     * @return the ContactPersonListMsg.
     * @throws ProduceException
     */
    public ContactPersonListMsg produceContactPerson(ContactPersonProduceRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<ContactPersonProduceRq> request = new ServiceRequest<ContactPersonProduceRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ContactPersonListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceContactPerson(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProducePerson.class, "produceContactPerson", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProducePerson.produceContactPerson");
    }

    /**
     * ProduceApplicant.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the ApplicantProduceRq.
     * @return the ApplicantListMsg.
     * @throws ProduceException
     */
    public ApplicantListMsg produceApplicant(ApplicantProduceRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ProduceException {
        ServiceRequest<ApplicantProduceRq> request = new ServiceRequest<ApplicantProduceRq>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ApplicantListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceApplicant(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProducePerson.class, "produceApplicant", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ProduceException("Cannot execute service operation: ProducePerson.produceApplicant");
    }
}
