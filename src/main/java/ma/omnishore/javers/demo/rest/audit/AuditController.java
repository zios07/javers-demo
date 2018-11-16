package ma.omnishore.javers.demo.rest.audit;

import java.util.ArrayList;
import java.util.List;

import org.javers.core.Javers;
import org.javers.core.diff.Change;
import org.javers.core.diff.Diff;
import org.javers.core.metamodel.object.CdoSnapshot;
import org.javers.repository.jql.QueryBuilder;
import org.javers.shadow.Shadow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.omnishore.javers.demo.domain.Person;

@RestController
@RequestMapping(value = "/audit")
public class AuditController {

    private final Javers javers;

    @Autowired
    public AuditController(Javers javers) {
        this.javers = javers;
    }

    @RequestMapping("/hello-world")
    public String getPersonChanges() {
        return "Hello ! I'am ready :D";
    }

    @RequestMapping("/person")
    public String demo() {
        QueryBuilder jqlQuery = QueryBuilder.byClass(Person.class);

        List<Change> changes = javers.findChanges(jqlQuery.build());

        return javers.getJsonConverter().toJson(changes);
    }
    
    @RequestMapping("/person/{id}")
    public String getPersonChanges(@PathVariable Long id) {
        QueryBuilder jqlQuery = QueryBuilder.byInstanceId(id, Person.class);

        List<Change> changes = javers.findChanges(jqlQuery.build());

        return javers.getJsonConverter().toJson(changes);
    }
    
    @RequestMapping("/person/{id}/snapshot")
    public String getPersonSnapshots(@PathVariable Long id) {
    	
        QueryBuilder jqlQuery = QueryBuilder.byInstanceId(id, Person.class);

        List<CdoSnapshot> changes = javers.findSnapshots(jqlQuery.build());

        return javers.getJsonConverter().toJson(changes);
    }
    
    @RequestMapping("/person/{id}/shadow")
    public String getPersonShadows(@PathVariable Long id) {
    	
        QueryBuilder jqlQuery = QueryBuilder.byInstanceId(id, Person.class);

        List<Shadow<Person>> changes = javers.findShadows(jqlQuery.build());

        return javers.getJsonConverter().toJson(changes);
    }
    
    @RequestMapping("demo/{id}")
    public String demoChanges(@PathVariable Long id) {
    	QueryBuilder jqlQuery = QueryBuilder.byInstanceId(id, Person.class);
    	List<Diff> result = new ArrayList<>();

        List<Shadow<Person>> changes = javers.findShadows(jqlQuery.build());
//        if(!changes.isEmpty() && changes.size() % 2 == 0)
        	for(int i = 0 ; i < changes.size() - 1 ; i++) {
            	result.add(javers.compare(changes.get(i).get(), changes.get(i+1).get()));
            }
        return javers.getJsonConverter().toJson(result);
    }
    
}