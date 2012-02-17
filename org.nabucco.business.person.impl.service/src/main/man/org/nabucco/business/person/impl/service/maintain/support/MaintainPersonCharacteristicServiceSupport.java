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
package org.nabucco.business.person.impl.service.maintain.support;

import java.util.ArrayList;
import java.util.List;

import org.nabucco.business.person.facade.datatype.Applicant;
import org.nabucco.business.person.facade.datatype.BankAccount;
import org.nabucco.business.person.facade.datatype.ContactPerson;
import org.nabucco.business.person.facade.datatype.Employee;
import org.nabucco.business.person.facade.datatype.EmployeeAccountingData;
import org.nabucco.business.person.facade.datatype.EmployeeContractData;
import org.nabucco.business.person.facade.datatype.EmployeeRole;
import org.nabucco.business.person.facade.datatype.IndividualPerson;
import org.nabucco.business.person.facade.datatype.PersonCharacteristic;
import org.nabucco.business.person.facade.datatype.PersonMaster;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.StatusType;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionAccessor;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;

/**
 * 
 * MaintainPersonCharacteristicServiceSupport
 * 
 * @author Raffael Bieniek, PRODYNA AG
 */
public class MaintainPersonCharacteristicServiceSupport {

    private PersistenceManager persistenceManager;

    /**
     * Creates a new {@link MaintainPersonCharacteristicServiceSupport} instance.
     * 
     * @param persistenceManager
     *            the persistence manager
     */
    public MaintainPersonCharacteristicServiceSupport(PersistenceManager persistenceManager) {
        this.persistenceManager = persistenceManager;
    }

    /**
     * Maintains a {@link PersonCharacteristic}.
     * 
     * @param rootElement
     *            - the personCharacteristic to maintain
     * 
     * @return the maintained PersonCharacteristic
     * 
     * @throws MaintainException
     *             when the maintain fails
     */
    @SuppressWarnings("unchecked")
    public <P extends PersonCharacteristic> P maintain(P personCharacteristic) throws MaintainException {

        switch (personCharacteristic.getCharacteristicType()) {

        case APPLICANT:
            return (P) this.maintainApplicant((Applicant) personCharacteristic);

        case CONTACT_PERSON:
            return (P) this.maintainContactPerson((ContactPerson) personCharacteristic);

        case EMPLOYEE:
            return (P) this.maintainEmployee((Employee) personCharacteristic);

        case INDIVIDUAL_PERSON:
            return (P) this.maintainIndividualPerson((IndividualPerson) personCharacteristic);

        }

        throw new MaintainException("Person Characteristic of type '"
                + personCharacteristic.getCharacteristicType() + "' is not supported!");
    }

    /**
     * Maintain an {@link IndividualPerson}.
     * 
     * @param individualPerson
     *            the individual person to maintain
     * 
     * @return the maintained person
     * 
     * @throws MaintainException
     */
    private IndividualPerson maintainIndividualPerson(IndividualPerson individualPerson) throws MaintainException {

        if (individualPerson == null) {
            throw new MaintainException("Error while maintaining IndividualPerson! IndividualPerson must not be null!");
        }

        if (individualPerson.getDatatypeState() == DatatypeState.DELETED) {

            PersonMaster personMaster = individualPerson.getMaster();

            // delete PersonMaster
            personMaster.setDatatypeState(DatatypeState.MODIFIED);
            personMaster.setStatusType(StatusType.INACTIVE);
            this.persistPersonMaster(personMaster);

            individualPerson.setDatatypeState(DatatypeState.PERSISTENT);
        } else {
            // retrieve PersonMaster
            PersonMaster personMaster = individualPerson.getMaster();

            // maintain PersonMaster
            personMaster = this.persistPersonMaster(personMaster);

            // maintain IndividualPerson
            individualPerson.setMaster(personMaster);
            individualPerson = this.persistIndividualPerson(individualPerson);

        }

        return individualPerson;
    }

