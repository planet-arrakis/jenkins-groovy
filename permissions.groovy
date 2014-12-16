import hudson.security.*

// If you have list of jobs:
jobs = []
for (j in ["ABC", "DEF", "GHI"]) {
    jobs += Jenkins.instance.getJob(j)
}
 
// If you have encapsulated views with jobs:
// E.g.: for http://11.16.154.98:8080/jenkins/view/CodeGating/view/Apollo/view/.15A/:
// jobs = Jenkins.instance.getView("CodeGating").getView("Apollo").getView(".15A").getItems()
//
//jobs = Jenkins.instance.getView("ABC").getView("DEF").getView("GHI").getItems()

users =  ["user1", "user2", "user3"]
rights = [Item.READ, Item.BUILD]
 
jobs.each {
    amp = it.getProperty(AuthorizationMatrixProperty)
    if (amp == null) {
	amp = new AuthorizationMatrixProperty()
    }
    for (u in users) {
        for (r in rights) {
            amp?.add(r,u)
        }
    }
    it.addProperty(amp)
    it.save()
}
