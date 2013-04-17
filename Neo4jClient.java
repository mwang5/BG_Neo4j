package neo4j;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.HashMap;
import java.util.Properties;

import org.neo4j.*;
import org.neo4j.graphdb.GraphDatabaseService;

import com.mongodb.WriteConcern;


import edu.usc.bg.base.ByteIterator;
import edu.usc.bg.base.DB;
import edu.usc.bg.base.DBException;
import edu.usc.bg.base.ObjectByteIterator;

/**
 * Neo4j client for BG framework.
 *
 * Properties to set:
 *
 *
 */

public abstract class Neo4jClient extends DB implements Neo4jConstraints {
	
	private static AtomicInteger NumThreads = null;
	private String database;
	private boolean manipulationArray;
	private boolean friendListReq;
	
	private static int incrementNumThreads() {
        int v;
        do {
            v = NumThreads.get();
        } while (!NumThreads.compareAndSet(v, v + 1));
        return v + 1;
    }
	
	private static int decrementNumThreads() {
        int v;
        if(NumThreads != null){
	        do {
	            v = NumThreads.get();
	        } while (!NumThreads.compareAndSet(v, v - 1));
	        return v - 1;
        }else
        	return -1;
    }
	@Override
	public boolean init() throws DBException {
		
		Properties props = getProperties();
		String url = props.getProperty(NEO4J_URL_PROPERTY);
		database = props.getProperty(NEO4J_DB_PROPERTY);
		/*what is writeconcern here in neo4j*/
		manipulationArray = Boolean.parseBoolean(
				props.getProperty(NEO4J_MANIPULATION_ARRAY_PROPERTY, NEO4J_MANIPULATION_ARRAY_PROPERTY_DEFAULT));
		friendListReq = Boolean.parseBoolean(
				props.getProperty(NEO4J_FRNDLIST_REQ_PROPERTY, NEO4J_FRNDLIST_REQ_PROPERTY_DEFAULT));
		

		return true;
	
	}
	
	@Override
	/**
	 *	Methods below should necessarily implement for loading the data to Neo4j
	 */
	public int insertEntity(String EntitySet,String EntityPK, 
			HashMap<String, ByteIterator> values, boolean insertImage) {
		
		return 0;
		
	}
	
	@Override
	public HashMap<String, String> getInitialStats() {
		HashMap<String, String> stats = new HashMap<String, String>();
		GraphDatabaseService graphDb = null;
		
		return stats;
	}
	
	@Override
	public void cleanup(boolean warmup) throws DBException {
		return;
	}
	
	@Override
	public int CreateFriendship(int memberA, int memberB) {
		int retVal = acceptFriend(memberA, memberB);
		return retVal;
	}
	
	
	
	
	
	
	/**
	 *	From this part below are query actions 
	 */
	@Override 
	public int viewProfile(int requesterID, int profileOwnerID,
			HashMap<String, ByteIterator> result, boolean insertImage, boolean testMode) {
	
		return 0;
	
	}
	
	public int acceptFriend(int inviterID, int inviteeID) {
		
		return 0;
	}
	
}