    /**
     * @param personCharacteristic
     * @return
     * @throws MaintainException
     */
    private ContactPerson maintainContactPerson(ContactPerson contactPerson) throws MaintainException {

        if (contactPerson == null) {
            throw new MaintainException("Error while maintaining ContactPerson! ContactPerson must not be null!");
        }

        if (contactPerson.getDatatypeState() == DatatypeState.DELETED) {

            PersonMaster personMaster = contactPerson.getMaster();

            // delete PersonMaster
            personMaster.setDatatypeState(DatatypeState.MODIFIED);
            personMaster.setStatusType(StatusType.INACTIVE);
            this.persistPersonMaster(personMaster);

            contactPerson.setDatatypeState(DatatypeState.PERSISTENT);

        } else {
            // retrieve PersonMaster
            PersonMaster personMaster = contactPerson.getMaster();

            // maintain PersonMaster
            personMaster = this.persistPersonMaster(personMaster);

            // maintain IndividualPerson
            contactPerson.setMaster(personMaster);
            contactPerson = this.persistContactPerson(contactPerson);

        }

        return contactPerson;
    }

    /**
     * Maintains a {@link Employee}.
     * 
     * @param employee
     *            - the Employee to maintain
     * @return the maintained Employee
     * @throws MaintainException
     */
    private Employee maintainEmployee(Employee employee) throws MaintainException {

        if (employee == null) {
            throw new MaintainException("Error while maintaining Employee! Employee must not be null!");
        }

        if (employee.getDatatypeState() == DatatypeState.DELETED) {

            PersonMaster personMaster = employee.getMaster();

            // delete PersonMaster
            personMaster.setDatatypeState(DatatypeState.MODIFIED);
            personMaster.setStatusType(StatusType.INACTIVE);
            this.persistPersonMaster(personMaster);

            employee.setDatatypeState(DatatypeState.PERSISTENT);
        } else {
            // retrieve PersonMaster
            PersonMaster personMaster = employee.getMaster();

            // maintain PersonMaster
            personMaster = this.persistPersonMaster(personMaster);

            // maintain Employee
            employee.setMaster(personMaster);
            employee.getRelationList().clear();
            employee = this.persistEmployee(employee);
        }

        return employee;
    }

    /**
     * Maintains a {@link Applicant}.
     * 
     * @param applicant
     *            - the Applicant to maintain
     * @return the maintained Applicant
     * @throws MaintainException
     */
    private Applicant maintainApplicant(Applicant applicant) throws MaintainException {

        if (applicant == null) {
            throw new MaintainException("Error while maintaining Applicant! Applicant must not be null!");
        }

        if (applicant.getDatatypeState() == DatatypeState.DELETED) {
            PersonMaster personMaster = applicant.getMaster();

            // delete PersonMaster
            personMaster.setDatatypeState(DatatypeState.MODIFIED);
            personMaster.setStatusType(StatusType.INACTIVE);
            this.persistPersonMaster(personMaster);

            applicant.setDatatypeState(DatatypeState.PERSISTENT);
        } else {
            // retrieve PersonMaster
            PersonMaster personMaster = applicant.getMaster();

            // maintain PersonMaster
            personMaster = this.persistPersonMaster(personMaster);

            // maintain Employee
            applicant.setMaster(personMaster);

            // changed from clear() by jweismueller due to errors
            applicant.getRelationList().clearAll();
            applicant = this.persistApplicant(applicant);

        }

        return applicant;
    }

    /**
     * Maintains a {@link PersonMaster}.
     * 
     * @param personMaster
     *            - the personMaster to maintain
     * @return the maintained personMaster
     * @throws MaintainException
     */
    private PersonMaster persistPersonMaster(PersonMaster personMaster) throws MaintainException {

        // master is maintained here to stay attached
        try {
            return this.persistenceManager.persist(personMaster);
        } catch (Exception pe) {
            throw new MaintainException("Error maintaining PersonMaster.", pe);
        }
    }

    /**
     * Maintains a {@link IndividualPerson}.
     * 
     * @param individualPerson
     *            - the individualPerson to maintain
     * @return the maintained individualPerson
     * @throws MaintainException
     */
    private IndividualPerson persistIndividualPerson(IndividualPerson individualPerson) throws MaintainException {

        try {
            individualPerson = this.persistenceManager.persist(individualPerson);
            return individualPerson;

        } catch (Exception pe) {
            throw new MaintainException("Error maintaining IndividualPerson!", pe);
        }
    }

