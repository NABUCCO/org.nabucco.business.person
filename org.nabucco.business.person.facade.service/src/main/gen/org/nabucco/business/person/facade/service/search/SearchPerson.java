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
package org.nabucco.business.person.facade.service.search;

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
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * SearchPerson<p/>Search Service for Person<p/>
 *
 * @version 1.2
 * @author Dominic Trumpfheller, Holger Librenz, PRODYNA AG, 2011-07-19
 */
public interface SearchPerson extends Service {

    /**
     * Missing description at method searchEmployee.
     *
     * @param rq the ServiceRequest<EmployeeSearchRq>.
     * @return the ServiceResponse<EmployeeListMsg>.
     * @throws SearchException
     */
    ServiceResponse<EmployeeListMsg> searchEmployee(ServiceRequest<EmployeeSearchRq> rq) throws SearchException;

    /**
     * Missing description at method searchEmployeeId.
     *
     * @param rq the ServiceRequest<EmployeeIdSearchRq>.
     * @return the ServiceResponse<EmployeeIdListMsg>.
     * @throws SearchException
     */
    ServiceResponse<EmployeeIdListMsg> searchEmployeeId(ServiceRequest<EmployeeIdSearchRq> rq) throws SearchException;

    /**
     * Missing description at method searchPersonCharacteristicByPersonMasterId.
     *
     * @param rq the ServiceRequest<PersonCharacteristicSearchRq>.
     * @return the ServiceResponse<PersonCharacteristicMsg>.
     * @throws SearchException
     */
    ServiceResponse<PersonCharacteristicMsg> searchPersonCharacteristicByPersonMasterId(
            ServiceRequest<PersonCharacteristicSearchRq> rq) throws SearchException;

    /**
     * Missing description at method searchIndividualPerson.
     *
     * @param rq the ServiceRequest<IndividualPersonSearchRq>.
     * @return the ServiceResponse<IndividualPersonListMsg>.
     * @throws SearchException
     */
    ServiceResponse<IndividualPersonListMsg> searchIndividualPerson(ServiceRequest<IndividualPersonSearchRq> rq)
            throws SearchException;

    /**
     * Missing description at method searchContactPerson.
     *
     * @param rq the ServiceRequest<ContactPersonSearchRq>.
     * @return the ServiceResponse<ContactPersonListMsg>.
     * @throws SearchException
     */
    ServiceResponse<ContactPersonListMsg> searchContactPerson(ServiceRequest<ContactPersonSearchRq> rq)
            throws SearchException;

    /**
     * Missing description at method searchApplicant.
     *
     * @param rq the ServiceRequest<ApplicantSearchRq>.
     * @return the ServiceResponse<ApplicantListMsg>.
     * @throws SearchException
     */
    ServiceResponse<ApplicantListMsg> searchApplicant(ServiceRequest<ApplicantSearchRq> rq) throws SearchException;

    /**
     * Missing description at method searchPersonDatatype.
     *
     * @param rq the ServiceRequest<PersonSearchRq>.
     * @return the ServiceResponse<PersonMsg>.
     * @throws SearchException
     */
    ServiceResponse<PersonMsg> searchPersonDatatype(ServiceRequest<PersonSearchRq> rq) throws SearchException;

    /**
     * Missing description at method searchPersonMaster.
     *
     * @param rq the ServiceRequest<PersonMasterSearchRq>.
     * @return the ServiceResponse<PersonMasterListMsg>.
     * @throws SearchException
     */
    ServiceResponse<PersonMasterListMsg> searchPersonMaster(ServiceRequest<PersonMasterSearchRq> rq)
            throws SearchException;
}
