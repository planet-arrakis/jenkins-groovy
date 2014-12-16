import hudson.model.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import hudson.tasks.LogRotator
def jobs = Hudson.instance.items
   
def pattern = ~/SDP_3.37.X.*/
def newNumToKeep = 20
 
jobs.findAll{ it.logRotator && !it.disabled }.each {
   if (! pattern.matcher(it.name).matches() ) {
      return
   }
   println it.name;
    
   oldRotator = it.getLogRotator()
    
   daysToKeep = oldRotator.getDaysToKeep()
   numToKeep = oldRotator.getNumToKeep() 
   artifactDaysToKeep = oldRotator.getArtifactDaysToKeep() 
   artifactNumToKeep = oldRotator.getArtifactNumToKeep() 
 
   it.setLogRotator(new LogRotator(daysToKeep, newNumToKeep, artifactDaysToKeep, artifactNumToKeep))
   
   it.save()
}