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
package org.nabucco.business.person.facade.datatype;

import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelation;
import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelationType;

/**
 * EmployeeComponentRelation
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-23
 */
public class EmployeeComponentRelation extends ComponentRelation<Employee> {

    private static final long serialVersionUID = 1L;

    /** Constructs a new EmployeeComponentRelation instance. */
    protected EmployeeComponentRelation() {
        super();
    }

    /**
     * Constructs a new EmployeeComponentRelation instance.
     *
     * @param relationType the ComponentRelationType.
     */
    public EmployeeComponentRelation(ComponentRelationType relationType) {
        super(relationType);
    }

    /**
     * Getter for the Tarthe .
     *
     * @return the Employee.
     */
    public Employee getTarget() {
        return super.getTarget();
    }

    /**
     * Setter for the Target.
     *
     * @param target the Employee.
     */
    public void setTarget(Employee target) {
        super.setTarget(target);
    }

    @Override
    public EmployeeComponentRelation cloneObject() {
        EmployeeComponentRelation clone = new EmployeeComponentRelation();
        super.cloneObject(clone);
        return clone;
    }
}
