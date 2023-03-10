import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

public class QueryExample {
	public static void main(String [] args) {
		
		//Store the file path in a string
		String OWLpath = "Resources/geography.owl";
		
		//create a model
		Model model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
		//model reads the file path
		model.read(OWLpath);
					
	
		//query show all the data
		String fullQuery = 
				"PREFIX rdf:  <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
				+"PREFIX owl: <https://www.w3.org/2002/07/owl#>"
				+"PREFIX rdfs: <https://www.w3.org/2000/01/rdf-schema#>"
				+"SELECT DISTINCT ?Data ?Type "
				+"WHERE "
				+"{"
				+ "		?Data rdf:type ?Type ."
				+" } ORDER BY ?Type "; 
		
		
		//Execute queries
			Query q = QueryFactory.create(catgQuery);
			QueryExecution qexec = QueryExecutionFactory.create(catgQuery, model);
			ResultSet resultsetq1 = qexec.execSelect();
			ResultSetFormatter.out(resultsetq1);
			
			Query q2 = QueryFactory.create(fullQuery);
			QueryExecution qexec2 = QueryExecutionFactory.create(fullQuery, model);
			ResultSet resultsetq2 = qexec2.execSelect();
			ResultSetFormatter.out(resultsetq2);
		
		
		}
		
				
		
	}
