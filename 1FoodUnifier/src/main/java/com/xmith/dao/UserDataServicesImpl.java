package com.xmith.dao;



import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xmith.models.UserAccount;
import com.xmith.models.UserAttempts;
import com.xmith.models.UserDetails;
import com.xmith.models.Users;

@Component
public class UserDataServicesImpl implements UserDataServices {
	private static final Logger logger = LoggerFactory.getLogger(UserDataServicesImpl.class);
	
	
	@Autowired
	private SessionFactory sfactory;

	//comment added
	//branch new
	
	public void setSfactory(SessionFactory sfactory) {
		this.sfactory = sfactory;
	}
	

	@Override
	public String getUserId(String username) {
		logger.info("getUserId dao entry");
		Users user=null;
		Session session= sfactory.openSession();
		Transaction txn= session.beginTransaction();
		Query query=session.createQuery("from Users where  user_name= :username");
	    query.setParameter("username", username);
	    try{
	     user=(Users)query.uniqueResult();
	    txn.commit();
	    }
	    catch(HibernateException e){
	    	txn.rollback();
	    	e.printStackTrace();
	    }
	    finally{
	    	if(session!=null){
	    		session.close();
	    	}
	    	
	    }
	    logger.info("getUserId dao exit");
	    
if(user==null){
return null;	
}
	    
		return user.getUser_id();
	}


	@Override
	public int updateToken(String username, String tokenid) {
		logger.info("updateToken Entry");
	     Session session = sfactory.openSession();
	     Transaction txn = session.beginTransaction();
	     Query query = session.createQuery("update Users set user_token= :token where user_name= :username");
	     query.setParameter("token", tokenid);
	     query.setParameter("username", username);
	     int executeUpdate=9;
	     try {
			 executeUpdate = query.executeUpdate();
			 logger.info("update success(og-9):"+ executeUpdate);
		    txn.commit();
		} 
	     
	     catch(HibernateException e){
	    	 txn.rollback();
	    	 e.printStackTrace();
	    	 
	     }
	     finally {
			session.close();
		}
		logger.info("updateToken Exit");
		return executeUpdate;
	}


	@Override
	public Users getUser(String userid) {
		logger.info("getUser entry");
		Users user=null;
		Session session=sfactory.openSession();
		Transaction txn = session.beginTransaction();
		Query query = session.createQuery(" from Users where  user_id= :userid ");
		query.setParameter("userid", userid);
		try{
		 user= (Users)query.uniqueResult();
		txn.commit();
		}
		
		catch(Exception e){
			e.printStackTrace();
			txn.rollback();
		}
		finally{
			session.close();
		}
		logger.info("getUser exit");
		return user;
	}


	@Override
	public Object []  getuserlogindao(String username) {
    logger.info("getuserlogindao Entry:");
    Object [] userlog=null;
    Session session = sfactory.openSession();
    Transaction txn = session.beginTransaction();
    logger.info("before");
    List<Object []> objectarray=null;
    try{
    Query<Object[]> cquery = session.createQuery("select a.user_name,a.user_password,a.user_enabled,a.user_authority,b.user_attempts,a.user_id from Users a,UserAttempts b where a.user_id=b.user_id and a.user_name= :username");
    logger.info("after");
    cquery.setParameter("username", username);
    objectarray=cquery.list();
    //just check here
    for (Object[] objects : objectarray) {
    	userlog=objects;
    	
	}
    txn.commit();
    }
    catch(Exception e)
    {
    e.printStackTrace();
    logger.info("error in executing query : getuserlogindao");	
    txn.rollback();
    }
    finally {
	session.close();	
	}
    logger.info("getuserlogindao Exit:");
		return userlog;
	}


	@Override
	public int updateAttempts(String userid,String attempts) {
	logger.info("updateAttempts : Entry");
	int executeUpdate = 9;
	
	Session openSession = sfactory.openSession();
	Transaction beginTransaction = openSession.beginTransaction();
	try{
	Query createQuery = openSession.createQuery("update UserAttempts set user_attempts= :attempts where user_id= :userid");
	createQuery.setParameter("attempts", attempts);
	createQuery.setParameter("userid", userid);
	executeUpdate=createQuery.executeUpdate();
	beginTransaction.commit();
	}
	catch(Exception e){
	beginTransaction.rollback();	
	logger.info("Exception in :updateAttempts");
	e.printStackTrace();	
	}
	finally {
	openSession.close();	
	}
	logger.info("updateAttempts : Exit");
	return executeUpdate;
	}




@Override
public String saveUsers(Users users) {
logger.info("saveUsers :Entry");
Session openSession = sfactory.openSession();
Transaction beginTransaction = openSession.beginTransaction();
Serializable save=null;
try{
save= openSession.save(users);	
beginTransaction.commit();
}
catch(Exception e){
logger.info("exception in saveUsers");	
beginTransaction.rollback();
}
finally{
openSession.close();	
}
if(save==null){
return null;	
}
logger.info("saveUsers :Exit");
return save.toString();
}


@Override
public String saveUsersDetails(UserDetails userdetails) {
logger.info("saveUsersDetails :Entry");
Session openSession = sfactory.openSession();
Transaction beginTransaction = openSession.beginTransaction();
Serializable save=null;
try{
save= openSession.save(userdetails);	
beginTransaction.commit();
}
catch(Exception e){
logger.info("exception in saveUsers");	
beginTransaction.rollback();
}
finally{
openSession.close();	
}
if(save==null){
return null;	
}
logger.info("saveUsers :Exit");
return save.toString();
}


@Override
public String saveUsersAttempts(UserAttempts userAttempts) {
logger.info("saveUsersAttempts :Entry");
Session openSession = sfactory.openSession();
Transaction beginTransaction = openSession.beginTransaction();
Serializable save=null;
try{
save= openSession.save(userAttempts);	
beginTransaction.commit();
}
catch(Exception e){
logger.info("exception in saveUsersAttempts");	
beginTransaction.rollback();
}
finally{
openSession.close();	
}
if(save==null){
return null;	
}
logger.info("saveUsersAttempts :Exit");
return save.toString();
}


@Override
public List<UserAccount> getUserAccounts(String UserId) {
logger.info("getUserAccounts: Entry");
Session session = sfactory.openSession();
Transaction txn = session.beginTransaction();
List<UserAccount> listAccounts=null;

try{
Query<UserAccount> query = session.createQuery("from UserAccount");
listAccounts = query.list();
txn.commit();
}
catch(Exception e){
txn.rollback();	
}
finally{
session.close();	
}
if(listAccounts==null){
return null;	
}
return listAccounts;
}









}
