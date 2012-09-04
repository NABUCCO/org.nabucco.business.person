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
package org.nabucco.business.person.facade.datatype;

import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelation;
import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelationType;

/**
 * ContactPersonComponentRelation
 *
 * @version 1.0
 * @author Raffael Bieniek, PRODYNA AG, 2011-06-07
 */
public class ContactPersonComponentRelation extends ComponentRelation<ContactPerson> {

    private static final long serialVersionUID = 1L;

    /** Constructs a new ContactPersonComponentRelation instance. */
    protected ContactPersonComponentRelation() {
        super();
    }

    /**
     * Constructs a new ContactPersonComponentRelation instance.
     *
     * @param relationType the ComponentRelationType.
     */
    public ContactPersonComponentRelation(ComponentRelationType relationType) {
        super(relationType);
    }

    /**
     * Getter for the Tarthe .
     *
     * @return the ContactPerson.
     */
    public ContactPerson getTarget() {
        return super.getTarget();
    }

    /**
     * Setter for the Target.
     *
     * @param target the ContactPerson.
     */
    public void setTarget(ContactPerson target) {
        super.setTarget(target);
    }

    @Override
    public ContactPersonComponentRelation cloneObject() {
        ContactPersonComponentRelation clone = new ContactPersonComponentRelation();
        super.cloneObject(clone);
        return clone;
    }
}
