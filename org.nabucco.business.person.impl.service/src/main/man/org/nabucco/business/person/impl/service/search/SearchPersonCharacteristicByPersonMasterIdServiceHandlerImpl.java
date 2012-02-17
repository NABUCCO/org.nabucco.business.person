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
package org.nabucco.business.person.impl.service.search;

import java.util.List;

import org.nabucco.business.person.facade.datatype.Applicant;
import org.nabucco.business.person.facade.datatype.ContactPerson;
import org.nabucco.business.person.facade.datatype.Employee;
import org.nabucco.business.person.facade.datatype.PersonCharacteristic;
import org.nabucco.business.person.facade.message.PersonCharacteristicMsg;
import org.nabucco.business.person.facade.message.search.PersonCharacteristicSearchRq;
import org.nabucco.framework.base.facade.datatype.StatusType;
import org.nabucco.framework.base.facade.datatype.utils.BasetypeUtil;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;

/**
 * SearchPersonCharacteristicByPersonMasterIdServiceHandlerImpl
 * 
 * @author Raffael Bieniek, PRODYNA AG
 */
public class SearchPersonCharacteristicByPersonMasterIdServiceHandlerImpl extends
        SearchPersonCharacteristicByPersonMasterIdServiceHandler {

    /**
     * Default serial version UID.
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected PersonCharacteristicMsg searchPersonCharacteristicByPersonMasterId(PersonCharacteristicSearchRq msg)
            throws SearchException {

        if (BasetypeUtil.isEmpty(msg.getPersonMasterId())) {
            throw new SearchException("The person master id is not set.");
        }

        Long personMasterId = msg.getPersonMasterId().getValue();

        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT d FROM PersonCharacteristic d");
        queryString.append(" WHERE d.master.statusType = :statusType AND d.master.id = :personMasterId");

        try {
            NabuccoQuery<PersonCharacteristic> query = super.getPersistenceManager()
                    .createQuery(queryString.toString());
            query.setParameter("statusType", StatusType.ACTIVE);
            query.setParameter("personMasterId", personMasterId);

            List<PersonCharacteristic> resultList = query.getResultList();

            PersonCharacteristicMsg response = new PersonCharacteristicMsg();

            for (PersonCharacteristic personCharacteristic : resultList) {

                switch (personCharacteristic.getCharacteristicType()) {

                case APPLICANT: {
                    Applicant applicant = (Applicant) super.getPersistenceManager().find(personCharacteristic);
                    applicant.getRelationList().size();

                    if (!applicant.getApplicantStatus().getFunctionalId().getValueAsString().equals("$employed")
                            && !applicant.getApplicantStatus().getFunctionalId().getValueAsString()
                                    .equals("$tobeemployed")) {
                        response.setPersonCharacteristic(applicant);

                        return response;
                    }

                    break;
                }

                case CONTACT_PERSON: {
                    ContactPerson contactPerson = (ContactPerson) super.getPersistenceManager().find(
                            personCharacteristic);

                    contactPerson.getRelationList().size();
                    response.setPersonCharacteristic(contactPerson);

                    break;
                }

                case EMPLOYEE: {

                    Employee employee = (Employee) super.getPersistenceManager().find(personCharacteristic);
                    employee.getAbsenceList().size();
                    employee.getRelationList().size();
                    employee.getRoleList().size();

                    if (!employee.getEmployeeStatus().getFunctionalId().getValueAsString().equals("$canceledqualified")) {
                        response.setPersonCharacteristic(employee);
                        return response;
                    }

                    break;
                }

                }

            }

            return response;

        } catch (Exception e) {
            throw new SearchException(e);
        }
    }
}
