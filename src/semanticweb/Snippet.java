package semanticweb;

import org.apache.jena.query.* ;
//import org.apache.jena.rdf.model.ModelFactory ;

public class Snippet {
	public static void main(String[] args) {
		System.out.println("It is my SPARQL query");
		String serviceURI = "http://localhost:3030/UniversityOnto/sparql";
		String queryString = 
	            " PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n"
	            + "PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\n"
	            + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n"
	            + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\n"
	            + "PREFIX test: <http://www.cs.ccsu.edu/ParvathyKumar/University.owl#> \r\n"
	            + "SELECT ?x ?author ?title ?y\r\n"
	            + "WHERE \r\n"
	            + "{\r\n"
	            + "   ?x a test:Publications .\r\n"
	            + "   ?x test:author ?author .\r\n"
	            + "   ?x test:title ?title .\r\n"
	            + "   ?x test:is_Used_By ?y .\r\n"
	            + "}" ;
	        Query query = QueryFactory.create(queryString) ;
	        
	        //try (QueryExecution qexec = QueryExecutionFactory.create(query, ModelFactory.createDefaultModel())) {
	        try (QueryExecution qexec = QueryExecutionFactory.sparqlService(serviceURI, query)){
	            ResultSet rs = qexec.execSelect() ;
	            ResultSetFormatter.out(System.out, rs, query) ;
	        }
	}
}

