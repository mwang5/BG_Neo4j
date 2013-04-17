package neo4j;

public interface Neo4jConstraints {
	public static final String NEO4J_URL_PROPERTY = "neo4j.url";
	public static final String NEO4J_DB_PROPERTY = "neo4j.database";
	
	public static final String NEO4J_SHARDING_PROPERTY = "sharding";
	public static final String NEO4J_SHARDING_PROPERTY_DEFAULT = "false";
	public static final String NEO4J_MANIPULATION_ARRAY_PROPERTY = "manipulationarray";
	public static final String NEO4J_MANIPULATION_ARRAY_PROPERTY_DEFAULT= "false";
	public static final String NEO4J_FRNDLIST_REQ_PROPERTY = "friendlistreq";
	public static final String NEO4J_FRNDLIST_REQ_PROPERTY_DEFAULT = "false";
}