    /**
     * Maintains a {@link Employee}.
     * 
     * @param employee
     *            - the employee to maintain
     * @return the maintained employee
     * @throws MaintainException
     */
    private Employee persistEmployee(Employee employee) throws MaintainException {

        try {
            if (employee.getDatatypeState() == DatatypeState.DELETED) {

                // Delete Employeroles
                List<EmployeeRole> rolesToDelete = new ArrayList<EmployeeRole>();

                for (EmployeeRole employeeRole : employee.getRoleList()) {

                    if (employeeRole.getDatatypeState() != DatatypeState.INITIALIZED) {
                        employeeRole.setDatatypeState(DatatypeState.DELETED);
                        rolesToDelete.add(employeeRole);
                    }
                }

                employee.getRoleList().clear();
                employee = this.persistenceManager.persist(employee);
                this.persistenceManager.persist(rolesToDelete);

                BankAccount bankAccount = employee.getBankAccount();
                if (bankAccount != null) {
                    bankAccount.setDatatypeState(DatatypeState.DELETED);
                    this.persistenceManager.persist(bankAccount);
                }

                EmployeeAccountingData accountingData = employee.getAccountingData();
                if (accountingData != null) {
                    accountingData.setDatatypeState(DatatypeState.DELETED);
                    this.persistenceManager.persist(accountingData);
                }

                EmployeeContractData contractData = employee.getContractData();
                if (contractData != null) {
                    contractData.setDatatypeState(DatatypeState.DELETED);
                    this.persistenceManager.persist(contractData);
                }

            } else {

                BankAccount bankAccount = employee.getBankAccount();
                if (bankAccount != null) {
                    if (bankAccount.getDatatypeState().equals(DatatypeState.DELETED)) {
                        employee.setBankAccount(null);
                    } else {
                        employee.setBankAccount(this.persistenceManager.persist(bankAccount));
                    }
                }

                EmployeeAccountingData accountingData = employee.getAccountingData();
                if (accountingData != null) {
                    if (accountingData.getDatatypeState().equals(DatatypeState.DELETED)) {
                        employee.setAccountingData(null);
                    } else {
                        employee.setAccountingData(this.persistenceManager.persist(accountingData));
                    }
                }

                EmployeeContractData contractData = employee.getContractData();
                if (contractData != null) {
                    if (contractData.getDatatypeState().equals(DatatypeState.DELETED)) {
                        employee.setContractData(null);
                    } else {
                        employee.setContractData(this.persistenceManager.persist(contractData));
                    }
                }

                // TODO: fix that workaround
                NabuccoCollectionAccessor nbcCollectionAccessor = NabuccoCollectionAccessor.getInstance();
                List<EmployeeRole> unassignedList = nbcCollectionAccessor.getUnassignedList(employee.getRoleList());

                this.persistenceManager.persist(employee.getRoleList());
                employee = this.persistenceManager.persist(employee);

                if (unassignedList.size() > 0) {
                    this.persistenceManager.persist(unassignedList);
                }

                if (bankAccount != null && bankAccount.getDatatypeState().equals(DatatypeState.DELETED)) {
                    this.persistenceManager.persist(bankAccount);
                }

                if (accountingData != null && accountingData.getDatatypeState().equals(DatatypeState.DELETED)) {
                    this.persistenceManager.persist(accountingData);
                }

                if (contractData != null && contractData.getDatatypeState().equals(DatatypeState.DELETED)) {
                    this.persistenceManager.persist(contractData);
                }

            }

            return employee;
        } catch (Exception pe) {
            throw new MaintainException("Error maintaining Employee!", pe);
        }
    }

    /**
     * Maintains a {@link Applicant}.
     * 
     * @param applicant
     *            - the Applicant to maintain
     * @return the maintained Applicant
     * @throws MaintainException
     */
    private Applicant persistApplicant(Applicant applicant) throws MaintainException {

        try {

            applicant = this.persistenceManager.persist(applicant);

            return applicant;
        } catch (Exception pe) {
            throw new MaintainException("Error maintaining Applicant!", pe);
        }
    }

    /**
     * Maintains a {@link ContactPerson}.
     * 
     * @param contactPerson
     *            - the contactPerson to maintain
     * @return the maintained contactPerson
     * @throws MaintainException
     */
    private ContactPerson persistContactPerson(ContactPerson contactPerson) throws MaintainException {

        try {
            contactPerson = this.persistenceManager.persist(contactPerson);
            return contactPerson;

        } catch (Exception pe) {
            throw new MaintainException("Error maintaining ContactPerson!", pe);
        }
    }

}
