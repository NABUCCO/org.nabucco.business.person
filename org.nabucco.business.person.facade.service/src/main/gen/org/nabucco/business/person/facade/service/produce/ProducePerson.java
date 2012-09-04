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
package org.nabucco.business.person.facade.service.produce;

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
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * ProducePerson<p/>Produce Service for Person<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public interface ProducePerson extends Service {

    /**
     * Missing description at method produceEmployee.
     *
     * @param rq the ServiceRequest<EmployeeProduceRq>.
     * @return the ServiceResponse<EmployeeListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<EmployeeListMsg> produceEmployee(ServiceRequest<EmployeeProduceRq> rq) throws ProduceException;

    /**
     * Missing description at method produceEmployeeRole.
     *
     * @param rq the ServiceRequest<EmployeeRoleProduceRq>.
     * @return the ServiceResponse<EmployeeRoleListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<EmployeeRoleListMsg> produceEmployeeRole(ServiceRequest<EmployeeRoleProduceRq> rq)
            throws ProduceException;

    /**
     * Missing description at method produceBankAccount.
     *
     * @param rq the ServiceRequest<BankAccountProduceRq>.
     * @return the ServiceResponse<BankAccountListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<BankAccountListMsg> produceBankAccount(ServiceRequest<BankAccountProduceRq> rq)
            throws ProduceException;

    /**
     * Missing description at method produceEmployeeAccountingData.
     *
     * @param rq the ServiceRequest<EmployeeAccountingDataProduceRq>.
     * @return the ServiceResponse<EmployeeAccountingDataListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<EmployeeAccountingDataListMsg> produceEmployeeAccountingData(
            ServiceRequest<EmployeeAccountingDataProduceRq> rq) throws ProduceException;

    /**
     * Missing description at method produceEmployeeContractData.
     *
     * @param rq the ServiceRequest<EmployeeContractDataProduceRq>.
     * @return the ServiceResponse<EmployeeContractDataListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<EmployeeContractDataListMsg> produceEmployeeContractData(
            ServiceRequest<EmployeeContractDataProduceRq> rq) throws ProduceException;

    /**
     * Missing description at method produceIndividualPerson.
     *
     * @param rq the ServiceRequest<IndividualPersonProduceRq>.
     * @return the ServiceResponse<IndividualPersonListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<IndividualPersonListMsg> produceIndividualPerson(ServiceRequest<IndividualPersonProduceRq> rq)
            throws ProduceException;

    /**
     * Missing description at method produceContactPerson.
     *
     * @param rq the ServiceRequest<ContactPersonProduceRq>.
     * @return the ServiceResponse<ContactPersonListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<ContactPersonListMsg> produceContactPerson(ServiceRequest<ContactPersonProduceRq> rq)
            throws ProduceException;

    /**
     * Missing description at method produceApplicant.
     *
     * @param rq the ServiceRequest<ApplicantProduceRq>.
     * @return the ServiceResponse<ApplicantListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<ApplicantListMsg> produceApplicant(ServiceRequest<ApplicantProduceRq> rq) throws ProduceException;
}
