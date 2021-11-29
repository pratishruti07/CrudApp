package example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController{

       List<Employee> list = new CopyOnWriteArrayList<>();
      
    private boolean equals;
     @GetMapping("/welcome")
     public String welcome(){
         return "HII ";
     }

     @PostMapping("/AddStr")
     public String addString(@RequestBody Add a){
         return "sum="+(a.a+a.b);
     }

    @GetMapping("/add/{a}/{b}")
     
         public int add(@PathVariable int a,@PathVariable int b){
             return(a+b);
         }

         @GetMapping("/sum/{a}/{b}")
     
         public int sum(@PathVariable int a,@PathVariable int b){
             return(a*b);
         }  

         @PostMapping("/addEmployee")
         public List<Employee> addEmployee(@RequestBody List<Employee> e ){
             for(Employee employee:e){
                list.add(employee);
             }
            
         return e;
        
     }
     @GetMapping("/getEmployee")
     public List<Employee> getEmployee(){
    return list ;
     }
     
     @GetMapping("/deleteEmp/{name}")
     public List<Employee> removeEmployee(@PathVariable("name") String name ) {
        for(Employee employee:list){
            if(employee.getName().equals(name)){
                list.remove(employee);
            }
        }    
     return list;
     }
    

    @PostMapping("/strMatch")
    public Boolean comp(@RequestBody StringMatch s){
       
          Boolean  isEquals = s.str1.equals(s.Str2);
          
          return isEquals;
}

}