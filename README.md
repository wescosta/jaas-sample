Java Authentication and Authorization Service (JAAS) Sample
===========

# JBoss Configuration

## Adding the mysql connector:

cp ~/.m2/repository/mysql/mysql-connector-java/5.1.25/mysql-connector-java-5.1.25.jar $JBOSS_HOME/standalone/deployments/

## Creating the datasource and the security domain

In your $JBOSS_HOME/standalone/configuration/standalone.xml, add the following configurations

`````xml
<datasource jta="false" jndi-name="java:/jaas-sample-ds" pool-name="jaas-sample" enabled="true" use-ccm="false">
    <connection-url>jdbc:mysql://localhost:3306/jaas-sample</connection-url>
    <driver-class>com.mysql.jdbc.Driver</driver-class>
    <driver>mysql-connector-java-5.1.25.jar</driver>
    <security>
        <user-name>root</user-name>
        <password>root</password>
    </security>
</datasource>

<security-domain name="jaas-sample" cache-type="default">
    <authentication>
        <login-module code="org.jboss.security.auth.spi.DatabaseServerLoginModule" flag="required">
            <module-option name="dsJndiName" value="java:/jaas-sample-ds"/>
            <module-option name="principalsQuery" value="select password from USERS where login=?"/>
            <module-option name="rolesQuery" value="select role, 'Roles' from USERS u inner join ROLES r on (r.user_id = u.id) where u.login=?"/>
        </login-module>
    </authentication>
</security-domain>
`````
