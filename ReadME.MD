1.  IMPLEMENTACION SERVIDOR.
    En el archivo StandAlone.XML ubicado en la ruta del servido: {JBOSS_SERVER}\standalone\configuration 
    Con la respectiva conexión de la base de datos.

                <datasource jndi-name="java:jboss/datasources/PostgresDS" pool-name="PostgresDS" enabled="true" use-java-context="true" statistics-enabled="true">
                    <connection-url>jdbc:postgresql://localhost:5432/vehicles-jee</connection-url>
                    <driver>postgres</driver>
                    <pool>
                        <min-pool-size>2</min-pool-size>
                        <max-pool-size>20</max-pool-size>
                    </pool>
                    <security>
                        <user-name>postgres</user-name>
                        <password>123</password>
                    </security>
                </datasource>
                <drivers>
                    <driver name="postgres" module="org.postgresql">
                        <xa-datasource-class>org.postgresql.xa.PGXADataSource</xa-datasource-class>
                    </driver>

Agregar el respectivo Module.XML en la ruta (crearla si no existe):
{JBOSS_SERVER}\modules\system\layers\base\org\postgresql\main    

<?xml version="1.0" encoding="UTF-8"?>
<!--
  ~ JBoss, Home of Professional Open Source.
  ~ Copyright 2010, Red Hat, Inc., and individual contributors
  ~ as indicated by the @author tags. See the copyright.txt file in the
  ~ distribution for a full listing of individual contributors.
  ~
  ~ This is free software; you can redistribute it and/or modify it
  ~ under the terms of the GNU Lesser General Public License as
  ~ published by the Free Software Foundation; either version 2.1 of
  ~ the License, or (at your option) any later version.
  ~
  ~ This software is distributed in the hope that it will be useful,
  ~ but WITHOUT ANY WARRANTY; without even the implied warranty of
  ~ MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
  ~ Lesser General Public License for more details.
  ~
  ~ You should have received a copy of the GNU Lesser General Public
  ~ License along with this software; if not, write to the Free
  ~ Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
  ~ 02110-1301 USA, or see the FSF site: http://www.fsf.org.
  -->

    <module name="org.postgresql" xmlns="urn:jboss:module:1.9">
        <resources>
            <resource-root path="postgresql-42.3.7.jar"/>
        </resources>
    
        <dependencies>
            <module name="java.compiler"/>
            <module name="java.desktop"/>
            <module name="java.instrument"/>
            <module name="java.logging"/>
            <module name="java.management"/>
            <module name="java.naming"/>
            <module name="java.scripting"/>
            <module name="java.sql"/>
            <!--WFLY-14219 Remove deprecated <module name="javax.api"/> -->
            <module name="javax.transaction.api"/>
            <module name="javax.servlet.api" optional="true"/>
            <module name="org.slf4j"/>
        </dependencies>
    </module>
    
Agregar el .jar JDBC de Postgres, se puede descargar desde https://mvnrepository.com/artifact/org.postgresql/postgresql/42.3.7

2. Implementación de la base de datos.
   Ejecutar el Script.sql ubicado en resources/bd
    
3. Consumo del servicio Rest.
    DIRECCION_DEL_SERVIDOR:PUERTO/api/v1/vehicles/<strong>(fecha a buscar en formato AAAA-MM-DD)</strong>