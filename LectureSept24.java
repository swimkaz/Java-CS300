
public class LectureSept24 {
  //another mechanism for methods to return values
  //methods - return value, or throw exception
  //try { returnValue = methodCall();}
  //catch(Exception e){thrownValue = e;}
  //separating the happy path from the exception handling code can be helpful
  //place the main idea before exceptions and conditions
  //A tale of two happy paths
  //try{
    //happy();
    //path()
    //through();
    //code();
//} catch(Problem1exceptione){
 // handeleFirstKindOfProblem();
 //} catch (Problem2exceptione){
  // handeleSecondKindOfProblem();
  
  //Second one: photo on phone
  
  
  //could call method again to allow user chance to fix-- return method();
  //handle it
  //do not necessarily have to put a throw block in try
  //can do several types of errors, using the or "|";
  //finally block: put code that will run regardless of what happens to preceding blocks
  //try catch blocks will stop working if there is a thrown exception that is not catched
  //FINALLY: unlock that file 
  
  
  //runtime = unchecked exception
  //relative vs absolute directions; describing the location
  //relative: filename, ../folderName/fileName ..>means to go out of folder
  //absolute: drive/folderName/fileName.      driverName:\folderName\otherFolder\fileName
  //ex on phone galler ; add IO
  //add close() method;
  
}
