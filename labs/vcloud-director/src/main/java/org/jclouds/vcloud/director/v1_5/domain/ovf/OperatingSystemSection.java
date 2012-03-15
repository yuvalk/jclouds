/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.vcloud.director.v1_5.domain.ovf;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Objects;

/**
 * An OperatingSystemSection specifies the operating system installed on a virtual machine.
 *
 * @author Adrian Cole
 * @author Adam Lowe
 */
@XmlRootElement(name = "OperatingSystemSection")
public class OperatingSystemSection extends SectionType {

   public static Builder<?> builder() {
      return new ConcreteBuilder();
   }

   public Builder<?> toBuilder() {
      return builder().fromOperatingSystemSection(this);
   }

   private static class ConcreteBuilder extends Builder<ConcreteBuilder> {
   }
   
   public static class Builder<B extends Builder<B>> extends SectionType.Builder<B> {
      private Integer id;
      private String description;
      private String version;

      /**
       * @see OperatingSystemSection#getId()
       */
      public B id(Integer id) {
         this.id = id;
         return self();
      }

      /**
       * @see OperatingSystemSection#getVersion()
       */
      public B version(String version) {
         this.version = version;
         return self();
      }

      /**
       * @see OperatingSystemSection#getDescription
       */
      public B description(String description) {
         this.description = description;
         return self();
      }

      /**
       * {@inheritDoc}
       */
      @Override
      public OperatingSystemSection build() {
         return new OperatingSystemSection(this);
      }

      public B fromOperatingSystemSection(OperatingSystemSection in) {
         return id(in.getId()).info(in.getInfo()).description(in.getDescription());
      }
   }

   @XmlAttribute
   protected Integer id;
   @XmlAttribute
   protected String version;
   @XmlElement
   protected String description;

   public OperatingSystemSection(Builder<?> builder) {
      super(builder);
      this.id = builder.id;
      this.description = builder.description;
      this.version = builder.version;
   }

   protected OperatingSystemSection() {
      // For Builders and JAXB
   }

   /**
    * 
    * @return ovf id
    * @see org.jclouds.vcloud.director.v1_5.domain.cim.OSType#getCode()
    */
   public Integer getId() {
      return id;
   }

   public String getVersion() {
      return version;
   }

   /**
    * 
    * @return description or null
    */
   public String getDescription() {
      return description;
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(super.hashCode(), description);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      
      OperatingSystemSection other = (OperatingSystemSection) obj;
      return super.equals(other) && Objects.equal(description, other.description);
   }

   @Override
   protected Objects.ToStringHelper string() {
      return super.string().add("description", description);
   }

}