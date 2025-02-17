/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.atlas.v1.model.typedef;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.PUBLIC_ONLY;

@JsonAutoDetect(getterVisibility = PUBLIC_ONLY, setterVisibility = PUBLIC_ONLY, fieldVisibility = NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class HierarchicalTypeDefinition extends StructTypeDefinition implements Serializable {
    private static final long serialVersionUID = 1L;

    private String      hierarchicalMetaTypeName = "org.apache.atlas.typesystem.types.TraitType";
    private Set<String> superTypes;

    public HierarchicalTypeDefinition() {
    }

    public HierarchicalTypeDefinition(String typeName, String typeDescription, String typeVersion, List<AttributeDefinition> attributeDefinitions, String hierarchicalMetaTypeName, Set<String> superTypes) {
        super(typeName, typeDescription, typeVersion, attributeDefinitions);

        this.hierarchicalMetaTypeName = hierarchicalMetaTypeName;
        this.superTypes               = superTypes;
    }

    public String getHierarchicalMetaTypeName() {
        return hierarchicalMetaTypeName;
    }

    public void setHierarchicalMetaTypeName(String hierarchicalMetaTypeName) {
        this.hierarchicalMetaTypeName = hierarchicalMetaTypeName;
    }

    public Set<String> getSuperTypes() {
        return superTypes;
    }

    public void setSuperTypes(Set<String> superTypes) {
        this.superTypes = superTypes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), superTypes, hierarchicalMetaTypeName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass() || !super.equals(o)) {
            return false;
        }

        HierarchicalTypeDefinition that = (HierarchicalTypeDefinition) o;

        return Objects.equals(superTypes, that.superTypes) &&
                Objects.equals(hierarchicalMetaTypeName, that.hierarchicalMetaTypeName);
    }
}
