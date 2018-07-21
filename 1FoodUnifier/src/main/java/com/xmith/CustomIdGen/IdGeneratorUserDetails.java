package com.xmith.CustomIdGen;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IdGeneratorUserDetails implements IdentifierGenerator {
private static final Logger logger = LoggerFactory.getLogger(IdGeneratorUserDetails.class);

@Override
public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
logger.info("generate :Entry");		
String id=null;
Connection connection=session.connection();
try{
PreparedStatement prepareStatement = connection.prepareStatement("select userid_seq.nextval from dual");
ResultSet executeQuery = prepareStatement.executeQuery();
while (executeQuery.next()) {
id=executeQuery.getString(1);
return id;
}
}
catch (Exception e){
logger.info("error during generating id");	
e.printStackTrace();	
}


logger.info("generate :Exit");	
return null;
}



}
